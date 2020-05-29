USE nordicMotorhome;

INSERT INTO customers() VALUES ('1', 'Steve Nielsen', '35', 'Stevesmail@gmail.com', '220585-1232', '+45 34 21 67 65', 'Stringvejen 15', '4356', '35421567', '2006-09-12');


-- Economy
/*INSERT INTO motorhomes() VALUES (licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear (varchar), odometer,
                                registrationDate, lengthAndHeight VARCHAR(45), type VARCHAR(45), fridge BOOLEAN, toilet BOOLEAN,
                                awning BOOLEAN);
INSERT INTO economy() VALUES (licensePlate, gasBurners);*/

INSERT INTO motorhomes() VALUES ('BG 23 432', 'Citroen', '2CV', 1000, 4, 2, 'Benzin', 'Manual', 100000,
                                 '2017-02-02', 'L: 4m H: 2m', 'Economy', true, true, true);
INSERT INTO economy() VALUES ('BG 23 432', 3);

-- Standard
/*INSERT INTO motorhomes() VALUES (licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear (varchar), odometer,
                                registrationDate, lengthAndHeight VARCHAR(45), type VARCHAR(45), fridge BOOLEAN, toilet BOOLEAN,
                                awning BOOLEAN);
INSERT INTO standard() VALUES (licensePlate, shower, elStove);*/

INSERT INTO motorhomes() VALUES ('LD 12 345', 'Ford', 'AutoModel', 1500, 6, 4, 'Diesel', 'Automatic', 150000,
                                 '2019-02-02', 'L: 4m H: 2m', 'Standard', true, true, true);
INSERT INTO standard() VALUES ('LD 12 345', true, true);

-- Luxury
/*INSERT INTO motorhomes() VALUES (licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear (varchar), odometer,
                                registrationDate, lengthAndHeight VARCHAR(45), type VARCHAR(45), fridge BOOLEAN, toilet BOOLEAN,
                                awning BOOLEAN);
INSERT INTO standard() VALUES (licensePlate, shower, elStove);
INSERT INTO standard() VALUES (licensePlate, tv, rearViewCamera);*/

INSERT INTO motorhomes() VALUES ('CN MS 123', 'Tesla', 'Model 5', 2500, 8, 6, 'Diesel', 'Automatic', 75000,
                                 '2019-12-02', 'L: 3,75m H: 2,5m', 'Luxury', true, true, true);
INSERT INTO standard() VALUES ('CN MS 123', true, true);
INSERT INTO luxury() VALUES ('CN MS 123', true, true);

-- Contract
/*INSERT INTO contracts() VALUES (id, fromDate, toDate, carId, customerId, maxKM, price, staffName, "pickup, pickDistance, dropOff, dropDistance", active);*/

INSERT INTO contracts() VALUES (DEFAULT, '2020-05-22', '2020-05-31', '9', 'BG 23 432', 1, '3600', '9000', 'James Raynor', /*null, 0, null, 0,*/ 1);
INSERT INTO contracts() VALUES (DEFAULT, '2020-05-22', '2020-05-27', '9', 'BG 23 432', 1, '3600', '9000', 'James Raynor', /*null, 0, null, 0,*/ 0); -- test af inaktiv kontrakt

-- points
-- INSERT INTO points() VALUES (DEFAULT, pickUp, pickDistance, dropOff, dropDistance, contract_id)
INSERT INTO points() VALUES (DEFAULT, 'Stranden 13', 27, 'Vejen 15', 16, 1);
INSERT INTO points() VALUES (DEFAULT, 'Lygten 37', 14, 'Lampen 14', 22, 2);

-- Seasons
-- INSERT INTO seasons () VALUES (id, start_date, end_date, `type`);                  Datoer er bare baseret på forår, sommer, efterår, vinter
INSERT INTO seasons() VALUES (DEFAULT, '2020-03-19', '2020-06-19','Middel');	-- forår
INSERT INTO seasons() VALUES (DEFAULT, '2020-06-20', '2020-09-21','Høj');     -- sommer
INSERT INTO seasons() VALUES (DEFAULT, '2020-09-22', '2020-12-20','Middel');  -- efterår
INSERT INTO seasons() VALUES (DEFAULT, '2020-12-21', '2021-03-18','Lav');     -- vinter

-- Staff
-- INSERT INTO staffs() VALUES (id, `name`, initials);
INSERT INTO staffs() VALUES (DEFAULT, 'Steve Jobs', 'SJ');
INSERT INTO staffs() VALUES (DEFAULT, 'Chris Anderson', 'CA');
INSERT INTO staffs() VALUES (DEFAULT, 'James Raynor', 'JR');

-- Accessories
-- INSERT INTO accessories () VALUES (id, `name`, amount_available INT, amount_total INT, price INT);
INSERT INTO accessories() VALUES (DEFAULT, 'Bike Rack', 18, 30, 50);
INSERT INTO accessories() VALUES (DEFAULT, 'Child Seat', 21, 30, 75);
INSERT INTO accessories() VALUES (DEFAULT, 'Picnic Table', 15, 30, 100);

-- Mellem link mellem kontrakt og accessories
-- accessory_contract
-- INSERT INTO accessory_contract () VALUES (accessory_id, contract_id);
INSERT INTO accessory_contract () VALUES (1, 1);
