-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema amusements_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema amusements_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `amusements_db` DEFAULT CHARACTER SET utf8 ;
USE `amusements_db` ;

-- -----------------------------------------------------
-- Table `amusements_db`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`region` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amusements_db`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`city` (
  `name` VARCHAR(45) NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  `region_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_city_region1_idx` (`region_id` ASC) VISIBLE,
  CONSTRAINT `fk_city_region1`
    FOREIGN KEY (`region_id`)
    REFERENCES `amusements_db`.`region` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amusements_db`.`amusement_park`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`amusement_park` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `capacity` INT NULL,
  `adress` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_amusement_park_city1_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_amusement_park_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `amusements_db`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amusements_db`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `birthday` VARCHAR(45) NULL,
  `gender` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_client_city1_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_client_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `amusements_db`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amusements_db`.`position`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`position` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amusements_db`.`worker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `phone_number` VARCHAR(10) NOT NULL,
  `email` VARCHAR(45) NULL,
  `birthday` VARCHAR(45) NULL,
  `gender` VARCHAR(50) NULL,
  `position_id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `city_id` INT NOT NULL,
  `amusement_park_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_emloyee_position1_idx` (`position_id` ASC) VISIBLE,
  INDEX `fk_emloyee_city1_idx` (`city_id` ASC) VISIBLE,
  INDEX `fk_worker_amusement_park1_idx` (`amusement_park_id` ASC) VISIBLE,
  CONSTRAINT `fk_emloyee_position1`
    FOREIGN KEY (`position_id`)
    REFERENCES `amusements_db`.`position` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emloyee_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `amusements_db`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_worker_amusement_park1`
    FOREIGN KEY (`amusement_park_id`)
    REFERENCES `amusements_db`.`amusement_park` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amusements_db`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`category` (
  `category_id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`category_id`));


-- -----------------------------------------------------
-- Table `amusements_db`.`attraction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`attraction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NULL,
  `capacity` INT NULL,
  `amusement_park_id` INT NOT NULL,
  `minimum_age` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_attraction_amusememnt_park1_idx` (`amusement_park_id` ASC) VISIBLE,
  CONSTRAINT `fk_attraction_amusememnt_park1`
    FOREIGN KEY (`amusement_park_id`)
    REFERENCES `amusements_db`.`amusement_park` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amusements_db`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `arrival_time` VARCHAR(50) NOT NULL,
  `departure_time` VARCHAR(50) NOT NULL,
  `people_number` INT NOT NULL,
  `kids_number` INT NULL,
  `price_in_USD` INT NOT NULL,
  `client_id` INT NOT NULL,
  `amusement_park_id` INT NOT NULL,
  `payment_time` VARCHAR(50) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ticket_client1_idx` (`client_id` ASC) VISIBLE,
  INDEX `fk_ticket_amusement_park1_idx` (`amusement_park_id` ASC) VISIBLE,
  CONSTRAINT `fk_ticket_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `amusements_db`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_amusement_park1`
    FOREIGN KEY (`amusement_park_id`)
    REFERENCES `amusements_db`.`amusement_park` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amusements_db`.`show`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`show` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `is_free_to_visit` TINYINT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amusements_db`.`show_ticket_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`show_ticket_type` (
  `show_id` INT NOT NULL,
  `ticket_type_id` INT NOT NULL,
  PRIMARY KEY (`show_id`, `ticket_type_id`),
  INDEX `fk_show_has_ticket_type_show1_idx` (`show_id` ASC) VISIBLE,
  CONSTRAINT `fk_show_has_ticket_type_show1`
    FOREIGN KEY (`show_id`)
    REFERENCES `amusements_db`.`show` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amusements_db`.`actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`actor` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `years_of_experience` INT NULL,
  `gender` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amusements_db`.`actor_show`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`actor_show` (
  `actor_id` INT NOT NULL,
  `show_id` INT NOT NULL,
  PRIMARY KEY (`actor_id`, `show_id`),
  INDEX `fk_actor_has_show_show1_idx` (`show_id` ASC) VISIBLE,
  INDEX `fk_actor_has_show_actor1_idx` (`actor_id` ASC) VISIBLE,
  CONSTRAINT `fk_actor_has_show_actor1`
    FOREIGN KEY (`actor_id`)
    REFERENCES `amusements_db`.`actor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actor_has_show_show1`
    FOREIGN KEY (`show_id`)
    REFERENCES `amusements_db`.`show` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
