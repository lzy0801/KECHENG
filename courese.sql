/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.39 : Database - course
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`course` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `course`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `coursename` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `coursenum` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `courseteacher` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `coursedate` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '',
  `coursedesc` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `courseroom` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '',
  `status` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

/*Data for the table `course` */

insert  into `course`(`id`,`coursename`,`coursenum`,`courseteacher`,`coursedate`,`coursedesc`,`courseroom`,`status`) values 
('0576526','zzzz','20','05','星期一,星期二1-2,3-4',NULL,'A教室','1'),
('07197654','mysql','187','01','星期一,星期二3-4,7-8',NULL,'B教室','1'),
('1687944','javaboot','51','03','星期二3-4',NULL,'B教室','1'),
('21238783','java','188','03','星期二,星期三,星期六5-6,9-10,11-12',NULL,'C教室','1'),
('73515590','数据结构','168','02','星期二,星期五5-6,11-12,7-8','111','B教室,D教室','1'),
('7638153','王者荣耀','1000','zr10','星期一,星期二,星期三,星期四,星期五9-10,11-12',NULL,'A教室','1'),
('87179597','计算机网络','177','03','星期二,星期三,星期五3-4,5-6','111','B教室,C教室','1');

/*Table structure for table `crcount` */

DROP TABLE IF EXISTS `crcount`;

CREATE TABLE `crcount` (
  `id` int NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '教师名称',
  `tk_count` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '听课次数',
  `bt_count` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '被听课次数',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8662422 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='课程统计信息';

/*Data for the table `crcount` */

insert  into `crcount`(`id`,`teacher_name`,`tk_count`,`bt_count`,`create_time`,`updatetime`) values 
(7403534,'李四','2','1','2021-03-31 15:03:01','2021-04-09 11:44:49'),
(8662421,'张三','1','3','2021-03-31 14:57:50','2021-04-09 11:44:49');

/*Table structure for table `curelation` */

DROP TABLE IF EXISTS `curelation`;

CREATE TABLE `curelation` (
  `id` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `courseid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `userid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `type` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

/*Data for the table `curelation` */

insert  into `curelation`(`id`,`courseid`,`userid`,`type`) values 
('92289250','07197654','05','mysql'),
('99923581','7638153','zr10','王者荣耀');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `creatdate` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `userid` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

/*Data for the table `notice` */

insert  into `notice`(`id`,`creatdate`,`content`,`userid`,`title`) values 
('426618','2024-11-30 14:47:02','hhysb111','admin','黄hysb'),
('459835','2024-11-30 15:37:59','大发一份','admin','zhh'),
('636920','2024-11-30 23:15:20','自行车v方法F','admin','zzgggg'),
('674990','2024-11-29 22:30:26','ggggggggggggggggggg','admin','ggg'),
('735993','2024-11-30 10:10:05','151515','admin','11132'),
('774112','2024-12-01 14:24:10','22555','admin','zzzzz'),
('940340','2024-11-30 23:18:43','蟹老板，我下班啦！！','admin','蟹堡王的章鱼哥'),
('984287','2023-01-20 22:19:04','粤嵌教师上课安排完成了','admin','粤嵌教师上课安排完成了');

/*Table structure for table `power` */

DROP TABLE IF EXISTS `power`;

CREATE TABLE `power` (
  `id` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `roleid` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `power` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

/*Data for the table `power` */

insert  into `power`(`id`,`roleid`,`power`) values 
('1','1111','2001,3001,4002'),
('2','2222','1001,2001,3001,3002,4002'),
('3','3333','1001,1002,2001,3001,3002,4001,4002');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleid` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `powerid` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `rolename` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`roleid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

/*Data for the table `role` */

insert  into `role`(`roleid`,`powerid`,`rolename`) values 
('0001','1111','教师'),
('0002','2222','主任'),
('0003','3333','管理员');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `mobile` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `roleid` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `type` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`sex`,`mobile`,`roleid`,`password`,`type`) values 
('01','张三','男','13546895132','0001','123456','1'),
('02','李四','男','13586952257','0001','123456','1'),
('03','刘六','男','18963214584','0001','123456','1'),
('05','dad','男','123','0001','123456','1'),
('admin','管理员','男','18813935480','0003','1234','3'),
('zr10','李振裕','男','15218121784','0002','123456','2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
