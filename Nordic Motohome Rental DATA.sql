USE nordicMotorhome;

INSERT INTO customers() VALUES ('1', 'Steve Nielsen', '35', 'Stevesmail@gmail.com', '220585-1232', '+45 34 21 67 65', 'Stringvejen 15', '4356', '35421567', '2006-09-12');


-- Economy
/*INSERT INTO motorhomes() VALUES (licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear (varchar), odometer,
                                registrationDate, lengthAndHeight VARCHAR(45), type VARCHAR(45), fridge BOOLEAN, toilet BOOLEAN,
                                awning BOOLEAN);
INSERT INTO economy() VALUES (licensePlate, gasBurners);*/

INSERT INTO motorhomes() VALUES ('BG 23 432', 'Citroen', '2CV', 1000, 4, 2, 'Benzin', 'Manual', 100000,
                                 '2017-02-02', 'L: 4m H: 2m', 'Økonomi', true, true, true);
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
                                 '2019-12-02', 'L: 3,75m H: 2,5m', 'Luksus', true, true, true);
INSERT INTO standard() VALUES ('CN MS 123', true, true);
INSERT INTO luxury() VALUES ('CN MS 123', true, true);

-- Contract
/*INSERT INTO contracts() VALUES (id, fromDate, toDate, carId, customerId, maxKM, price);*/

INSERT INTO contracts() VALUES (DEFAULT, '2020-05-22', '2020-05-31', '9', 'BG 23 432', 1, '3600', '9000');