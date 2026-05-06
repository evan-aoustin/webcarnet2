-- MariaDB dump 10.19  Distrib 10.5.19-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: car_net
-- ------------------------------------------------------
-- Server version       10.5.19-MariaDB-0+deb11u2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Entretien`
--

DROP TABLE IF EXISTS `Entretien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Entretien` (
  `idEntretien` int(11) NOT NULL AUTO_INCREMENT,
  `dateEntretien` date NOT NULL,
  `nbKmCompteur` int(11) NOT NULL,
  `commentaire` text DEFAULT NULL,
  `numImma` varchar(20) DEFAULT NULL,
  `codeEntretienType` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEntretien`),
  KEY `numImma` (`numImma`),
  KEY `codeEntretienType` (`codeEntretienType`),
  CONSTRAINT `Entretien_ibfk_1` FOREIGN KEY (`numImma`) REFERENCES `Vehicule` (`numImma`),
  CONSTRAINT `Entretien_ibfk_2` FOREIGN KEY (`codeEntretienType`) REFERENCES `EntretienType` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Entretien`
--

LOCK TABLES `Entretien` WRITE;
/*!40000 ALTER TABLE `Entretien` DISABLE KEYS */;
INSERT INTO `Entretien` VALUES (1,'2024-01-15',5000,'Vidange moteur','AA-001-AA',1),(2,'2024-06-10',10000,'Révision légère','AA-001-AA',2),(3,'2024-02-20',10000,'Vidange moteur','BB-002-BB',1),(4,'2024-08-15',20000,'Révision semestrielle','BB-002-BB',4),(5,'2024-09-01',25000,'Contrôle freins','BB-002-BB',3),(6,'2023-12-10',50000,'Grosse révision','CC-003-CC',7),(7,'2024-06-01',52000,'Révision totale','CC-003-CC',8),(8,'2024-03-05',5000,'Vidange moteur','DD-004-DD',1),(9,'2024-07-20',15000,'Contrôle freins','DD-004-DD',3),(10,'2024-08-15',15000,'Révision légère','DD-004-DD',2),(11,'2024-01-10',5000,'Vidange moteur','EE-005-EE',1),(12,'2024-05-15',8000,'Révision légère','EE-005-EE',2),(13,'2023-11-20',20000,'Révision semestrielle','FF-006-FF',4),(14,'2024-04-10',40000,'Révision complète','FF-006-FF',6),(15,'2024-01-01',50000,'Grosse révision','GG-007-GG',7),(16,'2025-08-01',60000,'Révision totale','GG-007-GG',8),(17,'2025-02-05',10000,'Vidange moteur','HH-008-HH',1),(18,'2025-07-10',30000,'Changement courroie','HH-008-HH',5),(19,'2024-03-10',5000,'Vidange moteur','II-009-II',1),(20,'2025-09-15',10000,'Révision légère','II-009-II',2),(21,'2023-12-01',20000,'Révision semestrielle','JJ-010-JJ',4),(22,'2024-06-20',45000,'Révision complète','JJ-010-JJ',6);
/*!40000 ALTER TABLE `Entretien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EntretienType`
--

DROP TABLE IF EXISTS `EntretienType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EntretienType` (
  `code` int(11) NOT NULL,
  `nbKm` int(11) NOT NULL,
  `nbKmTolere` int(11) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EntretienType`
--

LOCK TABLES `EntretienType` WRITE;
/*!40000 ALTER TABLE `EntretienType` DISABLE KEYS */;
INSERT INTO `EntretienType` VALUES (1,5000,200),(2,10000,500),(3,15000,500),(4,20000,1000),(5,30000,1000),(6,40000,1500),(7,50000,2000),(8,60000,2500);
/*!40000 ALTER TABLE `EntretienType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vehicule`
--

DROP TABLE IF EXISTS `Vehicule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Vehicule` (
  `numImma` varchar(20) NOT NULL,
  `nbKmActuel` int(11) NOT NULL,
  PRIMARY KEY (`numImma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vehicule`
--

LOCK TABLES `Vehicule` WRITE;
/*!40000 ALTER TABLE `Vehicule` DISABLE KEYS */;
INSERT INTO `Vehicule` VALUES ('AA-001-AA',12000),('BB-002-BB',25000),('CC-003-CC',52000),('DD-004-DD',15000),('EE-005-EE',8000),('FF-006-FF',40000),('GG-007-GG',60000),('HH-008-HH',30000),('II-009-II',10000),('JJ-010-JJ',45000);
/*!40000 ALTER TABLE `Vehicule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `role` varchar(50) NOT NULL DEFAULT 'MECANICIEN',
  PRIMARY KEY (`id`),
  UNIQUE KEY `mail_unique` (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-01 16:16:02

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `role` varchar(50) NOT NULL DEFAULT 'MECANICIEN',
  PRIMARY KEY (`id`),
  UNIQUE KEY `mail` (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;