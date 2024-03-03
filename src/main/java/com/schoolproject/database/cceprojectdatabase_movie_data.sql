-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: cceprojectdatabase
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `movie_data`
--

DROP TABLE IF EXISTS `movie_data`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_data`
(
    `Movie_ID`              varchar(10) NOT NULL,
    `Title`                 varchar(100) DEFAULT NULL,
    `Cast`                  varchar(100) DEFAULT NULL,
    `Genre`                 varchar(100) DEFAULT NULL,
    `Runtime`               varchar(10)  DEFAULT NULL,
    `Age_Restriction`       varchar(5)   DEFAULT NULL,
    `Description`           varchar(500) DEFAULT NULL,
    `Image_Card`            varchar(100) DEFAULT NULL,
    `Popularity_Vote_Count` int         NOT NULL,
    PRIMARY KEY (`Movie_ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_data`
--

LOCK TABLES `movie_data` WRITE;
/*!40000 ALTER TABLE `movie_data`
    DISABLE KEYS */;
INSERT INTO `movie_data`
VALUES ('000001', 'Alice in Wonderland (2010)', 'Kathryn Beaumont, Ed Wynn, Richard Haydn', 'Fantasy', '1h 15m', 'G',
        'Alice stumbles into the world of Wonderland. Will she get home? Not if the Queen of Hearts has her way.',
        'Alice in Wonderland (2010)', 0);
/*!40000 ALTER TABLE `movie_data`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2024-03-02 11:25:41
