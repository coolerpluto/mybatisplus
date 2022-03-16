/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : mybatis_plus

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 16/03/2022 16:30:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `id` bigint NOT NULL COMMENT '主键ID',
  `NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `price` int NULL DEFAULT 0 COMMENT '价格',
  `VERSION` int NULL DEFAULT 0 COMMENT '乐观锁版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES (1, '外星人笔记本', 120, 3);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `uid` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `is_deleted` int NULL DEFAULT 0,
  `gender` int NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1503661351938142214 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'Jone', 18, 'test1@baomidou.com', 0, NULL);
INSERT INTO `t_user` VALUES (2, 'Jack', 20, 'test2@baomidou.com', 0, NULL);
INSERT INTO `t_user` VALUES (3, 'Tom', 28, 'test3@baomidou.com', 0, NULL);
INSERT INTO `t_user` VALUES (4, 'Sandy', 21, 'test4@baomidou.com', 0, NULL);
INSERT INTO `t_user` VALUES (5, 'Billie', 24, 'test5@baomidou.com', 0, NULL);
INSERT INTO `t_user` VALUES (1503661351938142212, 'zhangsan', 17, 'zhangsan@qq.com', 0, NULL);
INSERT INTO `t_user` VALUES (1503661351938142213, '小吴', 20, 'xiaowu@qq.com', 0, 1);

SET FOREIGN_KEY_CHECKS = 1;
