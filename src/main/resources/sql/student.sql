/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 19/12/2018 17:00:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `st_id` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `c_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('s101', '王五', 'C1');
INSERT INTO `student` VALUES ('s102', 'A2', 'C1');
INSERT INTO `student` VALUES ('s103', '张3', 'C2');
INSERT INTO `student` VALUES ('s104', '张4', 'C2');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
