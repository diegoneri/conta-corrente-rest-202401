-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema financas_fatec
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `financas_fatec` ;

-- -----------------------------------------------------
-- Schema financas_fatec
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `financas_fatec` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `financas_fatec` ;

-- -----------------------------------------------------
-- Table `financas_fatec`.`tb_conta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `financas_fatec`.`tb_conta` ;

CREATE TABLE IF NOT EXISTS `financas_fatec`.`tb_conta` (
  `nr_agencia` INT NOT NULL,
  `vl_saldo` DOUBLE NOT NULL,
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nm_numero` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `financas_fatec`.`tb_cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `financas_fatec`.`tb_cliente` ;

CREATE TABLE IF NOT EXISTS `financas_fatec`.`tb_cliente` (
  `fk_conta_id` BIGINT NULL DEFAULT NULL,
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nm_nome` VARCHAR(60) NULL DEFAULT NULL,
  `ds_endereco` VARCHAR(120) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_mm3h5ajdx3v4hr2voj5fqyr22` (`fk_conta_id` ASC) VISIBLE,
  CONSTRAINT `FKiim12wo5q0v3wx4593tts0qhh`
    FOREIGN KEY (`fk_conta_id`)
    REFERENCES `financas_fatec`.`tb_conta` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `financas_fatec`.`tb_movimentacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `financas_fatec`.`tb_movimentacao` ;

CREATE TABLE IF NOT EXISTS `financas_fatec`.`tb_movimentacao` (
  `vl_valor` FLOAT NULL DEFAULT NULL,
  `conta_id` BIGINT NULL DEFAULT NULL,
  `dt_data` DATETIME(6) NULL DEFAULT NULL,
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `ds_descricao` VARCHAR(100) NULL DEFAULT NULL,
  `nm_tipo_movimentacao` ENUM('ENTRADA', 'SAIDA') NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKa8bf6ns85n1pl6neassf6m6nq` (`conta_id` ASC) VISIBLE,
  CONSTRAINT `FKa8bf6ns85n1pl6neassf6m6nq`
    FOREIGN KEY (`conta_id`)
    REFERENCES `financas_fatec`.`tb_conta` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `financas_fatec`.`tb_pessoa_fisica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `financas_fatec`.`tb_pessoa_fisica` ;

CREATE TABLE IF NOT EXISTS `financas_fatec`.`tb_pessoa_fisica` (
  `id` BIGINT NOT NULL,
  `cd_cpf` VARCHAR(11) NULL DEFAULT NULL,
  `nm_profissao` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKth1jtw0l894v2x08rg6ookphu`
    FOREIGN KEY (`id`)
    REFERENCES `financas_fatec`.`tb_cliente` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `financas_fatec`.`tb_pessoa_juridica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `financas_fatec`.`tb_pessoa_juridica` ;

CREATE TABLE IF NOT EXISTS `financas_fatec`.`tb_pessoa_juridica` (
  `id` BIGINT NOT NULL,
  `cd_cnpj` VARCHAR(14) NULL DEFAULT NULL,
  `nm_ramo_atividade` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK3a6nhfk2tb8vl83ula84inx5p`
    FOREIGN KEY (`id`)
    REFERENCES `financas_fatec`.`tb_cliente` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
