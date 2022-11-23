CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `phonenumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `mydb`.`employee` (`id`, `name`, `phonenumber`) VALUES ('1', 'mohamed', '201');
INSERT INTO `mydb`.`employee` (`id`, `name`, `phonenumber`) VALUES ('2', 'tarek', '903');
INSERT INTO `mydb`.`employee` (`id`, `name`, `phonenumber`) VALUES ('3', 'sawy', '111');


