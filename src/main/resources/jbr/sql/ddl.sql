
DROP TABLE IF EXISTS `bankapp_db`.`users`;

CREATE TABLE `bankapp_db`.`users` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `phone` INT NULL,
  `role` INT DEFAULT 1,
  PRIMARY KEY (`username`));