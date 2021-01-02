-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: library_db
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'24 janvier 1911','René','Barjavel','24 novembre 1985'),(2,'26 février 1802','Victor','Hugo','22 mai 1885'),(3,'5 août 1850','Guy','Maupassant','6 juillet 1893'),(4,'3 janvier 1892','John Ronald Reuel','Tolkien','2 septembre 1973');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'2 êtres humains retrouvés surgelés en antarctique','La nuit des temps',1,6,'/img/books/LaNuitDesTemps.jpg'),(2,'des gens disparaissent mystèrieusement','Le grand secret',1,1,'/img/books/LeGrandSecret.jpg'),(3,'Une cathédrale et un diforme','Notre Dame de Paris',2,1,'/img/books/NDdeParis.jpg'),(4,'Les ténardiers, famille d\'accueil','Les misérables',2,1,'/img/books/LesMiserables.jpg'),(5,'la fin du monde est proche','Une rose au paradis',1,1,'/img/books/UneRoseAuParadis.jpg'),(6,'un méchant et des hobbits','Le seigneur des anneaux',4,5,'/img/books/LordOfRings.jpg');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `borrowing`
--

LOCK TABLES `borrowing` WRITE;
/*!40000 ALTER TABLE `borrowing` DISABLE KEYS */;
INSERT INTO `borrowing` VALUES (1,'2020-11-13',0,'2021-01-05',5,12,0,NULL,NULL),(2,'2020-11-13',0,'2020-10-30',3,12,0,NULL,1),(3,'2020-11-13',0,'2020-11-15',2,12,0,NULL,NULL),(10,'2020-12-14',0,'2021-01-14',10,12,1,NULL,11);
/*!40000 ALTER TABLE `borrowing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Roman divers','Roman'),(2,'romans reservés à un public averti','Romance Adulte'),(3,'roman policier','Polar'),(4,'roman d\'épouvante, frisson','Thriller'),(5,'roman fantastiques','Fantastique'),(6,'romans de Science fiction','SF'),(7,'agréables à lire','Feel Good'),(8,'Littérature pour enfant','Enfants'),(9,'Littératures Ados','Ados');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `copy`
--

LOCK TABLES `copy` WRITE;
/*!40000 ALTER TABLE `copy` DISABLE KEYS */;
INSERT INTO `copy` VALUES (1,1,1,1),(2,0,1,1),(3,1,2,1),(4,1,4,1),(5,1,5,1),(6,1,6,1),(7,1,3,2),(8,1,3,3),(9,1,1,2),(10,1,1,2),(11,1,2,3),(12,1,2,3),(13,1,3,2),(14,1,3,3),(15,1,4,2),(16,1,4,3),(17,1,5,3),(18,1,5,2),(19,1,6,3),(20,1,6,2);
/*!40000 ALTER TABLE `copy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `library`
--

LOCK TABLES `library` WRITE;
/*!40000 ALTER TABLE `library` DISABLE KEYS */;
INSERT INTO `library` VALUES (1,'2 avenue des champs Elyées','library@lib.fr','les champs','0000000000'),(2,'13 impasse du sans-retour','sans-retour@lib.fr','L\'impasse','0000000000'),(3,'boulevard des invalides','Inva@lib.fr','Les Invalides','0000000000');
/*!40000 ALTER TABLE `library` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'EMPLOYEE'),(3,'USER'),(4,'GUEST');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'3 janvier 1985','peaschaming@gmail.com','Pierre-alain','Schaming','$2a$10$ACULTKVPOyzsPnXLXEjMReZhJg6dy6HH9gDlOrv0t18gat1zUdA0y','peasch'),(2,'14 juin 1982','eminy@a.fr','Emilie','Schaming','$2a$10$ACULTKVPOyzsPnXLXEjMReZhJg6dy6HH9gDlOrv0t18gat1zUdA0y','eminy'),(3,'17 aout 2008','océ@océ','océane','Salvadori','$2a$10$ACULTKVPOyzsPnXLXEjMReZhJg6dy6HH9gDlOrv0t18gat1zUdA0y','Océ'),(4,'je sais pas','mathieu-martinez@live.com','Mathieu','Martinez','$2a$10$ACULTKVPOyzsPnXLXEjMReZhJg6dy6HH9gDlOrv0t18gat1zUdA0y','MatProgBg'),(5,'17 aout 2008','tom@tom.t','Tomtomé','Nana','$2a$10$ACULTKVPOyzsPnXLXEjMReZhJg6dy6HH9gDlOrv0t18gat1zUdA0y','tom'),(6,'3 janvier 1985',NULL,'jean','pierre','$2a$10$ACULTKVPOyzsPnXLXEjMReZhJg6dy6HH9gDlOrv0t18gat1zUdA0y','jp'),(7,'00/00/0000',NULL,'a','a','$2a$10$ACULTKVPOyzsPnXLXEjMReZhJg6dy6HH9gDlOrv0t18gat1zUdA0y','a'),(8,'00/00/0000','b@b.b','b','b','$2a$10$ACULTKVPOyzsPnXLXEjMReZhJg6dy6HH9gDlOrv0t18gat1zUdA0y','b'),(9,'00/0/0000','jack@jack.j','jack','jack','$2a$10$ACULTKVPOyzsPnXLXEjMReZhJg6dy6HH9gDlOrv0t18gat1zUdA0y','jack'),(10,'00/00/0000','joe@joe.fr','joe','joe','$2a$10$ACULTKVPOyzsPnXLXEjMReZhJg6dy6HH9gDlOrv0t18gat1zUdA0y','joe'),(11,'00/00/0000','d@d.d','d','d','$2a$10$ACULTKVPOyzsPnXLXEjMReZhJg6dy6HH9gDlOrv0t18gat1zUdA0y','d'),(12,'03/01/1985','peaschaming@gmail.com','pa','pa','$2a$10$ACULTKVPOyzsPnXLXEjMReZhJg6dy6HH9gDlOrv0t18gat1zUdA0y','pas'),(13,'03/01/1985','w@w.w','w','w','$2a$10$mpsEd0EBzYwiTwaaQz1IbO9IbmfJQ0B63yWyO6WmuO8/U4svO/uyK','w'),(14,'03/01/1985','batch@batch.fr','batch','batch','$2a$10$eNCohjFLTlc1hUQcaYz2k.MglWLO31SHtvDJoPnwT5HPdUEucMUSa','batch'),(15,'03/01/1985','t@t.t','t','t','$2a$10$pcBdEu8EUA.VZ2mY8cpETe554hsgS5Zzg7nfpPxPhaUOkAi4AT9gO','t'),(16,'01/01/0101','picq.stephane@gmail.com','Stéphane','Picq','$2a$10$GBRMDkqwzZI5qImdJZYSb.OlMm3q332HgdHwAPO849OG7QfY/Z7tW','bob');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_has_role`
--

LOCK TABLES `user_has_role` WRITE;
/*!40000 ALTER TABLE `user_has_role` DISABLE KEYS */;
INSERT INTO `user_has_role` VALUES (1,1),(2,1),(3,2),(3,3),(3,4),(3,5),(3,6),(3,7),(3,8),(3,9),(2,10),(2,11),(1,12),(3,13),(1,14),(3,15),(3,16);
/*!40000 ALTER TABLE `user_has_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-02 16:01:34
