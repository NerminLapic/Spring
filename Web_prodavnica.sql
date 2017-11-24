-- MySQL Script generated by MySQL Workbench
-- 07/13/17 21:43:06
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema web_prodavnica
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema web_prodavnica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `web_prodavnica` DEFAULT CHARACTER SET utf8 ;
USE `web_prodavnica` ;

-- -----------------------------------------------------
-- Table `web_prodavnica`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_prodavnica`.`customers` (
  `customerId` INT(11) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`customerId`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `web_prodavnica`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_prodavnica`.`products` (
  `productId` INT(11) NOT NULL AUTO_INCREMENT,
  `productName` VARCHAR(45) NOT NULL,
  `productPrice` FLOAT NOT NULL,
  `productDescription` VARCHAR(256) NOT NULL,
  `productQty` INT(11) NOT NULL,
  PRIMARY KEY (`productId`))
ENGINE = InnoDB
AUTO_INCREMENT = 45
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `web_prodavnica`.`buy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_prodavnica`.`buy` (
  `buyId` INT(11) NOT NULL AUTO_INCREMENT,
  `productId` INT(11) NOT NULL,
  `customerId` INT(11) NOT NULL,
  `buyNumber` VARCHAR(20) NULL DEFAULT NULL,
  `buyQty` INT(11) NOT NULL,
  PRIMARY KEY (`buyId`),
  INDEX `productId_idx` (`productId` ASC),
  INDEX `customerId_idx` (`customerId` ASC),
  CONSTRAINT `fk_customer_id`
    FOREIGN KEY (`customerId`)
    REFERENCES `web_prodavnica`.`customers` (`customerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_id`
    FOREIGN KEY (`productId`)
    REFERENCES `web_prodavnica`.`products` (`productId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
