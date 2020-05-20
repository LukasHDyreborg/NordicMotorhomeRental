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
    driver_license_number VARCHAR(45) NOT NULL,
    driver_license_date DATE NOT NULL/*,
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
    registrationDate VARCHAR(45) NOT NULL,
    lengthAndHeight VARCHAR(45) NOT NULL,
    type DATE NOT NULL
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

DROP USER IF EXISTS 'user'@'localhost';
CREATE USER 'user'@'localhost' IDENTIFIED BY '1234567890';
GRANT ALL PRIVILEGES ON nordicMotorhome.* TO 'user'@'localhost';