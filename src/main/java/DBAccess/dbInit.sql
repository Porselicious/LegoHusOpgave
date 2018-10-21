SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Legohus
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Legohus` ;

-- -----------------------------------------------------
-- Schema Legohus
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Legohus` DEFAULT CHARACTER SET latin1 ;
USE `Legohus` ;

-- -----------------------------------------------------
-- Table `Legohus`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Legohus`.`user` (
  `email` VARCHAR(225) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` ENUM('customer', 'employee') NULL DEFAULT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Legohus`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Legohus`.`order` (
  `orderID` INT(11) NOT NULL,
  `status` TINYINT NULL DEFAULT NULL,
  `heigth` INT(11) NULL DEFAULT NULL,
  `length` INT(11) NULL DEFAULT NULL,
  `width` INT(11) NULL DEFAULT NULL,
  `orderdate` DATETIME NULL DEFAULT NULL,
  `user_email` VARCHAR(225) NOT NULL,
  PRIMARY KEY (`orderID`, `user_email`),
  INDEX `fk_order_user_idx` (`user_email` ASC),
  CONSTRAINT `fk_order_user`
    FOREIGN KEY (`user_email`)
    REFERENCES `Legohus`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `user`
VALUES ('robin@somewhere.com', 'batman', 'employee'),
('rasmus@somewhere.com', 'rasmus', 'customer');