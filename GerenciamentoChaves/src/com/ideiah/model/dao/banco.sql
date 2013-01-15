SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `gerenciamento_biblioteca` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `gerenciamento_biblioteca` ;

-- -----------------------------------------------------
-- Table `gerenciamento_biblioteca`.`aluno`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gerenciamento_biblioteca`.`aluno` (
  `id_aluno` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(255) NOT NULL ,
  `matricula` VARCHAR(255) NOT NULL ,
  `senha` VARCHAR(255) NOT NULL ,
  `curso` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_aluno`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gerenciamento_biblioteca`.`chave`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gerenciamento_biblioteca`.`chave` (
  `id_chave` INT NOT NULL AUTO_INCREMENT ,
  `numero` INT NULL ,
  PRIMARY KEY (`id_chave`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gerenciamento_biblioteca`.`emprestimo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gerenciamento_biblioteca`.`emprestimo` (
  `id_emprestimo` INT NOT NULL AUTO_INCREMENT ,
  `id_alun0` INT NOT NULL ,
  `id_chave` INT NOT NULL ,
  `retirada` DATETIME NULL ,
  `devolucao` DATETIME NULL ,
  PRIMARY KEY (`id_emprestimo`) ,
  INDEX `fk_usuario_has_chave_chave1_idx` (`id_chave` ASC) ,
  INDEX `fk_usuario_has_chave_usuario_idx` (`id_alun0` ASC) ,
  CONSTRAINT `fk_usuario_has_chave_usuario`
    FOREIGN KEY (`id_alun0` )
    REFERENCES `gerenciamento_biblioteca`.`aluno` (`id_aluno` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_chave_chave1`
    FOREIGN KEY (`id_chave` )
    REFERENCES `gerenciamento_biblioteca`.`chave` (`id_chave` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `gerenciamento_biblioteca` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
