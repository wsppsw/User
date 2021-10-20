/*
SQLyog v10.2 
MySQL - 5.0.18-nt : Database - sms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sms`;

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `myclass` varchar(255) default NULL,
  `score` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_student` */

insert  into `t_student`(`id`,`name`,`myclass`,`score`) values (1,'格林童话','童话类',20),(2,'茶楼（一）','文学类',77),(3,'安徒生讲故事','童话类',65),(4,'明朝那些事（三）','历史类',90),(5,'本草纲目','医学类',150),(6,'狂人日记','文学类',55),(7,'黄帝内经','医学类',66),(8,'阿Q正传','文学类',48),(9,'C语言编程','教材类',142),(10,'春秋与战国','历史类',120),(11,'莫泊桑短篇集','文学类',45),(12,'茶楼（三）','文学类',100),(13,'红岩','文学类',22),(14,'水经注','医学类',66),(15,'XML入门','教材类',78),(16,'上下五千年','历史类',100),(17,'十万个为什么','科普类',120),(18,'大学英语','教材类',88),(19,'走进科学','科普类',100),(20,'明朝那些事（一）','历史类',140),(21,'口腔医学','医学类',55),(22,'牙牙学语','科普类',100),(23,'祝福','文学类',56),(24,'线性代数','教材类',89),(25,'骨科医学','医学类',77),(26,'三千问','科普类',100),(27,'少年闰土','文学类',120),(28,'中国近代史','历史类',130),(29,'水从哪里来','科普类',30),(30,'大学语文','教材类',46),(31,'灰姑娘','童话类',36),(32,'童谣','科普类',55),(33,'明朝那些事（二）','历史类',77),(34,'骆驼祥子（一）','文学类',100),(35,'Java编程','教材类',88),(36,'地球为什么是圆的','科普类',100),(37,'白雪公主','童话类',92),(38,'荆轲传','历史类',120),(39,'最可爱的人','文学类',152),(40,'急救学','医学类',110),(41,'项羽本纪','历史类',100),(42,'茶楼（四）','文学类',87),(43,'背影','文学类',56),(44,'荷塘月色','文学类',30),(45,'大秦帝国','历史类',45),(46,'难经','医学类',46),(47,'唐诗三百首','文学类',100),(48,'小红帽','童话类',82),(49,'雨','科普类',122),(50,'明治维新','历史类',100),(51,'教育学','教材类',52),(52,'逍遥游','文学类',100),(53,'史记','历史类',54),(54,'时间简史','科普类',100),(55,'护理学','医学类',89),(56,'再别康桥','文学类',150),(57,'大学物理','教材类',100),(58,'自然现象','科普类',54),(59,'青蛙王子','童话类',23),(60,'明朝那些事（五）','历史类',68),(61,'骆驼祥子（三）','文学类',45),(62,'茶楼（四）','文学类',100),(63,'科学调查','科普类',76),(64,'解剖学','医学类',100),(65,'三国志','历史类',89),(66,'药理','医学类',100),(67,'大学化学','教材类',120),(68,'清代史','历史类',100),(69,'骆驼祥子（三）','文学类',75),(70,'西方史','历史类',85),(71,'三只小猪','童话类',100),(72,'四世同堂','文学类',54),(73,'爬山虎','文学类',130),(74,'微机原理','教材类',22),(75,'明朝那些事（四）','历史类',120);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`) values (1,'admin','1234'),(2,'qqq','123'),(3,'qqq','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
