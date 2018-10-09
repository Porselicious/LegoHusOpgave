-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Legohus
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Legohus
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Legohus` DEFAULT CHARACTER SET latin1 ;
-- -----------------------------------------------------
-- Schema Legohus
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Legohus
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Legohus` DEFAULT CHARACTER SET latin1 ;
USE `Legohus` ;

-- -----------------------------------------------------
-- Table `Legohus`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Legohus`.`user` (
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`email`));


-- -----------------------------------------------------
-- Table `Legohus`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Legohus`.`order` (
  `orderID` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `status` ENUM('sendt', 'afventer') NOT NULL,
  `orderdate` DATETIME NULL,
  `user_email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`orderID`, `user_email`),
  INDEX `fk_order_user_idx` (`user_email` ASC),
  CONSTRAINT `fk_order_user`
    FOREIGN KEY (`user_email`)
    REFERENCES `Legohus`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `Legohus`.`bricks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Legohus`.`bricks` (
  `brickname` VARCHAR(45) NOT NULL,
  `width` INT NOT NULL,
  `length` INT NOT NULL,
  PRIMARY KEY (`brickname`));


-- -----------------------------------------------------
-- Table `Legohus`.`orderDetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Legohus`.`orderDetails` (
  `orderID` INT NOT NULL,
  `qty` INT NOT NULL,
  `brickname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`orderID`, `brickname`),
  INDEX `fk_orderDetails_order1_idx` (`orderID` ASC),
  INDEX `fk_orderDetails_Bricks1_idx` (`brickname` ASC),
  CONSTRAINT `fk_orderDetails_order1`
    FOREIGN KEY (`orderID`)
    REFERENCES `Legohus`.`order` (`orderID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orderDetails_Bricks1`
    FOREIGN KEY (`brickname`)
    REFERENCES `Legohus`.`bricks` (`brickname`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

USE `Legohus` ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
