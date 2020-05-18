DROP DATABASE IF EXISTS nordicMotorhome;
CREATE DATABASE nordicMotorhome;

USE nordicMotorhome;

CREATE TABLE customers
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(45) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(45) NOT NULL,
    cpr VARCHAR(20) NOT NULL UNIQUE,
    phone VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    zip_code VARCHAR(45) NOT NULL,
    driver_license_number VARCHAR(45) NOT NULL,
    driver_license_date DATE NOT NULL /*,
    FOREIGN KEY (zip_code) REFERENCES city(zip_code)*/
);

DROP USER IF EXISTS 'user'@'localhost';
CREATE USER 'user'@'localhost' IDENTIFIED BY '1234567890';
GRANT ALL PRIVILEGES ON nordicMotorhome.* TO 'user'@'localhost';