-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: haibazo
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Shoes'),(2,'Shi');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (1,'Red'),(2,'Yellow'),(3,'Black'),(4,'Blu');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `average_stars` double NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `discount` double NOT NULL,
  `image` longtext,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `sale_end_date` datetime(6) DEFAULT NULL,
  `view` int NOT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,4,'Natalia Beatiful Gitl',23,'https://www.google.com/imgres?q=danh&imgurl=https%3A%2F%2Fcdn.tgdd.vn%2F%2FNews%2F1451011%2F%2Fco-nen-danh-con-khi-khong-nghe-loi-02-845x600-845x600.jpg&imgrefurl=https%3A%2F%2Fwww.avakids.com%2Fme-va-be%2Flieu-danh-don-co-phai-la-cach-phat-tre-hieu-qua-1451011&docid=mG6GDos_szInbM&tbnid=IHghiT_BnpShpM&vet=12ahUKEwjL4bTtquaIAxXvsFYBHRVvGscQM3oECDsQAA..i&w=845&h=600&hcb=2&ved=2ahUKEwjL4bTtquaIAxXvsFYBHRVvGscQM3oECDsQAA','NatliaTa',29,'2024-09-28 22:40:26.000000',234,2),(2,5,'Man is clothing',12,'https://www.google.com/imgres?q=danh&imgurl=https%3A%2F%2Fcdn.tgdd.vn%2F%2FNews%2F1451011%2F%2Fco-nen-danh-con-khi-khong-nghe-loi-02-845x600-845x600.jpg&imgrefurl=https%3A%2F%2Fwww.avakids.com%2Fme-va-be%2Flieu-danh-don-co-phai-la-cach-phat-tre-hieu-qua-1451011&docid=mG6GDos_szInbM&tbnid=IHghiT_BnpShpM&vet=12ahUKEwjL4bTtquaIAxXvsFYBHRVvGscQM3oECDsQAA..i&w=845&h=600&hcb=2&ved=2ahUKEwjL4bTtquaIAxXvsFYBHRVvGscQM3oECDsQAA','His',30,'2024-09-29 02:07:57.000000',34,2),(3,3,'Product03',12,'https://www.google.com/imgres?q=anh&imgurl=https%3A%2F%2Fik.imagekit.io%2Ftvlk%2Fblog%2F2021%2F09%2Fdu-lich-anh-8-1024x576.jpg%3Ftr%3Ddpr-2%2Cw-675&imgrefurl=https%3A%2F%2Fwww.traveloka.com%2Fvi-vn%2Fexplore%2Fdestination%2Fdu-lich-anh-quoc%2F97047&docid=FP4bzlstQxsWBM&tbnid=r1QLeemu7J6gHM&vet=12ahUKEwj5z_3k6OeIAxWCslYBHQc0M10QM3oECGUQAA..i&w=1350&h=759&hcb=2&ved=2ahUKEwj5z_3k6OeIAxWCslYBHQc0M10QM3oECGUQAA','Product',12,'2024-09-29 16:17:11.000000',12,2),(5,5,'Product04',12,'https://www.google.com/imgres?q=anh&imgurl=https%3A%2F%2Fduhocvietglobal.com%2Fwp-content%2Fuploads%2F2018%2F12%2Fdat-nuoc-va-con-nguoi-anh-quoc.jpg&imgrefurl=https%3A%2F%2Fduhocvietglobal.com%2Fcon-nguoi-va-dat-nuoc-anh-quoc%2F&docid=lOB9u46QjUjrgM&tbnid=BZOT06IWvBKJRM&vet=12ahUKEwj5z_3k6OeIAxWCslYBHQc0M10QM3oECFMQAA..i&w=810&h=461&hcb=2&ved=2ahUKEwj5z_3k6OeIAxWCslYBHQc0M10QM3oECFMQAA','Product04',11,'2024-09-29 16:17:51.000000',13,1),(7,3,'Product05',11,'https://www.google.com/imgres?q=anh&imgurl=https%3A%2F%2Fduhocvietglobal.com%2Fwp-content%2Fuploads%2F2018%2F12%2Fdat-nuoc-va-con-nguoi-anh-quoc.jpg&imgrefurl=https%3A%2F%2Fduhocvietglobal.com%2Fcon-nguoi-va-dat-nuoc-anh-quoc%2F&docid=lOB9u46QjUjrgM&tbnid=BZOT06IWvBKJRM&vet=12ahUKEwj5z_3k6OeIAxWCslYBHQc0M10QM3oECFMQAA..i&w=810&h=461&hcb=2&ved=2ahUKEwj5z_3k6OeIAxWCslYBHQc0M10QM3oECFMQAA','Product05',11,'2024-09-29 16:18:35.000000',11,1),(8,1,'Clothing',10,'https://www.google.com/imgres?q=anh&imgurl=https%3A%2F%2Fvisanuocngoai.vn%2Fwp-content%2Fuploads%2F2021%2F08%2Fthu-do-nuoc-anh-la-gi-1.jpg&imgrefurl=https%3A%2F%2Fduhocphc.com%2Fdu-hoc-anh-quoc%2Ftin-tuc%2Fdau-la-nhung-thanh-pho-o-anh-thu-hut-du-hoc-sinh-viet-&docid=dlGv2d_fiMKPlM&tbnid=H36RomodPLjZeM&vet=12ahUKEwj5z_3k6OeIAxWCslYBHQc0M10QM3oECFQQAA..i&w=600&h=400&hcb=2&ved=2ahUKEwj5z_3k6OeIAxWCslYBHQc0M10QM3oECFQQAA','One',12,'2024-09-29 16:27:17.000000',25,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_color_size`
--

DROP TABLE IF EXISTS `product_color_size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_color_size` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `color_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `size_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_product_color_size_color` (`color_id`),
  KEY `FK_product_color_size_product` (`product_id`),
  KEY `FK_product_color_size_size` (`size_id`),
  CONSTRAINT `FK_product_color_size_color` FOREIGN KEY (`color_id`) REFERENCES `color` (`id`),
  CONSTRAINT `FK_product_color_size_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_product_color_size_size` FOREIGN KEY (`size_id`) REFERENCES `size` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_color_size`
--

LOCK TABLES `product_color_size` WRITE;
/*!40000 ALTER TABLE `product_color_size` DISABLE KEYS */;
INSERT INTO `product_color_size` VALUES (1,2,3,2,2);
/*!40000 ALTER TABLE `product_color_size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_image`
--

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` longtext,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6oo0cvcdtb6qmwsga468uuukk` (`product_id`),
  CONSTRAINT `FK6oo0cvcdtb6qmwsga468uuukk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_image`
--

LOCK TABLES `product_image` WRITE;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
INSERT INTO `product_image` VALUES (1,'https://www.google.com/imgres?q=hinhanh&imgurl=https%3A%2F%2Fhoanghamobile.com%2Ftin-tuc%2Fwp-content%2Fuploads%2F2024%2F03%2Fanh-hoat-hinh-1.jpg&imgrefurl=https%3A%2F%2Fhoanghamobile.com%2Ftin-tuc%2Fanh-hoat-hinh%2F&docid=ztw5jEB2mXovXM&tbnid=gSE5YeigZ8s2KM&vet=12ahUKEwjUpZ6f0OeIAxX3slYBHbmiPKMQM3oECBgQAA..i&w=450&h=800&hcb=2&ved=2ahUKEwjUpZ6f0OeIAxX3slYBHbmiPKMQM3oECBgQAA',1),(2,'https://www.google.com/imgres?q=hinhanh&imgurl=https%3A%2F%2Fimg.pikbest.com%2Forigin%2F09%2F19%2F03%2F61zpIkbEsTGjk.jpg!w700wp&imgrefurl=https%3A%2F%2Fvn.pikbest.com%2Fphoto%2Ffree-best-morning-nature-pictures-%2526-images_9190361.html&docid=gPhgxNNELEweNM&tbnid=ocx1BVOFDgaISM&vet=12ahUKEwjUpZ6f0OeIAxX3slYBHbmiPKMQM3oECBwQAA..i&w=700&h=525&hcb=2&ved=2ahUKEwjUpZ6f0OeIAxX3slYBHbmiPKMQM3oECBwQAA',1);
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_style`
--

DROP TABLE IF EXISTS `product_style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_style` (
  `product_id` int NOT NULL,
  `style_id` int NOT NULL,
  PRIMARY KEY (`product_id`,`style_id`),
  KEY `FKnpqv53214mu4wuukjhfjw2rbu` (`style_id`),
  CONSTRAINT `FKke5elqdgxt3ou3aevi7fmj1un` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKnpqv53214mu4wuukjhfjw2rbu` FOREIGN KEY (`style_id`) REFERENCES `style` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_style`
--

LOCK TABLES `product_style` WRITE;
/*!40000 ALTER TABLE `product_style` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_style` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `size` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES (1,'S'),(2,'M'),(3,'XL'),(4,'XML');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `style`
--

DROP TABLE IF EXISTS `style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `style` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `style`
--

LOCK TABLES `style` WRITE;
/*!40000 ALTER TABLE `style` DISABLE KEYS */;
INSERT INTO `style` VALUES (1,'Fashion'),(2,'Modern'),(3,'Baby');
/*!40000 ALTER TABLE `style` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-29 19:52:29
