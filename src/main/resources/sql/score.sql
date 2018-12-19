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

 Date: 19/12/2018 16:59:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `st_id` varchar(50) DEFAULT NULL,
  `kc_id` varchar(50) DEFAULT NULL,
  `kc_score` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
BEGIN;
INSERT INTO `score` VALUES ('s101', 'K01', '100');
INSERT INTO `score` VALUES ('s101', 'K02', '50');
INSERT INTO `score` VALUES ('s101', 'K03', '70');
INSERT INTO `score` VALUES ('s102', 'K01', '100');
INSERT INTO `score` VALUES ('s102', 'K02', '70');
INSERT INTO `score` VALUES ('s102', 'K03', '70');
INSERT INTO `score` VALUES ('s103', 'K01', '100');
INSERT INTO `score` VALUES ('s103', 'K02', '70');
INSERT INTO `score` VALUES ('s103', 'K03', '70');
INSERT INTO `score` VALUES ('s104', 'K01', '50');
INSERT INTO `score` VALUES ('s104', 'K02', '50');
INSERT INTO `score` VALUES ('s104', 'K03', '70');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
