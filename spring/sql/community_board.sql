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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `bo_num` int NOT NULL AUTO_INCREMENT,
  `bo_co_num` int NOT NULL,
  `bo_me_id` varchar(13) NOT NULL,
  `bo_title` varchar(50) NOT NULL,
  `bo_content` text NOT NULL,
  `bo_view` int NOT NULL DEFAULT '0',
  `bo_report_count` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`bo_num`),
  KEY `FK_community_TO_board_1` (`bo_co_num`),
  KEY `FK_member_TO_board_1` (`bo_me_id`),
  CONSTRAINT `FK_community_TO_board_1` FOREIGN KEY (`bo_co_num`) REFERENCES `community` (`co_num`),
  CONSTRAINT `FK_member_TO_board_1` FOREIGN KEY (`bo_me_id`) REFERENCES `member` (`me_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,2,'abc123','테스트','테스트 입니다',1,0),(2,2,'abc123','테스트','테스트 입니다.',1,0),(3,1,'admin','공지사항','공지사항입니다.',0,0),(4,1,'abc123','abc','abc',0,0),(5,1,'abc123','abb','abb',2,0),(7,3,'asd123','고치기','수정하기 성공?',3,0),(8,1,'asd123','cache except','cache',7,0),(9,2,'asd123','다시 수정해보기','수정하기 성공인가?',50,0),(12,1,'admin','공지사항입니다','안녕하세요\r\n',32,0),(13,1,'admin','테스트할겁니다','네',28,0),(18,1,'asd123','파일 업로드 테스트테스트','파일 업로드',9,0),(19,1,'asd123','업로드 테스트 2','업로드 테스트',5,0),(21,1,'asd123','이제는 한개만','이제는 한개만 업로드',29,0),(23,1,'asd123','3','3',72,0),(29,1,'asd123','summernote test','<p>테스트<span style=\"background-color: rgb(255, 255, 0);\"> 테스트</span><span style=\"background-color: rgb(156, 0, 255);\"> 테스트</span><span style=\"background-color: rgb(0, 0, 255);\"> 테스트</span></p>',118,0),(30,4,'qwe123','공부합시다','싫은데요',0,0),(31,3,'qwe123','눈이 아픈가요','<p><font color=\"#8c7bc6\"><span style=\"background-color: rgb(74, 123, 140);\">눈아프게 만들기ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ</span></font></p>',0,0),(32,3,'qwe123','공부 해야하는가?','<p>흠... 글쎄요</p>',3,0),(33,2,'qwe123','드가자','<p>두개재</p>',167,0);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
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
