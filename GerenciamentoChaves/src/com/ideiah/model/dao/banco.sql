SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `gerenciamento_biblioteca` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

USE `gerenciamento_biblioteca`;

CREATE  TABLE IF NOT EXISTS `gerenciamento_biblioteca`.`aluno` (
  `id_aluno` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(255) NOT NULL ,
  `matricula` VARCHAR(255) NOT NULL ,
  `senha` VARCHAR(255) NOT NULL ,
  `curso` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_aluno`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `gerenciamento_biblioteca`.`chave` (
  `id_chave` INT(11) NOT NULL AUTO_INCREMENT ,
  `numero` INT(11) NULL DEFAULT NULL ,
  `tipo` VARCHAR(45) NULL DEFAULT NULL ,
  `status` TINYINT(1) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_chave`) ,
  UNIQUE INDEX `numero_UNIQUE` (`numero` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `gerenciamento_biblioteca`.`emprestimo` (
  `id_emprestimo` INT(11) NOT NULL AUTO_INCREMENT ,
  `id_aluno` INT(11) NOT NULL ,
  `id_chave` INT(11) NOT NULL ,
  `retirada` DATETIME NULL DEFAULT NULL ,
  `devolucao` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`id_emprestimo`) ,
  INDEX `fk_usuario_has_chave_chave1_idx` (`id_chave` ASC) ,
  INDEX `fk_usuario_has_chave_usuario_idx` (`id_aluno` ASC) ,
  CONSTRAINT `fk_usuario_has_chave_usuario`
    FOREIGN KEY (`id_aluno` )
    REFERENCES `gerenciamento_biblioteca`.`aluno` (`id_aluno` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_chave_chave1`
    FOREIGN KEY (`id_chave` )
    REFERENCES `gerenciamento_biblioteca`.`chave` (`id_chave` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `gerenciamento_biblioteca`.`Usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NOT NULL ,
  `senha` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_usuario`) ,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
