-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema zapateriapg
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema zapateriapg
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `zapateriapg` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `zapateriapg` ;

-- -----------------------------------------------------
-- Table `zapateriapg`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateriapg`.`productos` (
  `idProducto` BIGINT NOT NULL AUTO_INCREMENT,
  `nombreZapato` VARCHAR(100) NOT NULL,
  `colorZapato` VARCHAR(60) NOT NULL,
  `precioZapato` DECIMAL(9,2) NOT NULL,
  `marcaZapato` VARCHAR(50) NOT NULL,
  `generoZapato` VARCHAR(45) NOT NULL,
  `stock` INT NOT NULL,
  `imagenPrincipal` TEXT NOT NULL,
  `imagenFrontal` TEXT NOT NULL,
  `imagenLateral` TEXT NOT NULL,
  `imagenSuperior` TEXT NOT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `zapateriapg`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateriapg`.`roles` (
  `idRol` INT NOT NULL AUTO_INCREMENT,
  `nombreRol` VARCHAR(50) NOT NULL,
  `descripcionRol` TEXT NOT NULL,
  PRIMARY KEY (`idRol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zapateriapg`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateriapg`.`usuarios` (
  `idUsuario` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(120) NOT NULL,
  `email` VARCHAR(120) NOT NULL,
  `telefono` VARCHAR(30) NOT NULL,
  `contraseña` VARCHAR(30) NOT NULL,
  `roles_idRol` INT NOT NULL,
  PRIMARY KEY (`idUsuario`, `roles_idRol`),
  INDEX `fk_usuarios_roles1_idx` (`roles_idRol` ASC) VISIBLE,
  CONSTRAINT `fk_usuarios_roles1`
    FOREIGN KEY (`roles_idRol`)
    REFERENCES `zapateriapg`.`roles` (`idRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `zapateriapg`.`direcciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateriapg`.`direcciones` (
  `idDireccion` BIGINT NOT NULL AUTO_INCREMENT,
  `calle` VARCHAR(100) NOT NULL,
  `colonia` VARCHAR(100) NOT NULL,
  `email` VARCHAR(120) NOT NULL,
  `cp` BIGINT NOT NULL,
  `delegacionMunicipio` VARCHAR(100) NOT NULL,
  `estado` VARCHAR(100) NOT NULL,
  `indicacionesEspeciales` TEXT NULL,
  `noExterior` BIGINT NOT NULL,
  `noInterior` BIGINT NULL,
  `nombreDomicilio` VARCHAR(100) NOT NULL,
  `nombreUsuario` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(30) NOT NULL,
  `usuarios_idUsuario` BIGINT NOT NULL,
  PRIMARY KEY (`idDireccion`, `usuarios_idUsuario`),
  INDEX `fk_direcciones_usuarios1_idx` (`usuarios_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_direcciones_usuarios1`
    FOREIGN KEY (`usuarios_idUsuario`)
    REFERENCES `zapateriapg`.`usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zapateriapg`.`pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateriapg`.`pedidos` (
  `idPedido` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(120) NOT NULL,
  `fechaPedido` DATETIME NOT NULL,
  `monto` DECIMAL(9,2) NOT NULL,
  `usuarios_idUsuario` BIGINT NOT NULL,
  `direcciones_idDirecciones` BIGINT NOT NULL,
  PRIMARY KEY (`idPedido`, `usuarios_idUsuario`, `direcciones_idDirecciones`),
  INDEX `fk_pedidos_usuarios1_idx` (`usuarios_idUsuario` ASC) VISIBLE,
  INDEX `fk_pedidos_direcciones1_idx` (`direcciones_idDirecciones` ASC) VISIBLE,
  CONSTRAINT `fk_pedidos_usuarios1`
    FOREIGN KEY (`usuarios_idUsuario`)
    REFERENCES `zapateriapg`.`usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedidos_direcciones1`
    FOREIGN KEY (`direcciones_idDirecciones`)
    REFERENCES `zapateriapg`.`direcciones` (`idDireccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zapateriapg`.`pedidos_has_productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateriapg`.`pedidos_has_productos` (
  `pedidos_idPedido` BIGINT NOT NULL,
  `productos_idProducto` BIGINT NOT NULL,
  PRIMARY KEY (`pedidos_idPedido`, `productos_idProducto`),
  INDEX `fk_pedidos_has_productos_productos1_idx` (`productos_idProducto` ASC) VISIBLE,
  INDEX `fk_pedidos_has_productos_pedidos1_idx` (`pedidos_idPedido` ASC) VISIBLE,
  CONSTRAINT `fk_pedidos_has_productos_pedidos1`
    FOREIGN KEY (`pedidos_idPedido`)
    REFERENCES `zapateriapg`.`pedidos` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedidos_has_productos_productos1`
    FOREIGN KEY (`productos_idProducto`)
    REFERENCES `zapateriapg`.`productos` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
