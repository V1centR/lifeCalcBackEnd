-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema lifeCalcDatabase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lifeCalcDatabase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lifeCalcDatabase` DEFAULT CHARACTER SET utf8 ;
USE `lifeCalcDatabase` ;

-- -----------------------------------------------------
-- Table `lifeCalcDatabase`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifeCalcDatabase`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `counter` VARCHAR(45) NULL,
  `description` VARCHAR(120) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifeCalcDatabase`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifeCalcDatabase`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(49) NOT NULL,
  `cat` INT(2) NOT NULL,
  `preco` DOUBLE(10,2) NOT NULL,
  `counter` INT(3) NOT NULL,
  `description` VARCHAR(120) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produto_1_idx` (`cat` ASC),
  CONSTRAINT `fk_produto_1`
    FOREIGN KEY (`cat`)
    REFERENCES `lifeCalcDatabase`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifeCalcDatabase`.`centro_custo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifeCalcDatabase`.`centro_custo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `base` DOUBLE(10,2) NOT NULL,
  `base_date` INT(14) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifeCalcDatabase`.`operation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifeCalcDatabase`.`operation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` INT NOT NULL,
  `location` VARCHAR(45) NULL,
  `produto` INT(4) NOT NULL,
  `value` DOUBLE(10,2) NOT NULL,
  `centro_custo` INT(3) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_operation_1_idx` (`produto` ASC),
  INDEX `fk_operation_2_idx` (`centro_custo` ASC),
  CONSTRAINT `fk_operation_1`
    FOREIGN KEY (`produto`)
    REFERENCES `lifeCalcDatabase`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_operation_2`
    FOREIGN KEY (`centro_custo`)
    REFERENCES `lifeCalcDatabase`.`centro_custo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
