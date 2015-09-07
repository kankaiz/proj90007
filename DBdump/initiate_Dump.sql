CREATE DATABASE  IF NOT EXISTS `proj90007` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `proj90007`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: proj90007
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(45) NOT NULL,
  PRIMARY KEY (`dept_id`),
  UNIQUE KEY `id_UNIQUE` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='dept table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `peformance_review`
--

DROP TABLE IF EXISTS `peformance_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peformance_review` (
  `id` int(11) NOT NULL,
  `initiator_id` int(11) NOT NULL,
  `review_year` int(11) DEFAULT NULL,
  `status` enum('initiate','supervisor','HR') NOT NULL,
  `reviewed_supervisor_id` int(11) DEFAULT NULL,
  `self_rate` int(11) DEFAULT NULL,
  `self_assessment` varchar(200) DEFAULT NULL,
  `new_goal` varchar(200) DEFAULT NULL,
  `supervisor_rate` int(11) DEFAULT NULL,
  `supervisor_assessment` varchar(200) DEFAULT NULL,
  `collaboration` int(11) DEFAULT NULL,
  `communication` int(11) DEFAULT NULL,
  `customer_focus` int(11) DEFAULT NULL,
  `business_professional` int(11) DEFAULT NULL,
  `reviewed_HR_id` int(11) DEFAULT NULL,
  `HR_rate` int(11) DEFAULT NULL,
  `HR_assessment` varchar(200) DEFAULT NULL,
  `compliance` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_initiator_id_idx` (`initiator_id`),
  KEY `fk_review_supervisor_id_idx` (`reviewed_supervisor_id`),
  KEY `fk_review_HR_id_idx` (`reviewed_HR_id`),
  CONSTRAINT `fk_initiator_id` FOREIGN KEY (`initiator_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_HR_id` FOREIGN KEY (`reviewed_HR_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_supervisor_id` FOREIGN KEY (`reviewed_supervisor_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profile` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id_idx` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `supervisor_id` int(11) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `status` enum('normal','resigned') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dept_id_idx` (`dept_id`),
  KEY `fk_supervisor_id_idx` (`supervisor_id`),
  CONSTRAINT `fk_dept_id` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_supervisor_id` FOREIGN KEY (`supervisor_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-06 23:20:32
