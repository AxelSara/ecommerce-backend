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
-- Table `zapateriapg`.`carritos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateriapg`.`carritos` (
  `id_carrito` BIGINT NOT NULL AUTO_INCREMENT,
  `monto` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`id_carrito`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `zapateriapg`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateriapg`.`productos` (
  `id_producto` BIGINT NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY (`id_producto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `zapateriapg`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateriapg`.`usuarios` (
  `id_usuario` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(120) NOT NULL,
  `email` VARCHAR(120) NOT NULL,
  `telefono` VARCHAR(30) NOT NULL,
  `contraseña` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `zapateriapg`.`direcciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateriapg`.`direcciones` (
  `id_direcciones` BIGINT NOT NULL AUTO_INCREMENT,
  `calle` VARCHAR(100) NOT NULL,
  `colonia` VARCHAR(100) NOT NULL,
  `email` VARCHAR(120) NOT NULL,
  `cp` BIGINT NOT NULL,
  `delegacion_municipio` VARCHAR(100) NOT NULL,
  `estado` VARCHAR(100) NOT NULL,
  `indicaciones_especiales` TEXT NULL,
  `noExterior` BIGINT NOT NULL,
  `noInterior` BIGINT NULL,
  `nombre_domicilio` VARCHAR(100) NOT NULL,
  `nombre_usuario` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(30) NOT NULL,
  `usuarios_id_usuario` BIGINT NOT NULL,
  PRIMARY KEY (`id_direcciones`, `usuarios_id_usuario`),
  INDEX `fk_direcciones_usuarios1_idx` (`usuarios_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_direcciones_usuarios1`
    FOREIGN KEY (`usuarios_id_usuario`)
    REFERENCES `zapateriapg`.`usuarios` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zapateriapg`.`pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateriapg`.`pedidos` (
  `id_pedido` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(120) NOT NULL,
  `fechaPedido` DATETIME NOT NULL,
  `usuarios_id_usuario` BIGINT NOT NULL,
  `carritos_id_carrito` BIGINT NOT NULL,
  `direcciones_id_direcciones` BIGINT NOT NULL,
  PRIMARY KEY (`id_pedido`, `usuarios_id_usuario`, `carritos_id_carrito`, `direcciones_id_direcciones`),
  INDEX `fk_pedidos_usuarios1_idx` (`usuarios_id_usuario` ASC) VISIBLE,
  INDEX `fk_pedidos_carritos1_idx` (`carritos_id_carrito` ASC) VISIBLE,
  INDEX `fk_pedidos_direcciones1_idx` (`direcciones_id_direcciones` ASC) VISIBLE,
  CONSTRAINT `fk_pedidos_usuarios1`
    FOREIGN KEY (`usuarios_id_usuario`)
    REFERENCES `zapateriapg`.`usuarios` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedidos_carritos1`
    FOREIGN KEY (`carritos_id_carrito`)
    REFERENCES `zapateriapg`.`carritos` (`id_carrito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedidos_direcciones1`
    FOREIGN KEY (`direcciones_id_direcciones`)
    REFERENCES `zapateriapg`.`direcciones` (`id_direcciones`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zapateriapg`.`favoritos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateriapg`.`favoritos` (
  `id_favorito` BIGINT NOT NULL AUTO_INCREMENT,
  `productos_id_producto` BIGINT NOT NULL,
  PRIMARY KEY (`id_favorito`, `productos_id_producto`),
  INDEX `fk_favoritos_productos1_idx` (`productos_id_producto` ASC) VISIBLE,
  CONSTRAINT `fk_favoritos_productos1`
    FOREIGN KEY (`productos_id_producto`)
    REFERENCES `zapateriapg`.`productos` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zapateriapg`.`productos_has_carritos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zapateriapg`.`productos_has_carritos` (
  `productos_id_producto` BIGINT NOT NULL,
  `carritos_id_carrito` BIGINT NOT NULL,
  PRIMARY KEY (`productos_id_producto`, `carritos_id_carrito`),
  INDEX `fk_productos_has_carritos_carritos1_idx` (`carritos_id_carrito` ASC) VISIBLE,
  INDEX `fk_productos_has_carritos_productos1_idx` (`productos_id_producto` ASC) VISIBLE,
  CONSTRAINT `fk_productos_has_carritos_productos1`
    FOREIGN KEY (`productos_id_producto`)
    REFERENCES `zapateriapg`.`productos` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productos_has_carritos_carritos1`
    FOREIGN KEY (`carritos_id_carrito`)
    REFERENCES `zapateriapg`.`carritos` (`id_carrito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
