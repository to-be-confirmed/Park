/*
Navicat MySQL Data Transfer

Source Server         : park
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : parkpark

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2015-04-19 10:51:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pp_order`
-- ----------------------------
DROP TABLE IF EXISTS `pp_order`;
CREATE TABLE `pp_order` (
  `o_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `s_id` bigint(20) unsigned NOT NULL COMMENT '对应车位快照',
  `o_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  PRIMARY KEY (`o_id`),
  UNIQUE KEY `o_id` (`o_id`),
  CONSTRAINT `pp_order_ibfk_1` FOREIGN KEY (`o_id`) REFERENCES `pp_parksnap` (`s_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='订单表';

-- ----------------------------
-- Records of pp_order
-- ----------------------------

-- ----------------------------
-- Table structure for `pp_parksnap`
-- ----------------------------
DROP TABLE IF EXISTS `pp_parksnap`;
CREATE TABLE `pp_parksnap` (
  `s_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '快照编号',
  `p_id` bigint(20) unsigned NOT NULL COMMENT '车位编号',
  `p_addr` varchar(200) CHARACTER SET utf8 NOT NULL COMMENT '车位地址',
  `p_number` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '车位号',
  `p_time_start` datetime NOT NULL COMMENT '开始出租时段',
  `p_time_end` datetime NOT NULL COMMENT '结束出租时段',
  `p_price` int(11) unsigned NOT NULL COMMENT '出租价格/h',
  `s_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '快照创建时间',
  PRIMARY KEY (`s_id`),
  UNIQUE KEY `s_id` (`s_id`),
  CONSTRAINT `pp_parksnap_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `pp_parkspace` (`p_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='出租快照';

-- ----------------------------
-- Records of pp_parksnap
-- ----------------------------

-- ----------------------------
-- Table structure for `pp_parkspace`
-- ----------------------------
DROP TABLE IF EXISTS `pp_parkspace`;
CREATE TABLE `pp_parkspace` (
  `p_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `u_id` bigint(20) unsigned NOT NULL COMMENT '所属用户',
  `p_addr` varchar(200) CHARACTER SET utf8 NOT NULL COMMENT '车位地址',
  `p_number` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '车位号',
  `p_price` int(10) unsigned NOT NULL COMMENT '车位价格/h',
  `p_time_start` datetime NOT NULL COMMENT '出租开始时间',
  `p_time_end` datetime NOT NULL COMMENT '出租结束时间',
  `p_status` tinyint(4) NOT NULL DEFAULT '-1' COMMENT '-1.停租0.闲置1.已租',
  `p_imgs` text CHARACTER SET utf8 COMMENT '图片链接列表',
  PRIMARY KEY (`p_id`),
  UNIQUE KEY `p_id` (`p_id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `pp_parkspace_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `pp_users` (`u_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='车位表';

-- ----------------------------
-- Records of pp_parkspace
-- ----------------------------
INSERT INTO `pp_parkspace` VALUES ('1', '1', '上海浦东新区', '12', '10', '2015-04-18 09:28:07', '2015-04-18 12:28:11', '-1', null);

-- ----------------------------
-- Table structure for `pp_users`
-- ----------------------------
DROP TABLE IF EXISTS `pp_users`;
CREATE TABLE `pp_users` (
  `u_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `u_name` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '邮箱/手机号',
  `u_password` varchar(50) NOT NULL COMMENT '密码',
  `u_realname` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '真实密码',
  `u_phone` varchar(12) NOT NULL COMMENT '联系电话',
  `u_addr` varchar(200) CHARACTER SET utf8 NOT NULL COMMENT '地址',
  `u_sex` tinyint(4) DEFAULT '-1' COMMENT '性别-1表示没填写0.男1.女',
  `u_img` varchar(100) DEFAULT NULL COMMENT '图片地址',
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_id` (`u_id`),
  UNIQUE KEY `u_name` (`u_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='用户表';

-- ----------------------------
-- Records of pp_users
-- ----------------------------
INSERT INTO `pp_users` VALUES ('1', 'admin', 'admin', '管理员', '18550033403', '上海浦东新区', '0', null);
INSERT INTO `pp_users` VALUES ('2', 'kjyu', '123456', '于孔建', '18550033403', '上海浦东新区东波路', '1', '1.jpg');
INSERT INTO `pp_users` VALUES ('3', 'zxx', '123456', 'zhang', '1234567', '上海浦东新区东波路', '1', '1.jpg');
