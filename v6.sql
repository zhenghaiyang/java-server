/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.7.18 : Database - v4
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`v4` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `v4`;

/*Table structure for table `pmenu` */

DROP TABLE IF EXISTS `pmenu`;

CREATE TABLE `pmenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menuPath` varchar(40) DEFAULT NULL,
  `menuName` varchar(40) DEFAULT NULL,
  `menuCode` varchar(40) DEFAULT NULL,
  `parentCode` varchar(40) DEFAULT NULL,
  `userType` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `pmenu` */

insert  into `pmenu`(`id`,`menuPath`,`menuName`,`menuCode`,`parentCode`,`userType`) values (1,'/user','用户管理','100','1','1'),(2,'/project','项目管理','101','1','1'),(3,'','统计','102','1','1'),(4,'/detil-projectDetil','按项目统计','103','102','1'),(5,'/detil-userDetil','按用户统计','104','102','1'),(6,'/detil-timeDetil','按时间统计','105','102','1'),(7,'/projectImport','项目录入','106','1','2'),(8,'/userDetils','个人项目统计','107','1','2');

/*Table structure for table `pposition` */

DROP TABLE IF EXISTS `pposition`;

CREATE TABLE `pposition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(40) DEFAULT NULL,
  `value` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `pposition` */

insert  into `pposition`(`id`,`key`,`value`) values (3,'1','Java开发'),(4,'2','Web开发'),(5,'3','项目经理'),(6,'4','测试'),(7,'5','需求人员'),(8,'6','产品人员'),(9,'7','项目临时支持');

/*Table structure for table `pproject` */

DROP TABLE IF EXISTS `pproject`;

CREATE TABLE `pproject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(40) DEFAULT NULL,
  `createdTime` date DEFAULT NULL,
  `startTime` date DEFAULT NULL,
  `endTime` date DEFAULT NULL,
  `projectManage` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `pproject` */

insert  into `pproject`(`id`,`projectName`,`createdTime`,`startTime`,`endTime`,`projectManage`) values (9,'光大银行','2019-01-14','2018-12-26',NULL,NULL),(10,'广大2','2019-01-14','2019-01-14',NULL,NULL),(11,'1222','2019-01-21','2019-01-21',NULL,NULL),(12,'4444','2019-01-21','2019-01-21','2019-03-21','1');

/*Table structure for table `ptime` */

DROP TABLE IF EXISTS `ptime`;

CREATE TABLE `ptime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(40) DEFAULT NULL,
  `value` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `ptime` */

insert  into `ptime`(`id`,`key`,`value`) values (1,'0.1','0.1天'),(2,'0.2','0.2天'),(3,'0.3','0.3天'),(4,'0.4','0.4天'),(5,'0.5','0.5天'),(6,'0.6','0.6天'),(7,'0.7','0.7天'),(8,'0.8','0.8天'),(9,'0.9','0.9天'),(10,'1','1天');

/*Table structure for table `puser` */

DROP TABLE IF EXISTS `puser`;

CREATE TABLE `puser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(40) DEFAULT NULL,
  `userCode` varchar(40) DEFAULT NULL,
  `userPassword` varchar(40) DEFAULT NULL,
  `userType` int(11) DEFAULT NULL,
  `userPositionCode` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `puser` */

insert  into `puser`(`id`,`userName`,`userCode`,`userPassword`,`userType`,`userPositionCode`) values (1,'孙悟空','admin','14e1b600b1fd579f47433b88e8d85291',1,'3'),(19,'寻博凯','xunbokai','b993dd02505a9a0d146550f501cd69c8',2,'1'),(20,'郑海洋','zhenghaiyang','1f32aa4c9a1d2ea010adcf2348166a04',2,'2'),(21,'张鑫','zhangxin','1f32aa4c9a1d2ea010adcf2348166a04',2,'1'),(22,'王强','wangqiang','1f32aa4c9a1d2ea010adcf2348166a04',2,'1'),(23,'代秀磊','daixiulei','1f32aa4c9a1d2ea010adcf2348166a04',2,'2'),(24,'王庚午','wanggengwu','1f32aa4c9a1d2ea010adcf2348166a04',2,'3'),(25,'卢秋明','luqiuming','1f32aa4c9a1d2ea010adcf2348166a04',2,'6');

/*Table structure for table `userAndProject` */

DROP TABLE IF EXISTS `userAndProject`;

CREATE TABLE `userAndProject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  `userTime` varchar(40) DEFAULT NULL,
  `userPosition` varchar(40) DEFAULT NULL,
  `importProjectTime` date DEFAULT NULL,
  `workType` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

/*Data for the table `userAndProject` */

insert  into `userAndProject`(`id`,`userId`,`projectId`,`userTime`,`userPosition`,`importProjectTime`,`workType`) values (42,19,9,'1','1','2019-01-14',NULL),(43,24,10,'0.1','1','2019-01-14',NULL),(44,24,9,'0.2','1','2019-01-14',NULL),(45,20,9,'0.2','2','2019-01-20','2'),(46,20,9,'1','4','2019-01-20','2'),(49,20,9,'1','2','2019-01-21','1'),(50,20,9,'1','2','2019-01-22','2'),(51,20,9,'1','2','2019-02-21','2'),(52,20,9,'1','1','2019-01-18','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
