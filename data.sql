-- MySQL dump 10.13  Distrib 5.5.24, for Win64 (x86)
--
-- Host: localhost    Database: sparknetworks
-- ------------------------------------------------------
-- Server version	5.5.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matches`
--

DROP TABLE IF EXISTS `matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `display_name` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `job_title` varchar(50) DEFAULT NULL,
  `height_in_cm` decimal(10,2) DEFAULT NULL,
  `cityname` varchar(50) DEFAULT NULL,
  `latitude` decimal(10,2) DEFAULT NULL,
  `longitude` decimal(10,2) DEFAULT NULL,
  `main_photo` varchar(1000) DEFAULT NULL,
  `compatibility_score` decimal(10,2) DEFAULT NULL,
  `contacts_exchanged` int(11) DEFAULT NULL,
  `favourite` varchar(10) DEFAULT NULL,
  `religion` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matches`
--

LOCK TABLES `matches` WRITE;
/*!40000 ALTER TABLE `matches` DISABLE KEYS */;
INSERT INTO `matches` VALUES (1,'Caroline',41,'Corporate Lawyer',153.00,'Leeds',53.80,-1.55,'http://thecatapi.com/api/images/get?format=src&type=gif',0.76,2,'true','Atheist\r'),(2,'Sharon',47,'Doctor',161.00,'Solihull',52.41,-1.78,'http://thecatapi.com/api/images/get?format=src&type=gif',0.97,0,'false','Islam\r'),(3,'Natalia',38,'Project Manager',144.00,'Cardiff',51.48,-3.18,'http://thecatapi.com/api/images/get?format=src&type=gif',0.47,5,'false','Christian\r'),(4,'Marta',55,'Finance',140.00,'Eastbourne',50.77,0.29,'http://thecatapi.com/api/images/get?format=src&type=gif',0.95,0,'false','Agnostic\r'),(5,'Maria',43,'CEO',175.00,'London',51.51,-0.12,'http://thecatapi.com/api/images/get?format=src&type=gif',0.88,0,'false','Christian\r'),(6,'Stephanie',39,'Project Manager',153.00,'London',51.51,-0.12,NULL,0.87,4,'false','Christian\r'),(7,'Claire',48,'GP',167.00,'London',51.51,-0.12,'http://thecatapi.com/api/images/get?format=src&type=gif',0.83,6,'false','Atheist\r'),(8,'Colette',39,'Doctor - Hospital',177.00,'Swindon',51.57,-1.77,'http://thecatapi.com/api/images/get?format=src&type=gif',0.89,2,'false','Christian\r'),(9,'Caroline',43,'Marketing Consultant',160.00,'Oxford',51.75,-1.26,'http://thecatapi.com/api/images/get?format=src&type=gif',0.91,1,'false','Atheist\r'),(10,'Kate',42,'Psychologist',160.00,'Salisbury',51.07,-1.79,'http://thecatapi.com/api/images/get?format=src&type=gif',0.97,10,'false','Buddhist\r'),(11,'Katie',40,'Lawyer',148.00,'Weymouth',50.61,-2.46,NULL,0.94,0,'false','Atheist\r'),(12,'Clare',40,'Accountant',144.00,'Bournemouth',50.72,-1.90,'http://thecatapi.com/api/images/get?format=src&type=gif',0.90,8,'false','Christian\r'),(13,'Laura',39,'Lawyer',160.00,'Plymouth',50.38,-4.14,'http://thecatapi.com/api/images/get?format=src&type=gif',0.89,0,'false','Christian\r'),(14,'Katlin',39,'Barrister',153.00,'Inverness',57.48,-4.22,'http://thecatapi.com/api/images/get?format=src&type=gif',0.87,0,'true','Jewish\r'),(15,'Tracy',39,'Lawyer',153.00,'Aberdeen',57.15,-2.10,'http://thecatapi.com/api/images/get?format=src&type=gif',0.87,0,'false','Christian\r'),(16,'Angie',50,'Accountant',153.00,'Ayr',55.46,-4.63,'http://thecatapi.com/api/images/get?format=src&type=gif',0.93,8,'true','Atheist\r'),(17,'Samantha',32,'Project Manager',161.00,'Belfast',54.61,-5.93,'http://thecatapi.com/api/images/get?format=src&type=gif',0.89,0,'false','Christian\r'),(18,'Elizabeth',41,'Dentist',145.00,'Londonderry',55.01,-7.32,'http://thecatapi.com/api/images/get?format=src&type=gif',0.83,4,'true','Islam\r'),(19,'Emma',40,'Banker',150.00,'Leeds',53.80,-1.55,'http://thecatapi.com/api/images/get?format=src&type=gif',0.73,0,'false','Christian\r'),(20,'Diana',44,'Consultant',153.00,'London',51.51,-0.12,'http://thecatapi.com/api/images/get?format=src&type=gif',0.50,0,'false','Atheist\r'),(21,'Kysha',45,'Lawyer',144.00,'London',51.51,-0.12,NULL,0.88,10,'true','Islam\r'),(22,'Anne',38,'Marketing Consultant',170.00,'Swindon',51.57,-1.77,'http://thecatapi.com/api/images/get?format=src&type=gif',0.88,0,'false','Jewish\r'),(23,'Daniela',37,'Doctor',177.00,'Bournemouth',50.72,-1.90,'http://thecatapi.com/api/images/get?format=src&type=gif',0.76,0,'false','Christian\r'),(24,'Katherine',39,'Lawyer',177.00,'London',51.51,-0.12,'http://thecatapi.com/api/images/get?format=src&type=gif',0.99,50,'true','Atheist\r'),(25,'Susan',25,'Project Manager',166.00,'Harlow',51.77,0.10,'http://thecatapi.com/api/images/get?format=src&type=gif',0.88,0,'false','Christian\r');
/*!40000 ALTER TABLE `matches` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-22 22:07:36
