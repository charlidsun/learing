/*
Navicat MySQL Data Transfer

Source Server         : 123456
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : seven

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-07-23 15:08:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dic_book
-- ----------------------------
DROP TABLE IF EXISTS `dic_book`;
CREATE TABLE `dic_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `publish_year` varchar(255) DEFAULT NULL,
  `cover_img` varchar(255) DEFAULT NULL,
  `introduction` varchar(3000) DEFAULT NULL,
  `lock` int(1) DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dic_book
-- ----------------------------
INSERT INTO `dic_book` VALUES ('1', 'Of Mice and Men', ' John Steinbeck', '1937', 'http://interactivejoe.com/book-viewer/assets/images/bk_1-small.jpg', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam luctus convallis sem. Nunc sed tristique augue. Aenean at nulla vel lacus volutpat bibendum vitae ut nibh. Aliquam eu metus et purus rutrum malesuada. Aenean in auctor mauris, non vulputate libero. Nullam auctor, purus ut cursus convallis, lectus tellus dignissim lectus, id tempor ipsum leo ut nulla. Vestibulum vitae elit erat.', '0', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam luctus convallis sem. Nunc sed tristique augue. Aenean at nulla vel lacus volutpat bibendum vitae ut nibh. Aliquam eu metus et purus rutrum malesuada. Aenean in auctor mauris, non vulputate libero. Nullam auctor, purus ut cursus convallis, lectus tellus dignissim lectus, id tempor ipsum leo ut nulla. Vestibulum vitae elit erat.');
INSERT INTO `dic_book` VALUES ('2', '\r\nThe Catcher in the Rye', 'J.D. Salinger', '1951', 'http://interactivejoe.com/book-viewer/assets/images/bk_2-small.jpg', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam luctus convallis sem. Nunc sed tristique augue. Aenean at nulla vel lacus volutpat bibendum vitae ut nibh. Aliquam eu metus et purus rutrum malesuada. Aenean in auctor mauris, non vulputate libero. Nullam auctor, purus ut cursus convallis, lectus tellus dignissim lectus, id tempor ipsum leo ut nulla. Vestibulum vitae elit erat.', '0', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam luctus convallis sem. Nunc sed tristique augue. Aenean at nulla vel lacus volutpat bibendum vitae ut nibh. Aliquam eu metus et purus rutrum malesuada. Aenean in auctor mauris, non vulputate libero. Nullam auctor, purus ut cursus convallis, lectus tellus dignissim lectus, id tempor ipsum leo ut nulla. Vestibulum vitae elit erat.');
INSERT INTO `dic_book` VALUES ('3', '1984', ' George Orwell', '1949', 'http://interactivejoe.com/book-viewer/assets/images/bk_3-small.jpg', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam luctus convallis sem. Nunc sed tristique augue. Aenean at nulla vel lacus volutpat bibendum vitae ut nibh. Aliquam eu metus et purus rutrum malesuada. Aenean in auctor mauris, non vulputate libero. Nullam auctor, purus ut cursus convallis, lectus tellus dignissim lectus, id tempor ipsum leo ut nulla. Vestibulum vitae elit erat.', '0', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam luctus convallis sem. Nunc sed tristique augue. Aenean at nulla vel lacus volutpat bibendum vitae ut nibh. Aliquam eu metus et purus rutrum malesuada. Aenean in auctor mauris, non vulputate libero. Nullam auctor, purus ut cursus convallis, lectus tellus dignissim lectus, id tempor ipsum leo ut nulla. Vestibulum vitae elit erat.');
INSERT INTO `dic_book` VALUES ('4', 'Lord of the Flies', 'William Golding', '1954', 'http://interactivejoe.com/book-viewer/assets/images/bk_4-small.jpg', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam luctus convallis sem. Nunc sed tristique augue. Aenean at nulla vel lacus volutpat bibendum vitae ut nibh. Aliquam eu metus et purus rutrum malesuada. Aenean in auctor mauris, non vulputate libero. Nullam auctor, purus ut cursus convallis, lectus tellus dignissim lectus, id tempor ipsum leo ut nulla. Vestibulum vitae elit erat.', '0', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam luctus convallis sem. Nunc sed tristique augue. Aenean at nulla vel lacus volutpat bibendum vitae ut nibh. Aliquam eu metus et purus rutrum malesuada. Aenean in auctor mauris, non vulputate libero. Nullam auctor, purus ut cursus convallis, lectus tellus dignissim lectus, id tempor ipsum leo ut nulla. Vestibulum vitae elit erat.');
INSERT INTO `dic_book` VALUES ('5', 'The Great Gatsby', ' F. Scott Fitzgerald', '1925', 'http://interactivejoe.com/book-viewer/assets/images/bk_5-small.jpg', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam luctus convallis sem. Nunc sed tristique augue. Aenean at nulla vel lacus volutpat bibendum vitae ut nibh. Aliquam eu metus et purus rutrum malesuada. Aenean in auctor mauris, non vulputate libero. Nullam auctor, purus ut cursus convallis, lectus tellus dignissim lectus, id tempor ipsum leo ut nulla. Vestibulum vitae elit erat.', '0', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam luctus convallis sem. Nunc sed tristique augue. Aenean at nulla vel lacus volutpat bibendum vitae ut nibh. Aliquam eu metus et purus rutrum malesuada. Aenean in auctor mauris, non vulputate libero. Nullam auctor, purus ut cursus convallis, lectus tellus dignissim lectus, id tempor ipsum leo ut nulla. Vestibulum vitae elit erat.');

-- ----------------------------
-- Table structure for dic_categories
-- ----------------------------
DROP TABLE IF EXISTS `dic_categories`;
CREATE TABLE `dic_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dic_categories
-- ----------------------------
INSERT INTO `dic_categories` VALUES ('1', 'Fantasy');
INSERT INTO `dic_categories` VALUES ('2', 'Sci-Fi');
INSERT INTO `dic_categories` VALUES ('3', 'Classics');
INSERT INTO `dic_categories` VALUES ('4', 'Fairy');

-- ----------------------------
-- Table structure for dic_rock
-- ----------------------------
DROP TABLE IF EXISTS `dic_rock`;
CREATE TABLE `dic_rock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `net_url` varchar(255) DEFAULT NULL,
  `head_img` varchar(255) DEFAULT NULL,
  `sort` int(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dic_rock
-- ----------------------------
INSERT INTO `dic_rock` VALUES ('1', '思维福', 'http://7xnqfz.com1.z0.glb.clouddn.com/69.mp3', 'http://7xnqfz.com1.z0.glb.clouddn.com/%E4%B8%8B%E8%BD%BD.jpg', '1', '2018-07-23 09:24:44', '让我们震撼你');
INSERT INTO `dic_rock` VALUES ('2', '张三丰', 'http://7xnqfz.com1.z0.glb.clouddn.com/69.mp3', 'http://7xnqfz.com1.z0.glb.clouddn.com/%E4%B8%8B%E8%BD%BD.jpg', '2', '2018-07-23 09:24:46', '落霞与孤鹜齐飞');
INSERT INTO `dic_rock` VALUES ('3', '张三丰', 'http://7xnqfz.com1.z0.glb.clouddn.com/69.mp3', 'http://7xnqfz.com1.z0.glb.clouddn.com/%E4%B8%8B%E8%BD%BD.jpg', '2', '2018-07-23 09:24:46', '落霞与孤鹜齐飞');

-- ----------------------------
-- Table structure for rel_book_categories
-- ----------------------------
DROP TABLE IF EXISTS `rel_book_categories`;
CREATE TABLE `rel_book_categories` (
  `book_id` int(11) NOT NULL,
  `categories_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of rel_book_categories
-- ----------------------------
INSERT INTO `rel_book_categories` VALUES ('1', '1');
INSERT INTO `rel_book_categories` VALUES ('2', '2');
INSERT INTO `rel_book_categories` VALUES ('3', '3');
INSERT INTO `rel_book_categories` VALUES ('4', '4');
INSERT INTO `rel_book_categories` VALUES ('5', '4');
