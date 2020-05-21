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
    zip_code VARCHAR(45) NOT NULL,
    driverLicenseNumber VARCHAR(45) NOT NULL,
    driverLicenseDate DATE NOT NULL/*,
    FOREIGN KEY (zip_code) REFERENCES city(zip_code)*/
);

CREATE TABLE motorhomes
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
    type VARCHAR(45) NOT NULL
);

CREATE TABLE economy
(
    licensePlate VARCHAR(45) PRIMARY KEY,
    fridge BOOLEAN NOT NULL,
    toilet BOOLEAN NOT NULL,
    gasBurners INT NOT NULL,
    awning BOOLEAN NOT NULL,
    FOREIGN KEY (licensePlate) REFERENCES motorhomes(licensePlate)
);

CREATE TABLE standard
(
    licensePlate VARCHAR(45) PRIMARY KEY,
    fridge BOOLEAN NOT NULL,
    toilet BOOLEAN NOT NULL,
    shower BOOLEAN NOT NULL,
    elStove BOOLEAN NOT NULL,
    awning BOOLEAN NOT NULL,
    tv BOOLEAN NOT NULL,
    rearViewCamera BOOLEAN NOT NULL,
    FOREIGN KEY (licensePlate) REFERENCES motorhomes(licensePlate)
);

CREATE TABLE luxury
(
    licensePlate VARCHAR(45) PRIMARY KEY,
    fridge BOOLEAN NOT NULL,
    toilet BOOLEAN NOT NULL,
    shower BOOLEAN NOT NULL,
    elStove BOOLEAN NOT NULL,
    awning BOOLEAN NOT NULL,
    tv BOOLEAN NOT NULL,
    rearViewCamera BOOLEAN NOT NULL,
    FOREIGN KEY (licensePlate) REFERENCES motorhomes(licensePlate)
);

CREATE TABLE contract
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    fromDate DATETIME NOT NULL,
    toDate DATETIME NOT NULL,
    carId VARCHAR(45) NOT NULL,
    customerId INT NOT NULL,
    maxKM INT NOT NULL,
    FOREIGN KEY (carId) REFERENCES motorhomes(licensePlate),
    FOREIGN KEY (customerId) REFERENCES customers(id)
);

DROP USER IF EXISTS 'user'@'localhost';
CREATE USER 'user'@'localhost' IDENTIFIED BY '1234567890';
GRANT ALL PRIVILEGES ON nordicMotorhome.* TO 'user'@'localhost';