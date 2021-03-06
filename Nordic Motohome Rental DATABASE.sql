--Lavet af alle medlemmer
DROP DATABASE IF EXISTS nordicMotorhome;
CREATE DATABASE nordicMotorhome;

USE nordicMotorhome;

CREATE TABLE customers
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(45) NOT NULL,
    cpr VARCHAR(20) NOT NULL UNIQUE,
    phone VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    zipCode VARCHAR(45) NOT NULL,
    driverLicenseNumber VARCHAR(45) NOT NULL,
    driverLicenseDate DATE NOT NULL
);


CREATE TABLE motorhomes -- Lavet af LHD;
(
    licensePlate VARCHAR(45) PRIMARY KEY,
    brand VARCHAR(45) NOT NULL,
    model VARCHAR(45) NOT NULL,
    pricePerDay INT NOT NULL,
    seats INT NOT NULL,
    beds INT NOT NULL,
    fuelType VARCHAR(45) NOT NULL,
    gear VARCHAR(45) NOT NULL,
    odometer INT NOT NULL,
    registrationDate DATE NOT NULL,
    lengthAndHeight VARCHAR(45) NOT NULL,
    type VARCHAR(45) NOT NULL,
    fridge BOOLEAN NOT NULL,
    toilet BOOLEAN NOT NULL,
    awning BOOLEAN NOT NULL
);

CREATE TABLE economy -- Lavet af LHD;
(
    licensePlate VARCHAR(45) PRIMARY KEY,
    gasBurners INT NOT NULL,
    FOREIGN KEY (licensePlate) REFERENCES motorhomes(licensePlate)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE standard -- Lavet af LHD;
(
    licensePlate VARCHAR(45) PRIMARY KEY,
    shower BOOLEAN NOT NULL,
    elStove BOOLEAN NOT NULL,
    FOREIGN KEY (licensePlate) REFERENCES motorhomes(licensePlate)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE luxury -- Lavet af LHD;
(
    licensePlate VARCHAR(45) PRIMARY KEY,
    tv BOOLEAN NOT NULL,
    rearViewCamera BOOLEAN NOT NULL,
    FOREIGN KEY (licensePlate) REFERENCES standard(licensePlate)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE contracts -- Lavet af LHD & BAWG;
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    fromDate DATE NOT NULL,
    toDate DATE NOT NULL,
    numberOfDays INT NOT NULL,
    carId VARCHAR(45) NOT NULL,
    customId INT NOT NULL,
    maxKM INT NOT NULL,
    price DOUBLE NOT NULL,
    staff VARCHAR(45) NOT NULL,
  --  pickUp VARCHAR(45),
  --  pickDistance DOUBLE,
  --  dropOff VARCHAR(45),
   -- dropDistance DOUBLE,
    active BOOL,
    FOREIGN KEY (carId) REFERENCES motorhomes(licensePlate) ON UPDATE CASCADE,
    FOREIGN KEY (customId) REFERENCES customers(id)
);

CREATE TABLE points
(
id INT AUTO_INCREMENT PRIMARY KEY,
pickUp VARCHAR(45) NOT NULL,
pickDistance DOUBLE NOT NULL,
dropOff VARCHAR(45) NOT NULL,
dropDistance DOUBLE NOT NULL,
contract_id INT NOT NULL,
FOREIGN KEY(contract_id) REFERENCES contracts(id) ON DELETE CASCADE
);

CREATE TABLE accessories
(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
amount_available INT NOT NULL,
amount_total INT NOT NULL,
price INT NOT NULL
);

CREATE TABLE accessory_contract
(
accessory_id INT NOT NULL,
contract_id INT NOT NULL,
FOREIGN KEY (accessory_id) REFERENCES accessories(id) ON DELETE CASCADE,
FOREIGN KEY (contract_id) REFERENCES contracts(id) ON DELETE CASCADE
);

CREATE TABLE seasons (
	id INT PRIMARY KEY AUTO_INCREMENT,
    start_date DATE ,
    end_date DATE,
    `type` VARCHAR(10)
);

CREATE TABLE staffs (
	id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45),
    initials VARCHAR(5)
);

DROP USER IF EXISTS 'user'@'localhost';
CREATE USER 'user'@'localhost' IDENTIFIED BY '1234567890';
GRANT ALL PRIVILEGES ON nordicMotorhome.* TO 'user'@'localhost';