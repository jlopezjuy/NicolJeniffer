-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema NicoleJeniffer
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `NicoleJeniffer` ;

-- -----------------------------------------------------
-- Schema NicoleJeniffer
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `NicoleJeniffer` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `NicoleJeniffer` ;

-- -----------------------------------------------------
-- Table `NicoleJeniffer`.`Empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NicoleJeniffer`.`Empresa` ;

CREATE TABLE IF NOT EXISTS `NicoleJeniffer`.`Empresa` (
  `idEmpresa` INT NOT NULL AUTO_INCREMENT,
  `NombreEmpresa` VARCHAR(45) NULL,
  `Domicilio` VARCHAR(45) NULL,
  `Telefono` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  PRIMARY KEY (`idEmpresa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NicoleJeniffer`.`Clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NicoleJeniffer`.`Clientes` ;

CREATE TABLE IF NOT EXISTS `NicoleJeniffer`.`Clientes` (
  `idClientes` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Apellido` VARCHAR(45) NULL,
  `Celular` VARCHAR(45) NULL,
  `Telefono` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `Domicilio` VARCHAR(45) NULL,
  `Colegio` VARCHAR(45) NULL,
  `Empresa_idEmpresa` INT NOT NULL,
  PRIMARY KEY (`idClientes`),
  CONSTRAINT `fk_Clientes_Empresa1`
    FOREIGN KEY (`Empresa_idEmpresa`)
    REFERENCES `NicoleJeniffer`.`Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Clientes_Empresa1_idx` ON `NicoleJeniffer`.`Clientes` (`Empresa_idEmpresa` ASC);


-- -----------------------------------------------------
-- Table `NicoleJeniffer`.`Medidas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NicoleJeniffer`.`Medidas` ;

CREATE TABLE IF NOT EXISTS `NicoleJeniffer`.`Medidas` (
  `idMedidas` INT NOT NULL AUTO_INCREMENT,
  `LargoPolera` DECIMAL(10,4) NULL,
  `LargoCorset` DECIMAL(10,4) NULL,
  `Espalda` DECIMAL(10,4) NULL,
  `ContornoBusto` DECIMAL(10,4) NULL,
  `ContornoCadera` DECIMAL(10,4) NULL,
  `Costado` DECIMAL(10,4) NULL,
  `Cintura` DECIMAL(10,4) NULL,
  `Cadera` DECIMAL(10,4) NULL,
  `TalleEspalda` DECIMAL(10,4) NULL,
  `TalleDelantero` DECIMAL(10,4) NULL,
  `Sisa` DECIMAL(10,4) NULL,
  `LargoManga` DECIMAL(10,4) NULL,
  `LargoPollera` DECIMAL(10,4) NULL,
  `Observaciones` LONGTEXT NULL,
  `Clientes_idClientes` INT NULL,
  `FechaMedida` DATE NULL,
  `Busto` DECIMAL(10,4) NULL,
  `BajoBusto` DECIMAL(10,4) NULL,
  `AnteCadera` DECIMAL(10,4) NULL,
  `PicoBusto1` DECIMAL(10,4) NULL,
  `PicoBusto2` DECIMAL(10,4) NULL,
  PRIMARY KEY (`idMedidas`),
  CONSTRAINT `fk_Medidas_Clientes`
    FOREIGN KEY (`Clientes_idClientes`)
    REFERENCES `NicoleJeniffer`.`Clientes` (`idClientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Medidas_Clientes_idx` ON `NicoleJeniffer`.`Medidas` (`Clientes_idClientes` ASC);


-- -----------------------------------------------------
-- Table `NicoleJeniffer`.`Modelos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NicoleJeniffer`.`Modelos` ;

CREATE TABLE IF NOT EXISTS `NicoleJeniffer`.`Modelos` (
  `idModelos` INT NOT NULL AUTO_INCREMENT,
  `Imagen` BLOB NULL,
  `NombreModelo` VARCHAR(255) NULL,
  `Observacion` VARCHAR(255) NULL,
  `ColorVestido` VARCHAR(255) NULL,
  `Clientes_idClientes` INT NULL,
  PRIMARY KEY (`idModelos`),
  CONSTRAINT `fk_Modelos_Clientes1`
    FOREIGN KEY (`Clientes_idClientes`)
    REFERENCES `NicoleJeniffer`.`Clientes` (`idClientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Modelos_Clientes1_idx` ON `NicoleJeniffer`.`Modelos` (`Clientes_idClientes` ASC);


-- -----------------------------------------------------
-- Table `NicoleJeniffer`.`ValorDominio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NicoleJeniffer`.`ValorDominio` ;

CREATE TABLE IF NOT EXISTS `NicoleJeniffer`.`ValorDominio` (
  `idValorDominio` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`idValorDominio`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idValorDominio_UNIQUE` ON `NicoleJeniffer`.`ValorDominio` (`idValorDominio` ASC);


-- -----------------------------------------------------
-- Table `NicoleJeniffer`.`Encargos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NicoleJeniffer`.`Encargos` ;

CREATE TABLE IF NOT EXISTS `NicoleJeniffer`.`Encargos` (
  `idEncargo` INT NOT NULL AUTO_INCREMENT,
  `ImporteTotal` DECIMAL(14,3) NULL,
  `FechaEncargo` DATE NULL,
  `FechaEntrega` DATE NULL,
  `TipoEvento` VARCHAR(45) NULL,
  `DetalleVestido` VARCHAR(45) NULL,
  `ValorDominio_idValorDominio` INT NOT NULL,
  `Clientes_idClientes` INT NULL,
  `idEmpresa` INT NOT NULL,
  PRIMARY KEY (`idEncargo`),
  CONSTRAINT `fk_Encargos_ValorDominio1`
    FOREIGN KEY (`ValorDominio_idValorDominio`)
    REFERENCES `NicoleJeniffer`.`ValorDominio` (`idValorDominio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Encargos_Clientes1`
    FOREIGN KEY (`Clientes_idClientes`)
    REFERENCES `NicoleJeniffer`.`Clientes` (`idClientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Encargos_Empresa1`
    FOREIGN KEY (`idEmpresa`)
    REFERENCES `NicoleJeniffer`.`Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idEncargo_UNIQUE` ON `NicoleJeniffer`.`Encargos` (`idEncargo` ASC);

CREATE INDEX `fk_Encargos_ValorDominio1_idx` ON `NicoleJeniffer`.`Encargos` (`ValorDominio_idValorDominio` ASC);

CREATE INDEX `fk_Encargos_Clientes1_idx` ON `NicoleJeniffer`.`Encargos` (`Clientes_idClientes` ASC);

CREATE INDEX `fk_Encargos_Empresa1_idx` ON `NicoleJeniffer`.`Encargos` (`idEmpresa` ASC);


-- -----------------------------------------------------
-- Table `NicoleJeniffer`.`Pagos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NicoleJeniffer`.`Pagos` ;

CREATE TABLE IF NOT EXISTS `NicoleJeniffer`.`Pagos` (
  `idPagos` INT NOT NULL AUTO_INCREMENT,
  `FechaPago` DATE NULL,
  `Importe` DECIMAL(10,4) NULL,
  `Cantidad` INT NULL,
  `Detalle` VARCHAR(45) NULL,
  `PrecioUnitario` DECIMAL(10,4) NULL,
  `PrecioTotal` DECIMAL(10,4) NULL,
  `NumeroRecibo` VARCHAR(45) NULL,
  `Encargos_idEncargo` INT NULL,
  PRIMARY KEY (`idPagos`),
  CONSTRAINT `fk_Pagos_Encargos1`
    FOREIGN KEY (`Encargos_idEncargo`)
    REFERENCES `NicoleJeniffer`.`Encargos` (`idEncargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Pagos_Encargos1_idx` ON `NicoleJeniffer`.`Pagos` (`Encargos_idEncargo` ASC);


-- -----------------------------------------------------
-- Table `NicoleJeniffer`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NicoleJeniffer`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `NicoleJeniffer`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `NombreUsuario` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `NombreApellido` VARCHAR(45) NULL,
  `Empresa_idEmpresa` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  CONSTRAINT `fk_Usuario_Empresa1`
    FOREIGN KEY (`Empresa_idEmpresa`)
    REFERENCES `NicoleJeniffer`.`Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idUsuario_UNIQUE` ON `NicoleJeniffer`.`Usuario` (`idUsuario` ASC);

CREATE INDEX `fk_Usuario_Empresa1_idx` ON `NicoleJeniffer`.`Usuario` (`Empresa_idEmpresa` ASC);


-- -----------------------------------------------------
-- Table `NicoleJeniffer`.`Rol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NicoleJeniffer`.`Rol` ;

CREATE TABLE IF NOT EXISTS `NicoleJeniffer`.`Rol` (
  `idRol` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`idRol`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idRol_UNIQUE` ON `NicoleJeniffer`.`Rol` (`idRol` ASC);


-- -----------------------------------------------------
-- Table `NicoleJeniffer`.`UsuarioRol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NicoleJeniffer`.`UsuarioRol` ;

CREATE TABLE IF NOT EXISTS `NicoleJeniffer`.`UsuarioRol` (
  `idUsuarioRol` INT NOT NULL AUTO_INCREMENT,
  `Usuario_idUsuario` INT NOT NULL,
  `Rol_idRol` INT NOT NULL,
  PRIMARY KEY (`idUsuarioRol`),
  CONSTRAINT `fk_UsuarioRol_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `NicoleJeniffer`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UsuarioRol_Rol1`
    FOREIGN KEY (`Rol_idRol`)
    REFERENCES `NicoleJeniffer`.`Rol` (`idRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idUsuarioRol_UNIQUE` ON `NicoleJeniffer`.`UsuarioRol` (`idUsuarioRol` ASC);

CREATE INDEX `fk_UsuarioRol_Usuario1_idx` ON `NicoleJeniffer`.`UsuarioRol` (`Usuario_idUsuario` ASC);

CREATE INDEX `fk_UsuarioRol_Rol1_idx` ON `NicoleJeniffer`.`UsuarioRol` (`Rol_idRol` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `NicoleJeniffer`.`Empresa`
-- -----------------------------------------------------
START TRANSACTION;
USE `NicoleJeniffer`;
INSERT INTO `NicoleJeniffer`.`Empresa` (`idEmpresa`, `NombreEmpresa`, `Domicilio`, `Telefono`, `Email`) VALUES (1, 'Nicole Boutique', 'Necochea 465', '4226288', 'jlopezjuy@gmail.com');

COMMIT;


-- -----------------------------------------------------
-- Data for table `NicoleJeniffer`.`Clientes`
-- -----------------------------------------------------
START TRANSACTION;
USE `NicoleJeniffer`;
INSERT INTO `NicoleJeniffer`.`Clientes` (`idClientes`, `Nombre`, `Apellido`, `Celular`, `Telefono`, `Email`, `Domicilio`, `Colegio`, `Empresa_idEmpresa`) VALUES (1, 'Juan Manuel', 'Lopez', '3884105177', '3884226288', 'jlopezjuy@gmail.com', 'Esnaola 160', 'Pablo Pizzurno', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `NicoleJeniffer`.`ValorDominio`
-- -----------------------------------------------------
START TRANSACTION;
USE `NicoleJeniffer`;
INSERT INTO `NicoleJeniffer`.`ValorDominio` (`idValorDominio`, `Descripcion`) VALUES (1, 'Encargado');
INSERT INTO `NicoleJeniffer`.`ValorDominio` (`idValorDominio`, `Descripcion`) VALUES (2, 'Cortado');
INSERT INTO `NicoleJeniffer`.`ValorDominio` (`idValorDominio`, `Descripcion`) VALUES (3, 'Armado/Primera Prueba');
INSERT INTO `NicoleJeniffer`.`ValorDominio` (`idValorDominio`, `Descripcion`) VALUES (4, 'Finalizar Armado');
INSERT INTO `NicoleJeniffer`.`ValorDominio` (`idValorDominio`, `Descripcion`) VALUES (5, 'Detalles Prebios a Finalizar');
INSERT INTO `NicoleJeniffer`.`ValorDominio` (`idValorDominio`, `Descripcion`) VALUES (6, 'Entregado');

COMMIT;


-- -----------------------------------------------------
-- Data for table `NicoleJeniffer`.`Usuario`
-- -----------------------------------------------------
START TRANSACTION;
USE `NicoleJeniffer`;
INSERT INTO `NicoleJeniffer`.`Usuario` (`idUsuario`, `NombreUsuario`, `Password`, `NombreApellido`, `Empresa_idEmpresa`) VALUES (1, 'jlopez', 'e10adc3949ba59abbe56e057f20f883e', 'Juan Manuel Lopez', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `NicoleJeniffer`.`Rol`
-- -----------------------------------------------------
START TRANSACTION;
USE `NicoleJeniffer`;
INSERT INTO `NicoleJeniffer`.`Rol` (`idRol`, `Descripcion`) VALUES (1, 'Administrador');
INSERT INTO `NicoleJeniffer`.`Rol` (`idRol`, `Descripcion`) VALUES (2, 'Vendedor');
INSERT INTO `NicoleJeniffer`.`Rol` (`idRol`, `Descripcion`) VALUES (3, 'Encargado');

COMMIT;


-- -----------------------------------------------------
-- Data for table `NicoleJeniffer`.`UsuarioRol`
-- -----------------------------------------------------
START TRANSACTION;
USE `NicoleJeniffer`;
INSERT INTO `NicoleJeniffer`.`UsuarioRol` (`idUsuarioRol`, `Usuario_idUsuario`, `Rol_idRol`) VALUES (1, 1, 1);

COMMIT;

