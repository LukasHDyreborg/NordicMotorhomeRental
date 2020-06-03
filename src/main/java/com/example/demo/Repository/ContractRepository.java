package com.example.demo.Repository;

import com.example.demo.Model.Accessory;
import com.example.demo.Model.Contract;
import com.example.demo.Model.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContractRepository {
    @Autowired
    JdbcTemplate template;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MotorhomeRepository motorhomeRepository;
    @Autowired
    SeasonRepository seasonRepository;
    @Autowired
    AccessoryRepository accessoryRepository;

    public List<Contract> fetchAll() {
        //IFNULL(expression, altvalue) hvis det ikke er null, selects expression. hvis det er null, selects altvalue
        String sql = "SELECT c.id, fromDate, toDate, numberOfDays, carId, customId, maxKM, price, staff, p.pickUp, IFNULL(p.pickDistance, 0) AS pickDistance, " +
                "p.dropOff, IFNULL(p.dropDistance, 0) AS dropDistance FROM contracts c " +
                "LEFT JOIN points p ON c.id = p.contract_id WHERE c.active = 1 ORDER BY c.id";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        List<Contract> contractList = template.query(sql, rowMapper);
        //assigns accessories to contract
        for (Contract contract : contractList) {
            contract.setAccessoryList(fetchContractAccessories(contract));
        }
        //assigns customer and vehicle to contract
        for (Contract contract : contractList) {
            fetchContractObjects(contract);
        }
        return contractList;
    }

    public List<Contract> fetchAllArchive() {
        String sql = "SELECT c.id, fromDate, toDate, numberOfDays, carId, customId, maxKM, price, staff, p.pickUp, IFNULL(p.pickDistance, 0) AS pickDistance, " +
                "p.dropOff, IFNULL(p.dropDistance, 0) AS dropDistance FROM contracts c " +

                "LEFT JOIN points p ON c.id = p.contract_id WHERE c.active = 0 ORDER BY c.id";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        List<Contract> contractList = template.query(sql, rowMapper);
        //assigns accessories to contract
        for (Contract contract : contractList) {
            contract.setAccessoryList(fetchContractAccessories(contract));
        }
        //assigns customer and vehicle to contract
        for (Contract contract : contractList) {
            fetchContractObjects(contract);
        }
        return contractList;
    }

    public boolean add(Contract c, int[] accessory) {
        try{
            c.setId(IdRetriever.retrieveID("id", "contracts")); //pulls ID from database, we'll need it for our accessory_contract intermediary table //returns highest id + 1

            c.setAccessoryList(new ArrayList<>());//assigns it an arraylist since it will be null by default
            //adds accessories from list
            for (int value : accessory) {
                c.getAccessoryList().add(accessoryRepository.findById(value));
            }
            accessoryRepository.decreaseAvailable(c.getAccessoryList()); //decreases available accessories

            fetchContractObjects(c); // assigns car and customer to list. We use it to calculate price
            c.setDays(); //sets number of days based on from and to date
            assignPrice(c);//assigns price based on amount of days
            c.setMaxKM(c.getNumberOfDays() * 400); //assigns max km

            //Inserts into database
            String sql = "INSERT INTO contracts() VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 1)";//1 = active
            template.update(sql, c.getId(), c.getFromDate(), c.getToDate(), c.getNumberOfDays(), c.getCarId(),
                    c.getCustomId(), c.getMaxKM(), c.getPrice(), c.getStaff());

            sql = "INSERT INTO points() VALUES (DEFAULT, ?, ?, ?, ?, ?)";
            template.update(sql, c.getPickUp(), c.getPickDistance(), c.getDropOff(), c.getDropDistance(), c.getId());

            //inserts into intermediary table between accessories and contracts.
            for (int value : accessory) {
                sql = "INSERT INTO accessory_contract () VALUES (?,?)";
                template.update(sql, value, c.getId());
            }
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public Contract findById(int id) {
        String sql = "SELECT c.id, fromDate, toDate, numberOfDays, carId, customId, maxKM, price, staff, pickUp, IFNULL(pickDistance, 0) AS pickDistance, dropOff, IFNULL(dropDistance,0) AS dropDistance FROM contracts c " +
                "LEFT JOIN points p ON c.id = p.contract_id WHERE c.id = ?";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        Contract contract = template.queryForObject(sql, rowMapper, id);

        contract.setAccessoryList(fetchContractAccessories(contract)); //assigns accessories
        fetchContractObjects(contract); //Assigns the contract we just retrieved a customer and vehicle.

        return contract;
    }

    public Contract findActiveById(int id) { //works much the same as in findById(id), but this one returns null if the object is inactive
        try{
            String sql = "SELECT c.id, fromDate, toDate, numberOfDays, carId, customId, maxKM, price, staff, p.pickUp, IFNULL(p.pickDistance, 0) AS pickDistance, p.dropOff, IFNULL(p.dropDistance, 0) AS dropDistance FROM contracts c " +
                    "LEFT JOIN points p ON c.id = p.contract_id WHERE c.id = ? AND c.active = 1";
            RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
            Contract contract = template.queryForObject(sql, rowMapper, id);

            contract.setAccessoryList(fetchContractAccessories(contract));
            fetchContractObjects(contract); //Assigns the contract we just retrieved a customer and vehicle.

            return contract;
        }catch (Exception e){
            return null;
        }
    }

    public Boolean delete(int id) {
        Contract contract = findActiveById(id); //will return contract if active (meaning it still has accessories) but will return null if contract is inactive (meaning accessories has already been let go)
        if(contract != null){
            accessoryRepository.increaseAvailable(contract.getAccessoryList()); //lets accessories availability rise.
        }
        try{
            String sql = "DELETE FROM contracts WHERE id = ?";
            template.update(sql, id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Contract update(Contract c, int[] accessories, boolean newPrice) {
        Contract contract = findById(c.getId()); //retrieves the contract we want to update
        accessoryRepository.increaseAvailable(contract.getAccessoryList()); //increases available, effectively doing a soft reset of availability (we decreased availability when creating contract)

        String sql = "DELETE FROM accessory_contract WHERE contract_id = ?"; //deletes all from accessory_contract. easier if we want to remove some accessories and add new ones
        template.update(sql, c.getId());

        for (int accessory : accessories) { //inserts into accessory_contract so we know which contract has which accessory
            sql = "INSERT INTO accessory_contract () VALUES (?, ?)";
            template.update(sql, accessory, c.getId());
        }
        c.setDays(); //calculates number of days between from and todate
        c.setMaxKM(c.getNumberOfDays() * 400); //automatically calculates maxKm based on number of days

        c.setAccessoryList(new ArrayList<>());//assigns it an arraylist since it will be null by default
        //adds accessories from list
        for (int accessory : accessories) {
            c.getAccessoryList().add(accessoryRepository.findById(accessory)); //adds accessories from array
        }

        if (newPrice) { //boolean , true = automatically calculate price, false = price manually entered will be saved
            fetchContractObjects(c); //motorhome, customer assigned to customer
            assignPrice(c); //calculates price
        }
        accessoryRepository.decreaseAvailable(c.getAccessoryList()); //decreases availability of accessories based on new accessories selected (or removed) see line 137. sort of :3

        sql = "UPDATE contracts SET fromDate = ?, toDate = ?, numberOfDays = ?, carId = ?, customId = ?, maxKM = ?, price = ?, staff = ? WHERE id = ?";
        template.update(sql, c.getFromDate(), c.getToDate(), c.getNumberOfDays(), c.getCarId(), c.getCustomId(), c.getMaxKM(), c.getPrice(), c.getStaff(), c.getId());

        sql = "UPDATE points SET pickUp = ?, pickDistance = ?, dropOff = ?, dropDistance = ? WHERE contract_id = ?"; //updates point table (pick/drop off points)
        template.update(sql, c.getPickUp(), c.getPickDistance(), c.getDropOff(), c.getDropDistance(), c.getId());

        return null;
    }

    public double endContract(Contract c, int odometer, boolean halfFull){
        accessoryRepository.increaseAvailable(c.getAccessoryList()); // "releases accessories" (increases available)
        double endFee = checkEndDateCost(c); //gets how much the fee is for cancelling (1 if not cancelled)
        double cost = c.getPrice(); //current contract price

        if(endFee == 1){ // 1 = it wasnt cancelled, calculate additional feed
            if(halfFull){ //Tilføjer ekstra kost hvis tanken er halv tom
                cost += 70; //det koster 70 euro (siger opgaven)
            }
            if(odometer - c.getMotorhome().getOdometer() > c.getMaxKM()) {//Hvis ny odometer minus gammel odometer > maxKM
                int extraKm = odometer - c.getMotorhome().getOdometer() - c.getMaxKM();
                cost += extraKm; //vi trækker original odometer fra nye odometer og ganger med 7.45(en euro per ekstra km)
            }
        }else{
            cost *= endFee;//the price is reduced based on how far back they cancelled -- >return money
        }
        String sql = "UPDATE contracts SET price = ?, active = ?, staff = ? WHERE id = ?";
        template.update(sql, cost, 0, c.getStaff(), c.getId()); //makes contract inactive

        motorhomeRepository.updateOdometer(c.getMotorhome(), odometer); //updates odometer

        return cost;
    }

    public void fetchContractObjects(Contract contract){
        contract.setCustomer(customerRepository.findById(contract.getCustomId()));
        contract.setMotorhome(motorhomeRepository.findById(contract.getCarId()));
    }

    public List<Accessory> fetchContractAccessories(Contract c){ //returns list of accessories to contract
        String sql = "SELECT a.id, a.name, a.amount_available, a.amount_total, a.price FROM accessory_contract ac JOIN accessories a ON ac.accessory_id = a.id JOIN contracts c ON ac.contract_id = c.id WHERE c.id = ?";
        RowMapper<Accessory> rowMapper = new BeanPropertyRowMapper<>(Accessory.class);

        return template.query(sql, rowMapper, c.getId());
    }

    public void assignPrice(Contract contract){
        //Makes sure its zero, so new calculation wont be added to old price
        contract.setPrice(0);
        //Calculates price based on season
        for(int i = 0; i < contract.getNumberOfDays(); i++){
            Season season;
            try{
                season = seasonRepository.findByDate(LocalDate.parse(contract.getFromDate()).plusDays(i+1)); //det virker til at den tager datoen for dagen før vores fromdate, så vi + 1
            }catch (Exception e){
                season = new Season();
                season.setType(""); //vi giver det en tom string eftersom den er null by default
            }
            //Gets motorhomes price
            double carPrice = contract.getMotorhome().getPricePerDay();
            //Multiplies based on season
            if(season.getType().equals("Høj")){
                carPrice *= 1.60;
            }else if(season.getType().equals("Middel")){
                carPrice *= 1.30;
            }else{
                carPrice *= 1;
            }
            //Sets price (price will increase after every iteration/loop)
            contract.setPrice(contract.getPrice() + carPrice);
        }
        //Calculates Accessories price
        if(contract.getAccessoryList()!=null || contract.getAccessoryList().size() != 0) {
            for (int i = 0; i < contract.getAccessoryList().size(); i++) { //loops through accessories in contract and adds price
                contract.setPrice(contract.getPrice() + contract.getAccessoryList().get(i).getPrice());
            }
        }
        //Adds price from pick-up point
        contract.setPrice(contract.getPrice() + (0.7 * contract.getPickDistance())); //0.7 euro * distance.
        //Adds price from drop-off point
        contract.setPrice(contract.getPrice() + (0.7 * contract.getDropDistance()));
    }

    public double checkEndDateCost(Contract c){
        LocalDate nowDate = LocalDate.now();
        LocalDate fromDate = LocalDate.parse(c.getFromDate());

        Period period = Period.between(nowDate, fromDate); // gets days between now and fromDate
        int days = period.getDays();

        //if nowDate is before fromDate contract = cancelled (cancelled = true)
        boolean cancelled = nowDate.isBefore(fromDate);

        if(cancelled) {
            if (days >= 50) {
                return 0.20;
            } else if (days >= 15) {
                return 0.50;
            } else if (days > 0) {
                return 0.80;
            } else if (days == 0) { //hvis man aflyser på dagen så skal man stadig betale 0.95%
                return 0.95;
            }
        }
        return 1; //returner 1 hvis den ikke blev aflyst
    }
}
