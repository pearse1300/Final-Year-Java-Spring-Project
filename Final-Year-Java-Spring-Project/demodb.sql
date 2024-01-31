-- MySQL dump 10.13  Distrib 5.7.28, for Linux (x86_64)
--
-- Host: localhost    Database: demodb
-- ------------------------------------------------------
-- Server version	5.7.28-0ubuntu0.18.04.4

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
-- Table structure for table `AKUMA`
--

DROP TABLE IF EXISTS `AKUMA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AKUMA` (
  `MoveID` int(11) NOT NULL,
  `Command` varchar(45) NOT NULL,
  `Hit Level` varchar(45) NOT NULL,
  `Damage` int(11) NOT NULL,
  `Start Up Frame` int(11) NOT NULL,
  `Block Frame` int(11) NOT NULL,
  `Hit Frame` int(11) DEFAULT NULL,
  `Hit Property` varchar(45) DEFAULT NULL,
  `Counterhit Frame` int(11) NOT NULL,
  `Counter Hit Property` varchar(45) DEFAULT NULL,
  `Notes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MoveID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AKUMA`
--

LOCK TABLES `AKUMA` WRITE;
/*!40000 ALTER TABLE `AKUMA` DISABLE KEYS */;
INSERT INTO `AKUMA` VALUES (1,'1','H',7,10,1,8,NULL,8,NULL,NULL),(2,'DF2','M',12,15,-3,5,NULL,5,'CounterHit Launcher',NULL);
/*!40000 ALTER TABLE `AKUMA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `character_frame_data`
--

DROP TABLE IF EXISTS `character_frame_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `character_frame_data` (
  `id` int(11) NOT NULL,
  `character` varchar(255) NOT NULL,
  `move_number` int(11) NOT NULL,
  `command` varchar(255) NOT NULL,
  `hit_level` varchar(255) NOT NULL,
  `damage` int(11) NOT NULL,
  `start_up_frame` int(11) NOT NULL,
  `block_frame` int(11) NOT NULL,
  `hit_frame` int(11) DEFAULT NULL,
  `hit_property` varchar(255) DEFAULT NULL,
  `counterhit_frame` int(11) DEFAULT NULL,
  `counterhit_property` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `character_frame_data`
--

LOCK TABLES `character_frame_data` WRITE;
/*!40000 ALTER TABLE `character_frame_data` DISABLE KEYS */;
INSERT INTO `character_frame_data` VALUES (1,'Akuma',1,'1','H',7,10,1,8,NULL,8,NULL,NULL);
/*!40000 ALTER TABLE `character_frame_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-02 20:42:45
