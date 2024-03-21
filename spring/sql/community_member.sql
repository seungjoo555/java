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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `me_id` varchar(13) NOT NULL,
  `me_ms_state` varchar(10) NOT NULL,
  `me_pw` varchar(255) NOT NULL,
  `me_email` varchar(30) NOT NULL,
  `me_authority` varchar(5) NOT NULL DEFAULT 'USER',
  `me_stop` datetime DEFAULT NULL,
  `me_fail` int NOT NULL DEFAULT '0',
  `me_cookie` varchar(255) DEFAULT NULL,
  `me_cookie_limit` datetime DEFAULT NULL,
  PRIMARY KEY (`me_id`),
  KEY `FK_member_state_TO_member_1` (`me_ms_state`),
  CONSTRAINT `FK_member_state_TO_member_1` FOREIGN KEY (`me_ms_state`) REFERENCES `member_state` (`ms_state`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('abc123','이용중','$2a$10$ISwGfJw9THg/llkZnYNQp.vO6jIRxXE28bAmjhg2DkWMdQRCfj2s6','ajinrhdwn@gmail.com','USER',NULL,0,NULL,NULL),('abcd123','이용중','$2a$10$lkzYzdPxv1J83p0kBexyFOfFOruII3B8pztRQWZQo2rnngWtF6zBO','eric394163@gmail.com','USER',NULL,0,NULL,NULL),('admin','이용중','$2a$10$ZRB6zadIhPRsGiAHe2BqWe3vN.URWDPT.SqerPYsjHQ7rPq1u/tBa','seungjoo8474@gmail.com','ADMIN',NULL,0,NULL,NULL),('asd123','이용중','$2a$10$MO0/.GDUVVlbhe27VIzzRuRel1NTHbJewH.ylOfdvYUEpLcle3usy','seungjoo8474@gmail.com','USER',NULL,0,'1D436522A2730F4EA7044D97385B1570','2024-03-28 10:12:33'),('asdf1234','이용중','asdf1234','asdf1234@aa.com','USER',NULL,0,NULL,NULL),('qwe123','이용중','$2a$10$xqJgoObBTOIWCgmhrYP1a.jtLgfiG5ODSmOl.4B5vtBv8WdUa5J62','lyg127@naver.com','USER',NULL,0,NULL,NULL),('qwer123','이용중','qwer123','qwer123@naver.com','USER',NULL,0,NULL,NULL),('qwer1234','이용중','qwer1234','sgj00700@naver.com','USER',NULL,0,NULL,NULL),('test01','이용중','$2a$10$ClTrhOVAdKB5FeuiS8dBgu.esHbh4qztQ4HXroIl0bvmZZSt2sCOi','test01@test.com','USER',NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
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
