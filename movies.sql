/*
Navicat MySQL Data Transfer

Source Server         : mysql_connect
Source Server Version : 50605
Source Host           : localhost:3306
Source Database       : movies
Target Server Type    : MYSQL
Target Server Version : 50605
File Encoding         : 65001

Date: 2022-04-16 17:19:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `movies`
-- ----------------------------
DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies` (
  `Movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) DEFAULT NULL,
  `Director` varchar(50) DEFAULT NULL,
  `Rating` int(11) DEFAULT NULL,
  `Genre_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Movie_id`),
  KEY `fk_Genre_id` (`Genre_id`),
  CONSTRAINT `fk_Genre_id` FOREIGN KEY (`Genre_id`) REFERENCES `genres` (`Genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movies
-- ----------------------------
INSERT INTO `movies` VALUES ('1', 'Leprechaun', 'Trimark Pictures', '3', '1');
INSERT INTO `movies` VALUES ('2', 'Avengers: Endgame', 'Marvel Studios', '11', '3');
INSERT INTO `movies` VALUES ('3', 'The Tomorrow War', 'Chris McKay', '4', '2');
INSERT INTO `movies` VALUES ('4', 'Accident Man', 'Craig Bau', '11', '4');
INSERT INTO `movies` VALUES ('5', 'Boyka: Undisputed', 'Todor C hapkanov', '6', '8');
INSERT INTO `movies` VALUES ('6', 'Loki', 'Michael Waldron', '5', '9');
INSERT INTO `movies` VALUES ('7', 'Jumanji', 'Chris McKenna', '5', '1');
INSERT INTO `movies` VALUES ('8', 'Mahkum', 'Ugras Gunes', '2', '2');
INSERT INTO `movies` VALUES ('9', 'Spider-Man', 'Stan Lee', '4', '5');
INSERT INTO `movies` VALUES ('10', 'I Am Legend', 'Akiva Goldsman', '3', '2');
-- ----------------------------
-- Table structure for `borrows`
-- ----------------------------
DROP TABLE IF EXISTS `borrows`;
CREATE TABLE `borrows` (
  `Borrow_id` int(11) NOT NULL AUTO_INCREMENT,
  `Actor_id` int(11) DEFAULT NULL,
  `Movie_id` int(11) DEFAULT NULL,
  `Start_Date` datetime DEFAULT NULL,
  `End_Date` datetime DEFAULT NULL,
  PRIMARY KEY (`Borrow_id`),
  KEY `fk_movie_id` (`Movie_id`),
  KEY `fk_actor_id` (`Actor_id`),
  CONSTRAINT `fk_movie_id` FOREIGN KEY (`Movie_id`) REFERENCES `movies` (`Movie_id`),
  CONSTRAINT `fk_actor_id` FOREIGN KEY (`Actor_id`) REFERENCES `actors` (`Actor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrows
-- ----------------------------
INSERT INTO `borrows` VALUES ('1', '1', '2', '2019-08-13 19:28:29', '2019-10-03 00:00:00');
INSERT INTO `borrows` VALUES ('2', '1', '1', '2019-10-02 23:15:47', '2019-10-03 09:21:00');
INSERT INTO `borrows` VALUES ('3', '1', '2', '2019-10-02 23:16:06', '2019-10-03 10:20:58');
INSERT INTO `borrows` VALUES ('4', '1', '2', '2019-10-04 21:08:30', '2019-10-04 21:08:56');
INSERT INTO `borrows` VALUES ('5', '1', '1', '2019-10-26 21:54:08', '2019-10-26 21:54:56');

-- ----------------------------
-- Table structure for `genres`
-- ----------------------------
DROP TABLE IF EXISTS `genres`;
CREATE TABLE `genres` (
  `Genre_id` int(11) NOT NULL AUTO_INCREMENT,
  `Genre_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of genres
-- ----------------------------
INSERT INTO `genres` VALUES ('1', 'Анимация');
INSERT INTO `genres` VALUES ('2', 'Екшън');
INSERT INTO `genres` VALUES ('3', 'Драма');
INSERT INTO `genres` VALUES ('4', 'Приключенски');
INSERT INTO `genres` VALUES ('5', 'Комедия');
INSERT INTO `genres` VALUES ('6', 'Крими');
INSERT INTO `genres` VALUES ('7', 'Ужаси');
INSERT INTO `genres` VALUES ('8', 'Романтичен');
INSERT INTO `genres` VALUES ('9', 'Фентъзи');

-- ----------------------------
-- Table structure for `login`
-- ----------------------------

-- ----------------------------
-- Records of login
-- ----------------------------

-- ----------------------------
-- Table structure for `actors`
-- ----------------------------
DROP TABLE IF EXISTS `actors`;
CREATE TABLE `actors` (
  `Actor_id` int(11) NOT NULL AUTO_INCREMENT,
  `First_name` varchar(50) DEFAULT NULL,
  `Last_name` varchar(50) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Dob` date DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Phone_number` varchar(12) DEFAULT NULL,
  `Country` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Actor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of actors
-- ----------------------------
INSERT INTO `` (`Actor_id`,`First_name`,`Last_name`,`Gender`,`Dob`,`Address`,`Phone_number`,`Country`) VALUES (1,'Will','Smith','Male','1968-09-25','West Philadelphia, Pennsylvania','12345678','USA');
INSERT INTO `` (`Actor_id`,`First_name`,`Last_name`,`Gender`,`Dob`,`Address`,`Phone_number`,`Country`) VALUES (2,'Chris','Pratt','Male','1979-06-21','Virginia, Minnesota','23453213','USA');
INSERT INTO `` (`Actor_id`,`First_name`,`Last_name`,`Gender`,`Dob`,`Address`,`Phone_number`,`Country`) VALUES (3,'Chris','Evans','Male','1981-06-13','Boston, Massachusetts','53312121','USA');
INSERT INTO `` (`Actor_id`,`First_name`,`Last_name`,`Gender`,`Dob`,`Address`,`Phone_number`,`Country`) VALUES (4,'Tom','Holland','Male','1996-06-01','London','9854736521','England');
INSERT INTO `` (`Actor_id`,`First_name`,`Last_name`,`Gender`,`Dob`,`Address`,`Phone_number`,`Country`) VALUES (5,'Tom','Hiddleston','Male','1986-02-09','Westminster, London','346847654734','England, UK');
INSERT INTO `` (`Actor_id`,`First_name`,`Last_name`,`Gender`,`Dob`,`Address`,`Phone_number`,`Country`) VALUES (6,'Dwayne','Johnson','Male','1972-05-02','Hayward, California, U.S.','985432156722','USA');
INSERT INTO `` (`Actor_id`,`First_name`,`Last_name`,`Gender`,`Dob`,`Address`,`Phone_number`,`Country`) VALUES (7,'Teodora','Duhovnikova','Female','1977-07-12','Sofia, Bulgaria','359875674523','Bulgaria');
INSERT INTO `` (`Actor_id`,`First_name`,`Last_name`,`Gender`,`Dob`,`Address`,`Phone_number`,`Country`) VALUES (8,'Scott','Adkins','Male','1976-06-17','Sutton Coldfield, West Midlands, England','987456354243','England');
INSERT INTO `` (`Actor_id`,`First_name`,`Last_name`,`Gender`,`Dob`,`Address`,`Phone_number`,`Country`) VALUES (9,'Ismail','Hacioglu','Male','1985-11-30','Istanbul, Turkey','134785698786','Turkey');
INSERT INTO `` (`Actor_id`,`First_name`,`Last_name`,`Gender`,`Dob`,`Address`,`Phone_number`,`Country`) VALUES (10,'Jennifer','Aniston','Female','1969-02-11','Los Angeles, California, U.S.','967875434612','USA');

-- ----------------------------
-- Function structure for `fun_max`
-- ----------------------------
DROP FUNCTION IF EXISTS `fun_max`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fun_max`(a int, b int) RETURNS int(11)
    NO SQL
BEGIN

declare c int;

if (a<b) then 
set c=b;
ELSE set c=a;
end if;

RETURN c;
end
;;
DELIMITER ;
