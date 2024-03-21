CREATE DATABASE  IF NOT EXISTS `community` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `community`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: community
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `fi_num` int NOT NULL AUTO_INCREMENT,
  `fi_bo_num` int NOT NULL,
  `fi_name` varchar(150) NOT NULL,
  `fi_ori_name` varchar(50) NOT NULL,
  PRIMARY KEY (`fi_num`),
  KEY `FK_board_TO_file_1` (`fi_bo_num`),
  CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (`fi_bo_num`) REFERENCES `board` (`bo_num`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (3,19,'/2024/03/04/cac52419-85cb-4fc7-9689-bcdacc6ea8e7_ezgif.com-animated-gif-maker.gif','ezgif.com-animated-gif-maker.gif'),(5,21,'/2024/03/04/fc09ec43-9f9f-4780-b165-963764e5fc43_제목 없음.png','제목 없음.png'),(8,18,'/2024/03/05/574ec9b4-158c-4729-81a8-a3d54586a279_화면 캡처 2024-02-14 183101.png','화면 캡처 2024-02-14 183101.png'),(16,23,'/2024/03/05/c1f61221-dac2-47bb-af3c-ac7cbd656e45_배고픔.png','배고픔.png'),(38,33,'/2024/03/15/f253eb1f-c77d-460e-b2b7-9c3453232a0d_기상.webp','기상.webp'),(39,33,'/2024/03/15/2beeac57-3528-4a8d-87df-40ef601fa3a7_로스트비프동.png','로스트비프동.png'),(40,33,'/2024/03/15/5b561f4f-578f-4f58-ad72-29c22f598437_hungry.png','hungry.png');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-21 10:46:35
