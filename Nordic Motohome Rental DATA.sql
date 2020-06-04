USE nordicMotorhome;

INSERT INTO customers() VALUES ('1', 'Steve Nielsen', '35', 'Stevesmail@gmail.com', '220585-1232', '+45 34 21 67 65', 'Stringvejen 15', '4356', '35421567', '2006-09-12');
INSERT INTO customers() VALUES ('2', 'Harry Jensen', '47', 'Harrysmail@gmail.com', '459635-1456', '+45 56 78 25 65', 'Banghusvej 21', '4562', '35421568', '2005-02-21');
INSERT INTO customers() VALUES ('3', 'Lena Christensen', '27', 'Lenasmail@gmail.com', '145665-4563', '+45 46 54 12 65', 'Smirnofvej 01', '2544', '35421569', '2012-12-11');
INSERT INTO customers() VALUES ('4', 'Bob Prise', '56', 'Bobsmail@gmail.com', '785465-4569', '+45 75 54 67 75', 'Colgatevej 13', '3254', '35421570', '2007-03-20');
INSERT INTO customers() VALUES ('5', 'Carl Irse', '34', 'Carlsmail@gmail.com', '325654-7854', '+45 45 65 66 12', 'Chokovej 45', '7412', '35421571', '2007-11-14');
INSERT INTO customers() VALUES ('6', 'Benjamin Ciruct', '75', 'Benjaminsmail@gmail.com', '985245-1236', '+45 75 95 55 10', 'Penalusvej 11', '1111', '35421572', '2008-05-19');
INSERT INTO customers() VALUES ('7', 'Kurt Colga', '45', 'Kurtsmail@gmail.com', '658999-6541', '+45 65 65 10 75', 'SpriseVej 32', '2065', '35421573', '2002-09-16');
INSERT INTO customers() VALUES ('8', 'Lars Mihagel', '45', 'Larssmail@gmail.com', '652123-1111', '+45 85 65 75 35', 'Hurlumvej 42', '5412', '35421574', '2001-07-07');
INSERT INTO customers() VALUES ('9', 'Mikkel Resu', '97', 'Mikkelsmail@gmail.com', '854789-8542', '+45 75 15 15 15', 'Skæærøvej 62', '8541', '35421575', '2014-10-08');
INSERT INTO customers() VALUES ('10', 'Hans Nielsen', '65', 'Hanssmail@gmail.com', '652125-8563', '+45 98 75 25 66', 'BrevSøVej 02', '3210', '35421576', '2003-06-15');
INSERT INTO customers() VALUES ('11', 'Randi Korsa', '45', 'Randismail@gmail.com', '854563-2587', '+45 75 75 00 00', 'SportGade 72', '4123', '35421577', '2003-05-15');
INSERT INTO customers() VALUES ('12', 'Egon Magnussen', '38', 'Egonsmail@gmail.com', '254123-1235', '+45 42 77 00 46', 'SoveStræde 91', '4123', '35421578', '2018-05-12');

-- Economy
/*INSERT INTO motorhomes() VALUES (licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear (varchar), odometer,
                                registrationDate, lengthAndHeight VARCHAR(45), type VARCHAR(45), fridge BOOLEAN, toilet BOOLEAN,
                                awning BOOLEAN);
INSERT INTO economy() VALUES (licensePlate, gasBurners);*/

INSERT INTO motorhomes() VALUES ('BG 23 432', 'Citroen', '2CV', 200, 4, 2, 'Benzin', 'Manuel', 99865,
                                 '2017-02-02', 'L: 4m H: 2m', 'Økonomi', true, true, true);
INSERT INTO economy() VALUES ('BG 23 432', 3);

INSERT INTO motorhomes() VALUES ('BG 23 433', 'Citroen', '2CV', 200, 4, 2, 'Benzin', 'Manuel', 64930,
                                 '2017-02-02', 'L: 4m H: 2m', 'Økonomi', true, true, true);
INSERT INTO economy() VALUES ('BG 23 433', 3);

INSERT INTO motorhomes() VALUES ('BG 23 434', 'Citroen', '2CV', 200, 4, 2, 'Benzin', 'Manuel', 110484,
                                 '2017-02-02', 'L: 4m H: 2m', 'Økonomi', true, true, true);
INSERT INTO economy() VALUES ('BG 23 434', 3);

INSERT INTO motorhomes() VALUES ('BG 23 435', 'Citroen', '2CV', 200, 4, 2, 'Benzin', 'Manuel', 74743,
                                 '2017-02-02', 'L: 4m H: 2m', 'Økonomi', true, true, true);
INSERT INTO economy() VALUES ('BG 23 435', 3);


INSERT INTO motorhomes() VALUES ('HC 22 142', 'Lada', 'GF8', 100, 3, 2, 'Benzin', 'Manuel', 87723,
                                 '2010-03-05', 'L: 3.5m H: 2m', 'Økonomi', false, false, false);
INSERT INTO economy() VALUES ('HC 22 142', 2);

INSERT INTO motorhomes() VALUES ('HC 22 143', 'Lada', 'GF8', 100, 3, 2, 'Benzin', 'Manuel', 93438,
                                 '2010-03-05', 'L: 3.5m H: 2m', 'Økonomi', false, false, false);
INSERT INTO economy() VALUES ('HC 22 143', 2);

INSERT INTO motorhomes() VALUES ('HC 22 144', 'Lada', 'GF8', 100, 3, 2, 'Benzin', 'Manuel', 232990,
                                 '2010-03-05', 'L: 3.5m H: 2m', 'Økonomi', false, false, false);
INSERT INTO economy() VALUES ('HC 22 144', 2);

INSERT INTO motorhomes() VALUES ('HC 22 145', 'Lada', 'GF8', 100, 3, 2, 'Benzin', 'Manuel', 37383,
                                 '2010-03-05', 'L: 3.5m H: 2m', 'Økonomi', false, false, false);
INSERT INTO economy() VALUES ('HC 22 145', 2);


INSERT INTO motorhomes() VALUES ('KY 76 375', 'Volkswagen', 'BM3', 300, 4, 3, 'Benzin', 'Manuel', 847874,
                                 '2016-01-010', 'L: 4.5m H: 2m', 'Økonomi', true, true, true);
INSERT INTO economy() VALUES ('KY 76 375', 4);

INSERT INTO motorhomes() VALUES ('KY 76 376', 'Volkswagen', 'BM3', 300, 4, 3, 'Benzin', 'Manuel', 45454,
                                 '2016-01-010', 'L: 4.5m H: 2m', 'Økonomi', true, true, true);
INSERT INTO economy() VALUES ('KY 76 376', 4);

INSERT INTO motorhomes() VALUES ('KY 76 377', 'Volkswagen', 'BM3', 300, 4, 3, 'Benzin', 'Manuel', 34344,
                                 '2016-01-010', 'L: 4.5m H: 2m', 'Økonomi', true, true, true);
INSERT INTO economy() VALUES ('KY 76 377', 4);

INSERT INTO motorhomes() VALUES ('KY 76 378', 'Volkswagen', 'BM3', 300, 4, 3, 'Benzin', 'Manuel', 76767,
                                 '2016-01-010', 'L: 4.5m H: 2m', 'Økonomi', true, true, true);
INSERT INTO economy() VALUES ('KY 76 378', 4);


-- Standard
/*INSERT INTO motorhomes() VALUES (licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear (varchar), odometer,
                                registrationDate, lengthAndHeight VARCHAR(45), type VARCHAR(45), fridge BOOLEAN, toilet BOOLEAN,
                                awning BOOLEAN);
INSERT INTO standard() VALUES (licensePlate, shower, elStove);*/

INSERT INTO motorhomes() VALUES ('LD 12 345', 'Ford', 'AutoModel', 400, 6, 4, 'Diesel', 'Automat', 354646,
                                 '2019-02-02', 'L: 4m H: 2m', 'Standard', true, true, true);
INSERT INTO standard() VALUES ('LD 12 345', true, true);

INSERT INTO motorhomes() VALUES ('LD 12 346', 'Ford', 'AutoModel', 400, 6, 4, 'Diesel', 'Automat', 34353,
                                 '2019-02-02', 'L: 4m H: 2m', 'Standard', true, true, true);
INSERT INTO standard() VALUES ('LD 12 346', true, true);

INSERT INTO motorhomes() VALUES ('LD 12 347', 'Ford', 'AutoModel', 400, 6, 4, 'Diesel', 'Automat', 343434,
                                 '2019-02-02', 'L: 4m H: 2m', 'Standard', true, true, true);
INSERT INTO standard() VALUES ('LD 12 347', true, true);

INSERT INTO motorhomes() VALUES ('LD 12 348', 'Ford', 'AutoModel', 400, 6, 4, 'Diesel', 'Automat', 345454,
                                 '2019-02-02', 'L: 4m H: 2m', 'Standard', true, true, true);
INSERT INTO standard() VALUES ('LD 12 348', true, true);


INSERT INTO motorhomes() VALUES ('JD 92 474', 'Toyota', 'B6M', 450, 6, 4, 'Diesel', 'Automat', 54666,
                                 '2018-04-02', 'L: 4m H: 2m', 'Standard', true, true, true);
INSERT INTO standard() VALUES ('JD 92 474', true, true);

INSERT INTO motorhomes() VALUES ('JD 92 475', 'Toyota', 'B6M', 450, 6, 4, 'Diesel', 'Automat', 343556,
                                 '2018-04-02', 'L: 4m H: 2m', 'Standard', true, true, true);
INSERT INTO standard() VALUES ('JD 92 475', true, true);

INSERT INTO motorhomes() VALUES ('JD 92 476', 'Toyota', 'B6M', 450, 6, 4, 'Diesel', 'Automat', 34453,
                                 '2018-04-02', 'L: 4m H: 2m', 'Standard', true, true, true);
INSERT INTO standard() VALUES ('JD 92 476', true, true);

INSERT INTO motorhomes() VALUES ('JD 92 477', 'Toyota', 'B6M', 450, 6, 4, 'Diesel', 'Automat', 456543,
                                 '2018-04-02', 'L: 4m H: 2m', 'Standard', true, true, true);
INSERT INTO standard() VALUES ('JD 92 477', true, true);


INSERT INTO motorhomes() VALUES ('JF 34 745', 'Opel', 'Astra', 500, 6, 4, 'Diesel', 'Automat', 546433,
                                 '2015-03-22', 'L: 5m H: 2.5m', 'Standard', true, true, true);
INSERT INTO standard() VALUES ('JF 34 745', true, true);

INSERT INTO motorhomes() VALUES ('JF 34 746', 'Opel', 'Astra', 500, 6, 4, 'Diesel', 'Automat', 767554,
                                 '2015-03-22', 'L: 5m H: 2.5m', 'Standard', true, true, true);
INSERT INTO standard() VALUES ('JF 34 746', true, true);

INSERT INTO motorhomes() VALUES ('JF 34 747', 'Opel', 'Astra', 500, 6, 4, 'Diesel', 'Automat', 343567,
                                 '2015-03-22', 'L: 5m H: 2.5m', 'Standard', true, true, true);
INSERT INTO standard() VALUES ('JF 34 747', true, true);

INSERT INTO motorhomes() VALUES ('JF 34 748', 'Opel', 'Astra', 500, 6, 4, 'Diesel', 'Automat', 343565,
                                 '2015-03-22', 'L: 5m H: 2.5m', 'Standard', true, true, true);
INSERT INTO standard() VALUES ('JF 34 748', true, true);

-- Luxury
/*INSERT INTO motorhomes() VALUES (licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear (varchar), odometer,
                                registrationDate, lengthAndHeight VARCHAR(45), type VARCHAR(45), fridge BOOLEAN, toilet BOOLEAN,
                                awning BOOLEAN);
INSERT INTO standard() VALUES (licensePlate, shower, elStove);
INSERT INTO standard() VALUES (licensePlate, tv, rearViewCamera);*/

INSERT INTO motorhomes() VALUES ('CN MS 123', 'Tesla', 'Model 5', 700, 8, 6, 'Diesel', 'Automat', 454838,
                                 '2019-12-02', 'L: 3,75m H: 2,5m', 'Luksus', true, true, true);
INSERT INTO standard() VALUES ('CN MS 123', true, true);
INSERT INTO luxury() VALUES ('CN MS 123', true, true);
INSERT INTO motorhomes() VALUES ('CN MS 124', 'Tesla', 'Model 5', 700, 8, 6, 'Diesel', 'Automat', 33434,
                                 '2019-12-02', 'L: 3,75m H: 2,5m', 'Luksus', true, true, true);
INSERT INTO standard() VALUES ('CN MS 124', true, true);
INSERT INTO luxury() VALUES ('CN MS 124', true, true);
INSERT INTO motorhomes() VALUES ('CN MS 125', 'Tesla', 'Model 5', 700, 8, 6, 'Diesel', 'Automat', 553343,
                                 '2019-12-02', 'L: 3,75m H: 2,5m', 'Luksus', true, true, true);
INSERT INTO standard() VALUES ('CN MS 125', true, true);
INSERT INTO luxury() VALUES ('CN MS 125', true, true);
INSERT INTO motorhomes() VALUES ('CN MS 126', 'Tesla', 'Model 5', 700, 8, 6, 'Diesel', 'Automat', 34343,
                                 '2019-12-02', 'L: 3,75m H: 2,5m', 'Luksus', true, true, true);
INSERT INTO standard() VALUES ('CN MS 126', true, true);
INSERT INTO luxury() VALUES ('CN MS 126', true, true);

INSERT INTO motorhomes() VALUES ('OV 52 815', 'Skoda', 'Fabia', 600, 7, 6, 'Diesel', 'Automat', 33535,
                                 '2012-10-01', 'L: 3,75m H: 2,5m', 'Luksus', true, true, true);
INSERT INTO standard() VALUES ('OV 52 815', true, true);
INSERT INTO luxury() VALUES ('OV 52 815', true, false);
INSERT INTO motorhomes() VALUES ('OV 52 816', 'Skoda', 'Fabia', 600, 7, 6, 'Diesel', 'Automat', 343553,
                                 '2012-10-01', 'L: 3,75m H: 2,5m', 'Luksus', true, true, true);
INSERT INTO standard() VALUES ('OV 52 816', true, true);
INSERT INTO luxury() VALUES ('OV 52 816', true, false);
INSERT INTO motorhomes() VALUES ('OV 52 817', 'Skoda', 'Fabia', 600, 7, 6, 'Diesel', 'Automat', 334343,
                                 '2012-10-01', 'L: 3,75m H: 2,5m', 'Luksus', true, true, true);
INSERT INTO standard() VALUES ('OV 52 817', true, true);
INSERT INTO luxury() VALUES ('OV 52 817', true, false);
INSERT INTO motorhomes() VALUES ('OV 52 818', 'Skoda', 'Fabia', 600, 7, 6, 'Diesel', 'Automat', 355454,
                                 '2012-10-01', 'L: 3,75m H: 2,5m', 'Luksus', true, true, true);
INSERT INTO standard() VALUES ('OV 52 818', true, true);
INSERT INTO luxury() VALUES ('OV 52 818', true, false);

-- Contract
/*INSERT INTO contracts() VALUES (id, fromDate, toDate, carId, customerId, maxKM, price, staffName, active);*/

INSERT INTO contracts() VALUES (DEFAULT, '2020-05-22', '2020-05-31', '9', 'BG 23 432', 1, '3600', '1800', 'James Raynor', 1);
INSERT INTO contracts() VALUES (DEFAULT, '2020-05-22', '2020-05-27', '9', 'BG 23 432', 1, '3600', '1800', 'James Raynor', 0); -- test af inaktiv kontrakt

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
