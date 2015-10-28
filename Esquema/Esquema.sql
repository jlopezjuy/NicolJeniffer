-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema clothes
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `clothes` ;

-- -----------------------------------------------------
-- Schema clothes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clothes` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `clothes` ;

-- -----------------------------------------------------
-- Table `clothes`.`Clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clothes`.`Clientes` ;

CREATE TABLE IF NOT EXISTS `clothes`.`Clientes` (
  `idClientes` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `Nombre` VARCHAR(45) NULL COMMENT '',
  `Apellido` VARCHAR(45) NULL COMMENT '',
  `Celular` VARCHAR(45) NULL COMMENT '',
  `Telefono` VARCHAR(45) NULL COMMENT '',
  `Email` VARCHAR(45) NULL COMMENT '',
  `Domicilio` VARCHAR(45) NULL COMMENT '',
  `Colegio` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`idClientes`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clothes`.`Medidas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clothes`.`Medidas` ;

CREATE TABLE IF NOT EXISTS `clothes`.`Medidas` (
  `idMedidas` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `LargoPolera` DECIMAL(10,4) NULL COMMENT '',
  `LargoCorset` DECIMAL(10,4) NULL COMMENT '',
  `Espalda` DECIMAL(10,4) NULL COMMENT '',
  `ContornoBusto` DECIMAL(10,4) NULL COMMENT '',
  `ContornoCadera` DECIMAL(10,4) NULL COMMENT '',
  `Costado` DECIMAL(10,4) NULL COMMENT '',
  `Cintura` DECIMAL(10,4) NULL COMMENT '',
  `Cadera` DECIMAL(10,4) NULL COMMENT '',
  `TalleEspalda` DECIMAL(10,4) NULL COMMENT '',
  `TalleDelantero` DECIMAL(10,4) NULL COMMENT '',
  `Sisa` DECIMAL(10,4) NULL COMMENT '',
  `LargoManga` DECIMAL(10,4) NULL COMMENT '',
  `LargoPollera` DECIMAL(10,4) NULL COMMENT '',
  `Observaciones` LONGTEXT NULL COMMENT '',
  `Clientes_idClientes` INT NULL COMMENT '',
  `Busto` DECIMAL(10,4) NULL COMMENT '',
  `BajoBusto` DECIMAL(10,4) NULL COMMENT '',
  `AnteCadera` DECIMAL(10,4) NULL COMMENT '',
  `PicoBusto1` DECIMAL(10,4) NULL COMMENT '',
  `PicoBusto2` DECIMAL(10,4) NULL COMMENT '',
  PRIMARY KEY (`idMedidas`)  COMMENT '',
  INDEX `fk_Medidas_Clientes_idx` (`Clientes_idClientes` ASC)  COMMENT '',
  CONSTRAINT `fk_Medidas_Clientes`
    FOREIGN KEY (`Clientes_idClientes`)
    REFERENCES `clothes`.`Clientes` (`idClientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clothes`.`Modelos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clothes`.`Modelos` ;

CREATE TABLE IF NOT EXISTS `clothes`.`Modelos` (
  `idModelos` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `Imagen` BLOB NULL COMMENT '',
  `NombreModelo` VARCHAR(255) NULL COMMENT '',
  `Observacion` VARCHAR(255) NULL COMMENT '',
  `ColorVestido` VARCHAR(255) NULL COMMENT '',
  `Clientes_idClientes` INT NULL COMMENT '',
  PRIMARY KEY (`idModelos`)  COMMENT '',
  INDEX `fk_Modelos_Clientes1_idx` (`Clientes_idClientes` ASC)  COMMENT '',
  CONSTRAINT `fk_Modelos_Clientes1`
    FOREIGN KEY (`Clientes_idClientes`)
    REFERENCES `clothes`.`Clientes` (`idClientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clothes`.`Pagos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clothes`.`Pagos` ;

CREATE TABLE IF NOT EXISTS `clothes`.`Pagos` (
  `idPagos` INT NOT NULL COMMENT '',
  `FechaPago` DATE NULL COMMENT '',
  `Importe` DECIMAL(10,4) NULL COMMENT '',
  `Cantidad` INT NULL COMMENT '',
  `Detalle` VARCHAR(45) NULL COMMENT '',
  `PrecioUnitario` DECIMAL(10,4) NULL COMMENT '',
  `PrecioTotal` DECIMAL(10,4) NULL COMMENT '',
  PRIMARY KEY (`idPagos`)  COMMENT '')
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
