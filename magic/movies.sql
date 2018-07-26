/*
Navicat MySQL Data Transfer

Source Server         : 123456
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : learning

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-07-26 17:47:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for movies
-- ----------------------------
DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `linkList` varchar(255) DEFAULT NULL,
  `imgUrl` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `actor` varchar(255) DEFAULT NULL,
  `rate` varchar(255) DEFAULT NULL,
  `peoRate` varchar(255) DEFAULT NULL,
  `intr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movies
-- ----------------------------
INSERT INTO `movies` VALUES ('1', '2222', '3333', '44544', '5555', '666', '777', '8888');
