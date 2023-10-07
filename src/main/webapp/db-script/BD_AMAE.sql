CREATE DATABASE  IF NOT EXISTS `bd_amae` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_amae`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_amae
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `avion`
--

DROP TABLE IF EXISTS `avion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avion` (
  `cod_avion` int NOT NULL,
  `matricula_avion` char(10) NOT NULL,
  `cantAsientos_avion` int NOT NULL,
  `tipo_avion` char(25) NOT NULL,
  `velocidad_avion` int NOT NULL,
  `desc_avion` varchar(100) DEFAULT NULL,
  `avioncol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_avion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avion`
--

LOCK TABLES `avion` WRITE;
/*!40000 ALTER TABLE `avion` DISABLE KEYS */;
INSERT INTO `avion` VALUES (110002,'MKLS-123',125,'Comercial',120,'Marca FlierBus','-'),(110003,'ARTS-458',200,'Comercial',150,'Marca FlyBirds','-'),(110004,'REQS-982',150,'Comercial',123,'Marca SpaceX','-');
/*!40000 ALTER TABLE `avion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cod_cliente` char(5) NOT NULL,
  `nombre_cliente` varchar(50) DEFAULT NULL,
  `apellido_cliente` varchar(50) DEFAULT NULL,
  `email_cliente` varchar(45) DEFAULT NULL,
  `nacionalidad_cliente` varchar(45) DEFAULT NULL,
  `pais_cliente` int DEFAULT NULL,
  `direccion_cliente` varchar(120) DEFAULT NULL,
  `codPostal_cliente` varchar(45) DEFAULT NULL,
  `telf_cliente` char(9) DEFAULT NULL,
  `tipDocumento_cliente` int DEFAULT NULL,
  `numDocumento_cliente` char(8) DEFAULT NULL,
  `sexo_cliente` int DEFAULT NULL,
  `tipoCliente` int DEFAULT NULL,
  `fechaAsociacion_cliente` date DEFAULT NULL,
  `estado` int DEFAULT '1',
  PRIMARY KEY (`cod_cliente`),
  KEY `fk_cliente_tipo_idx` (`tipoCliente`),
  KEY `fk_GeneroCliente_idx` (`sexo_cliente`),
  KEY `fk_pais_idx` (`pais_cliente`),
  KEY `fk_tipodocumento_idx` (`tipDocumento_cliente`),
  KEY `fk_dominio_idx` (`estado`),
  CONSTRAINT `fk_cliente_tipo` FOREIGN KEY (`tipoCliente`) REFERENCES `tipo_cliente` (`id_cliente`),
  CONSTRAINT `fk_dominio` FOREIGN KEY (`estado`) REFERENCES `estado` (`id_estado`),
  CONSTRAINT `fk_GeneroCliente` FOREIGN KEY (`sexo_cliente`) REFERENCES `generocliente` (`idGenero`),
  CONSTRAINT `fk_pais` FOREIGN KEY (`pais_cliente`) REFERENCES `paises` (`id`),
  CONSTRAINT `fk_tipodocumento` FOREIGN KEY (`tipDocumento_cliente`) REFERENCES `tipodocumento` (`id_TipoDoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('CLI01','ARIEL EDU','BULEJE GATILLON','bulejeariel@gmail.com','peruana',112,'Roma, av.rabi','599','987599764',1,'75152323',1,1,'2022-10-06',1),('CLI02','ABNER','DURAND','dura@gmail.com','mexicana',34,'Buenos Aires','784','995264785',2,'98765412',1,3,'2022-10-05',2),('CLI03','ZUELEN NAYELI','ALARCON OCHOA','jmll@gmail.com','peruana',66,'Quito','376','111111111',3,'010101',2,2,'2022-08-06',1),('CLI04','DIEGO ALONSO','CACERES BAUTISTA','trra@gmail.com','argentina',82,'Marseya','43','989898989',1,'75121111',1,3,'2022-10-05',2),('CLI05','JORGE ARMANDO','CASTILLO MIO','hiyj@gmail.com','chilena',173,'Lima.Ate','45','888888888',2,'12345678',1,1,'2022-08-06',1),('CLI06','Andrea Angela','Albornoz Galvan','andelia@gmail.com','Peruana',6,'Las Flores - 521','7895','987654321',2,'9999999',2,2,'2022-11-17',1),('CLI07','Enzo Jesús','AEA AEA','andelia@gmail.com','Peruana',17,'Las Flores - 521','1234','987654321',1,'78965412',1,2,'2022-11-27',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra_insumos`
--

DROP TABLE IF EXISTS `compra_insumos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra_insumos` (
  `cod_compra` int NOT NULL,
  `fecha_compra` date NOT NULL,
  `nombre_proveedor` varchar(45) NOT NULL,
  `nomb_producto` varchar(45) NOT NULL,
  `cant_producto` int NOT NULL,
  `des_producto` varchar(120) NOT NULL,
  `cod_vuelo` char(8) NOT NULL,
  PRIMARY KEY (`cod_compra`),
  KEY `fk_proveedor_idx` (`nombre_proveedor`),
  KEY `fk_codigo_vuelo_idx` (`cod_vuelo`),
  CONSTRAINT `fk_codigo_vuelo` FOREIGN KEY (`cod_vuelo`) REFERENCES `vuelo` (`cod_vuelo`),
  CONSTRAINT `fk_proveedor` FOREIGN KEY (`nombre_proveedor`) REFERENCES `proveedor` (`nombreEmpresa_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_insumos`
--

LOCK TABLES `compra_insumos` WRITE;
/*!40000 ALTER TABLE `compra_insumos` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra_insumos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destinos`
--

DROP TABLE IF EXISTS `destinos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destinos` (
  `cod_destino` int NOT NULL AUTO_INCREMENT,
  `aeropuerto_destino` varchar(80) NOT NULL,
  `ciudad_destino` varchar(60) NOT NULL,
  `pais_destino` varchar(60) NOT NULL,
  PRIMARY KEY (`cod_destino`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destinos`
--

LOCK TABLES `destinos` WRITE;
/*!40000 ALTER TABLE `destinos` DISABLE KEYS */;
INSERT INTO `destinos` VALUES (1001,'Malaga - Costa del Sol','Malaga','España'),(1002,'Congonhas','Sao Paulo','Brasil'),(1003,'San Francisco International Airport','San Francisco','Estados Unidos');
/*!40000 ALTER TABLE `destinos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `id_estado` int NOT NULL AUTO_INCREMENT,
  `desc_estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Activo'),(2,'Eliminado');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generocliente`
--

DROP TABLE IF EXISTS `generocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `generocliente` (
  `idGenero` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idGenero`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generocliente`
--

LOCK TABLES `generocliente` WRITE;
/*!40000 ALTER TABLE `generocliente` DISABLE KEYS */;
INSERT INTO `generocliente` VALUES (1,'Masculino'),(2,'Femenino');
/*!40000 ALTER TABLE `generocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `cod_hotel` int NOT NULL,
  `nombre_hotel` varchar(45) NOT NULL,
  `ruc_hotel` char(11) NOT NULL,
  `cantCuartos_hotel` int NOT NULL,
  `id_estado` int NOT NULL,
  PRIMARY KEY (`cod_hotel`),
  KEY `idx_hotel` (`nombre_hotel`),
  KEY `FK_IdEstado_Hotel_idx` (`id_estado`),
  CONSTRAINT `FK_IdEstado_Hotel` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (10001,'Sheraton','78996548987',100,1);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paises` (
  `id` int NOT NULL AUTO_INCREMENT,
  `iso` char(2) DEFAULT NULL,
  `nombre` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
INSERT INTO `paises` VALUES (1,'AF','Afganistán'),(2,'AX','Islas Gland'),(3,'AL','Albania'),(4,'DE','Alemania'),(5,'AD','Andorra'),(6,'AO','Angola'),(7,'AI','Anguilla'),(8,'AQ','Antártida'),(9,'AG','Antigua y Barbuda'),(10,'AN','Antillas Holandesas'),(11,'SA','Arabia Saudí'),(12,'DZ','Argelia'),(13,'AR','Argentina'),(14,'AM','Armenia'),(15,'AW','Aruba'),(16,'AU','Australia'),(17,'AT','Austria'),(18,'AZ','Azerbaiyán'),(19,'BS','Bahamas'),(20,'BH','Bahréin'),(21,'BD','Bangladesh'),(22,'BB','Barbados'),(23,'BY','Bielorrusia'),(24,'BE','Bélgica'),(25,'BZ','Belice'),(26,'BJ','Benin'),(27,'BM','Bermudas'),(28,'BT','Bhután'),(29,'BO','Bolivia'),(30,'BA','Bosnia y Herzegovina'),(31,'BW','Botsuana'),(32,'BV','Isla Bouvet'),(33,'BR','Brasil'),(34,'BN','Brunéi'),(35,'BG','Bulgaria'),(36,'BF','Burkina Faso'),(37,'BI','Burundi'),(38,'CV','Cabo Verde'),(39,'KY','Islas Caimán'),(40,'KH','Camboya'),(41,'CM','Camerún'),(42,'CA','Canadá'),(43,'CF','República Centroafricana'),(44,'TD','Chad'),(45,'CZ','República Checa'),(46,'CL','Chile'),(47,'CN','China'),(48,'CY','Chipre'),(49,'CX','Isla de Navidad'),(50,'VA','Ciudad del Vaticano'),(51,'CC','Islas Cocos'),(52,'CO','Colombia'),(53,'KM','Comoras'),(54,'CD','República Democrática del Congo'),(55,'CG','Congo'),(56,'CK','Islas Cook'),(57,'KP','Corea del Norte'),(58,'KR','Corea del Sur'),(59,'CI','Costa de Marfil'),(60,'CR','Costa Rica'),(61,'HR','Croacia'),(62,'CU','Cuba'),(63,'DK','Dinamarca'),(64,'DM','Dominica'),(65,'DO','República Dominicana'),(66,'EC','Ecuador'),(67,'EG','Egipto'),(68,'SV','El Salvador'),(69,'AE','Emiratos Árabes Unidos'),(70,'ER','Eritrea'),(71,'SK','Eslovaquia'),(72,'SI','Eslovenia'),(73,'ES','España'),(74,'UM','Islas ultramarinas de Estados Unidos'),(75,'US','Estados Unidos'),(76,'EE','Estonia'),(77,'ET','Etiopía'),(78,'FO','Islas Feroe'),(79,'PH','Filipinas'),(80,'FI','Finlandia'),(81,'FJ','Fiyi'),(82,'FR','Francia'),(83,'GA','Gabón'),(84,'GM','Gambia'),(85,'GE','Georgia'),(86,'GS','Islas Georgias del Sur y Sandwich del Sur'),(87,'GH','Ghana'),(88,'GI','Gibraltar'),(89,'GD','Granada'),(90,'GR','Grecia'),(91,'GL','Groenlandia'),(92,'GP','Guadalupe'),(93,'GU','Guam'),(94,'GT','Guatemala'),(95,'GF','Guayana Francesa'),(96,'GN','Guinea'),(97,'GQ','Guinea Ecuatorial'),(98,'GW','Guinea-Bissau'),(99,'GY','Guyana'),(100,'HT','Haití'),(101,'HM','Islas Heard y McDonald'),(102,'HN','Honduras'),(103,'HK','Hong Kong'),(104,'HU','Hungría'),(105,'IN','India'),(106,'ID','Indonesia'),(107,'IR','Irán'),(108,'IQ','Iraq'),(109,'IE','Irlanda'),(110,'IS','Islandia'),(111,'IL','Israel'),(112,'IT','Italia'),(113,'JM','Jamaica'),(114,'JP','Japón'),(115,'JO','Jordania'),(116,'KZ','Kazajstán'),(117,'KE','Kenia'),(118,'KG','Kirguistán'),(119,'KI','Kiribati'),(120,'KW','Kuwait'),(121,'LA','Laos'),(122,'LS','Lesotho'),(123,'LV','Letonia'),(124,'LB','Líbano'),(125,'LR','Liberia'),(126,'LY','Libia'),(127,'LI','Liechtenstein'),(128,'LT','Lituania'),(129,'LU','Luxemburgo'),(130,'MO','Macao'),(131,'MK','ARY Macedonia'),(132,'MG','Madagascar'),(133,'MY','Malasia'),(134,'MW','Malawi'),(135,'MV','Maldivas'),(136,'ML','Malí'),(137,'MT','Malta'),(138,'FK','Islas Malvinas'),(139,'MP','Islas Marianas del Norte'),(140,'MA','Marruecos'),(141,'MH','Islas Marshall'),(142,'MQ','Martinica'),(143,'MU','Mauricio'),(144,'MR','Mauritania'),(145,'YT','Mayotte'),(146,'MX','México'),(147,'FM','Micronesia'),(148,'MD','Moldavia'),(149,'MC','Mónaco'),(150,'MN','Mongolia'),(151,'MS','Montserrat'),(152,'MZ','Mozambique'),(153,'MM','Myanmar'),(154,'NA','Namibia'),(155,'NR','Nauru'),(156,'NP','Nepal'),(157,'NI','Nicaragua'),(158,'NE','Níger'),(159,'NG','Nigeria'),(160,'NU','Niue'),(161,'NF','Isla Norfolk'),(162,'NO','Noruega'),(163,'NC','Nueva Caledonia'),(164,'NZ','Nueva Zelanda'),(165,'OM','Omán'),(166,'NL','Países Bajos'),(167,'PK','Pakistán'),(168,'PW','Palau'),(169,'PS','Palestina'),(170,'PA','Panamá'),(171,'PG','Papúa Nueva Guinea'),(172,'PY','Paraguay'),(173,'PE','Perú'),(174,'PN','Islas Pitcairn'),(175,'PF','Polinesia Francesa'),(176,'PL','Polonia'),(177,'PT','Portugal'),(178,'PR','Puerto Rico'),(179,'QA','Qatar'),(180,'GB','Reino Unido'),(181,'RE','Reunión'),(182,'RW','Ruanda'),(183,'RO','Rumania'),(184,'RU','Rusia'),(185,'EH','Sahara Occidental'),(186,'SB','Islas Salomón'),(187,'WS','Samoa'),(188,'AS','Samoa Americana'),(189,'KN','San Cristóbal y Nevis'),(190,'SM','San Marino'),(191,'PM','San Pedro y Miquelón'),(192,'VC','San Vicente y las Granadinas'),(193,'SH','Santa Helena'),(194,'LC','Santa Lucía'),(195,'ST','Santo Tomé y Príncipe'),(196,'SN','Senegal'),(197,'CS','Serbia y Montenegro'),(198,'SC','Seychelles'),(199,'SL','Sierra Leona'),(200,'SG','Singapur'),(201,'SY','Siria'),(202,'SO','Somalia'),(203,'LK','Sri Lanka'),(204,'SZ','Suazilandia'),(205,'ZA','Sudáfrica'),(206,'SD','Sudán'),(207,'SE','Suecia'),(208,'CH','Suiza'),(209,'SR','Surinam'),(210,'SJ','Svalbard y Jan Mayen'),(211,'TH','Tailandia'),(212,'TW','Taiwán'),(213,'TZ','Tanzania'),(214,'TJ','Tayikistán'),(215,'IO','Territorio Británico del Océano Índico'),(216,'TF','Territorios Australes Franceses'),(217,'TL','Timor Oriental'),(218,'TG','Togo'),(219,'TK','Tokelau'),(220,'TO','Tonga'),(221,'TT','Trinidad y Tobago'),(222,'TN','Túnez'),(223,'TC','Islas Turcas y Caicos'),(224,'TM','Turkmenistán'),(225,'TR','Turquía'),(226,'TV','Tuvalu'),(227,'UA','Ucrania'),(228,'UG','Uganda'),(229,'UY','Uruguay'),(230,'UZ','Uzbekistán'),(231,'VU','Vanuatu'),(232,'VE','Venezuela'),(233,'VN','Vietnam'),(234,'VG','Islas Vírgenes Británicas'),(235,'VI','Islas Vírgenes de los Estados Unidos'),(236,'WF','Wallis y Futuna'),(237,'YE','Yemen'),(238,'DJ','Yibuti'),(239,'ZM','Zambia'),(240,'ZW','Zimbabue');
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promocion`
--

DROP TABLE IF EXISTS `promocion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promocion` (
  `cod_promocion` int NOT NULL,
  `clave_promocion` char(15) NOT NULL,
  `titulo_promocion` varchar(100) NOT NULL,
  `descripcion_promocion` varchar(150) NOT NULL,
  `fechaValida_promocion` date NOT NULL,
  `fechaCaducidad_promocion` date NOT NULL,
  `descuento_promocion` double DEFAULT NULL,
  `tipoCliente_promocion` int NOT NULL DEFAULT '1',
  `estado` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`cod_promocion`),
  KEY `idx_clave` (`clave_promocion`),
  KEY `fk_estado_idx` (`estado`),
  KEY `fk_tipoCliente_idx` (`tipoCliente_promocion`),
  CONSTRAINT `fk_estado` FOREIGN KEY (`estado`) REFERENCES `estado` (`id_estado`),
  CONSTRAINT `fk_tipoCliente` FOREIGN KEY (`tipoCliente_promocion`) REFERENCES `tipo_cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocion`
--

LOCK TABLES `promocion` WRITE;
/*!40000 ALTER TABLE `promocion` DISABLE KEYS */;
INSERT INTO `promocion` VALUES (2000001,'ABCD-7896','Cineplanet Promocion','Promocion para los trabajadores de Cineplanet','2020-12-12','2023-12-12',0.2,1,1),(2000002,'ABCD-1234','Cineplanet','Promocion para los trabajadroes de CIneplanet','2021-10-12','2021-10-28',0.5,1,1),(2000003,'ABCD-7896','AEA','asdas','2020-12-12','2020-12-12',0.1,1,1),(2000004,'ABCD-1596','as','as','2022-12-12','2023-12-12',0.5,1,2),(2000005,'DDDD-9999','Promoción de CiberFarma','Para todo los trabajadores de la empresa','2022-11-10','2022-12-30',0.6,2,1),(2000006,'AAAAA-9999','Promoción de CiberFarma','Para todo los trabajadores de la empresa','2022-11-10','2022-12-30',0.6,2,1),(9999999,'ZZZZ-9999','Ninguna','Ninguno','2003-12-12','2003-12-12',0.15,1,2);
/*!40000 ALTER TABLE `promocion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `cod_proveedor` char(5) NOT NULL,
  `razonSocial_proveedor` varchar(45) NOT NULL,
  `nombreEmpresa_proveedor` varchar(45) NOT NULL,
  `direccionEmpresa_proveedor` varchar(120) NOT NULL,
  `email_proveedor` varchar(45) NOT NULL,
  `pais_proveedor` int NOT NULL,
  `tipServicio_proveedor` varchar(45) NOT NULL,
  `fechaAsociacion_proveedor` date NOT NULL,
  `telf_proveedor` char(9) NOT NULL,
  `estado` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`cod_proveedor`),
  KEY `idx_nombre` (`nombreEmpresa_proveedor`) /*!80000 INVISIBLE */,
  KEY `idx_ruc` (`razonSocial_proveedor`),
  KEY `ffk_paises_idx` (`pais_proveedor`),
  KEY `fk_estados_idx` (`estado`),
  CONSTRAINT `ffk_paises` FOREIGN KEY (`pais_proveedor`) REFERENCES `paises` (`id`),
  CONSTRAINT `fk_estados` FOREIGN KEY (`estado`) REFERENCES `estado` (`id_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES ('PRO01','Venta de Zapatillas','Adidas Sac','Las Flores - 521','adidas@gmail.com',15,'Para todo los trabajadores de la empresa','2022-11-09','987654321',2);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva_hotel`
--

DROP TABLE IF EXISTS `reserva_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva_hotel` (
  `numSol_reserva` char(5) NOT NULL,
  `fecha_reserva` date NOT NULL,
  `cod_hotel` int NOT NULL,
  `cod_destino` int NOT NULL,
  `fechaIngreso_reserva` date NOT NULL,
  `fechaSalida_reserva` date NOT NULL,
  `cant_reserva` int NOT NULL,
  `tipo_reserva` varchar(45) NOT NULL,
  PRIMARY KEY (`numSol_reserva`),
  KEY `FK_CodDestino_Reser_idx` (`cod_destino`),
  KEY `FK_CodHotel_Reser_idx` (`cod_hotel`),
  CONSTRAINT `FK_CodDestino_Reser` FOREIGN KEY (`cod_destino`) REFERENCES `destinos` (`cod_destino`),
  CONSTRAINT `FK_CodHotel_Reser` FOREIGN KEY (`cod_hotel`) REFERENCES `hotel` (`cod_hotel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva_hotel`
--

LOCK TABLES `reserva_hotel` WRITE;
/*!40000 ALTER TABLE `reserva_hotel` DISABLE KEYS */;
INSERT INTO `reserva_hotel` VALUES ('SO001','2021-12-12',10001,1002,'2022-01-01','2022-01-12',5,'VIP'),('SO002','2022-11-20',10001,1002,'2022-11-09','2022-11-17',2,'Presidencial'),('SO003','2022-11-20',10001,1001,'2022-11-04','2022-11-08',2,'Presidencial'),('SO004','2022-11-20',10001,1001,'2022-11-10','2022-11-16',2,'Presidencial'),('SO005','2022-11-23',10001,1003,'2022-11-23','2022-11-30',3,'VIP'),('SO006','2022-11-24',10001,1003,'2022-11-30','2022-12-04',4,'Presidencial');
/*!40000 ALTER TABLE `reserva_hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjetas`
--

DROP TABLE IF EXISTS `tarjetas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarjetas` (
  `cod_tarjeta` int NOT NULL,
  `marca_tarjeta` varchar(45) NOT NULL,
  `num_tarjeta` varchar(45) NOT NULL,
  `tipo_tarjeta` varchar(45) NOT NULL,
  `cvv_tarjeta` char(3) NOT NULL,
  `tutor_tarjeta` varchar(200) NOT NULL,
  `dni_tarjeta` char(8) NOT NULL,
  PRIMARY KEY (`cod_tarjeta`),
  KEY `idx_codigo` (`cod_tarjeta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjetas`
--

LOCK TABLES `tarjetas` WRITE;
/*!40000 ALTER TABLE `tarjetas` DISABLE KEYS */;
INSERT INTO `tarjetas` VALUES (101120,'Visa','789654123','-','988','Eduardo Martinez','78965412'),(500001,'Visa','78965412','Debito','789','asdasd','12312312'),(500002,'Visa','12345678','Debito','123','asdasd','12312312'),(500003,'Visa','12345678','Debito','123','asdasd','12312312'),(500004,'Visa','12345678','Debito','123','asdasd','12312312'),(500005,'Visa','12345678','Debito','123','Estrada flores','12312312'),(500006,'Visa','12345678','Debito','123','Estrada flores','12312312'),(500007,'Visa','12345678','Debito','123','Estrada flores','12312312'),(500008,'Visa','12345678','Credito','345','Estrada flores','12312312'),(500009,'Visa','12345678','Debito','123','asdasd','12312312'),(500010,'Visa','78965412','Debito','123','Estrada flores','12312312'),(500011,'Visa','78965412','Debito','123','Estrada flores','12312312'),(500012,'Visa','78965412','Debito','456','Estrada flores','12312312'),(500013,'Visa','1232132','Debito','','Estrada flores','12312312'),(500014,'Mastercard','789654123','Debito','789','Estrada Flores','78654123'),(500015,'Visa','1321312312','Debito','899','Estada Quispe Torres','78965412'),(500016,'Visa','1321312312','Credito','899','Estada Quispe Torres','78965412'),(500017,'Visa','1321312312','Debito','899','Estada Quispe Torres','78965412'),(500018,'Visa','1321312312','Credito','899','Estada Quispe Torres','78965412'),(500019,'Visa','1321312312','Debito','899','Estada Quispe Torres','78965412'),(500020,'Visa','1321312312','Credito','899','Estada Quispe Torres','78965412'),(500021,'Visa','1321312312','Debito','899','Estada Quispe Torres','78965412'),(500022,'Visa','1321312312','Debito','899','Estada Quispe Torres','78965412'),(500023,'Visa','1321312312','Credito','566','Estada Quispe Torres','78965412');
/*!40000 ALTER TABLE `tarjetas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_cliente`
--

DROP TABLE IF EXISTS `tipo_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `des_cliente` char(15) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `idx_des_cliente` (`des_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_cliente`
--

LOCK TABLES `tipo_cliente` WRITE;
/*!40000 ALTER TABLE `tipo_cliente` DISABLE KEYS */;
INSERT INTO `tipo_cliente` VALUES (2,'COMERCIAL'),(3,'EJECUTIVO'),(1,'VIP');
/*!40000 ALTER TABLE `tipo_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_usuario` (
  `cod_tipo_usuario` int NOT NULL AUTO_INCREMENT,
  `desc_tipo_usuario` varchar(45) NOT NULL,
  PRIMARY KEY (`cod_tipo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'Administrador'),(2,'Gerente '),(3,'Vendedor');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodocumento`
--

DROP TABLE IF EXISTS `tipodocumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipodocumento` (
  `id_TipoDoc` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_TipoDoc`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodocumento`
--

LOCK TABLES `tipodocumento` WRITE;
/*!40000 ALTER TABLE `tipodocumento` DISABLE KEYS */;
INSERT INTO `tipodocumento` VALUES (1,'DNI'),(2,'Carnte de Extranjeria'),(3,'Pasaporte');
/*!40000 ALTER TABLE `tipodocumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `cod_usuario` char(5) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `contraseña_usuario` varchar(45) NOT NULL,
  `tipo_usuario` int NOT NULL,
  `estado` int DEFAULT '1',
  `exte_usuario` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cod_usuario`),
  KEY `fk_tipo_idx` (`tipo_usuario`),
  KEY `fk_estado_idx` (`estado`),
  CONSTRAINT `fk_tipo_estado` FOREIGN KEY (`estado`) REFERENCES `estado` (`id_estado`),
  CONSTRAINT `fk_tipo_usuario` FOREIGN KEY (`tipo_usuario`) REFERENCES `tipo_usuario` (`cod_tipo_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('U001','AM001@amae.com','1234',1,2,'png'),('U002','U002@amae.com','10002',2,1,'png'),('U003','USU02@amae.com','4568',1,1,'png'),('U004','U004@amae.com','10004',2,1,'png'),('U005','Aae@amae.com','9999',1,2,'png'),('U006','U006@amae.com','10006',3,2,'png'),('U007','U007@amae.com','1234',2,1,NULL),('U008','U008@amae.com','1234',3,1,'png'),('U009','U009@amae.com','1234',1,1,NULL),('U010','U010@amae.com','1234',3,1,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta_pasaje_detalle`
--

DROP TABLE IF EXISTS `venta_pasaje_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta_pasaje_detalle` (
  `cod_venta` int NOT NULL,
  `cod_persona` int NOT NULL,
  `cod_ida_vuelo` char(8) NOT NULL,
  `cod_vuelta_vuelo` char(8) DEFAULT NULL,
  PRIMARY KEY (`cod_venta`,`cod_persona`),
  KEY `FK_CodPersona_Venta_idx` (`cod_persona`),
  KEY `FK_CodIdaVuelo_Venta_idx` (`cod_ida_vuelo`),
  KEY `FK_CodVueltaVuelo_Venta_idx` (`cod_vuelta_vuelo`),
  CONSTRAINT `FK_CodIdaVuelo_Venta` FOREIGN KEY (`cod_ida_vuelo`) REFERENCES `vuelo` (`cod_vuelo`),
  CONSTRAINT `FK_CodPersona_Venta` FOREIGN KEY (`cod_persona`) REFERENCES `venta_pasaje_persona` (`cod_persona`),
  CONSTRAINT `FK_CodVueltaVuelo_Venta` FOREIGN KEY (`cod_vuelta_vuelo`) REFERENCES `vuelo` (`cod_vuelo`),
  CONSTRAINT `FK_NumVenta_Venta` FOREIGN KEY (`cod_venta`) REFERENCES `venta_pasajes` (`cod_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta_pasaje_detalle`
--

LOCK TABLES `venta_pasaje_detalle` WRITE;
/*!40000 ALTER TABLE `venta_pasaje_detalle` DISABLE KEYS */;
INSERT INTO `venta_pasaje_detalle` VALUES (500001,10001,'VU000001','VU000002'),(500001,10002,'VU000001','VU000002'),(500002,10003,'VU000001','VU000002'),(500003,10004,'VU000001','VU000002'),(500004,10005,'VU000001','VU000002'),(500005,10006,'VU000001','VU000002'),(500006,10007,'VU000001','VU000002'),(500007,10008,'VU000001','VU000002'),(500008,10009,'VU000001','VU000002'),(500009,10010,'VU000001','VU000002'),(500010,10011,'VU000001','VU000002'),(500011,10012,'VU000001','VU000002'),(500012,10013,'VU000001','VU000002'),(500013,10014,'VU000001','VU000002'),(500014,10015,'VU000001','VU000002'),(500015,10016,'VU000001','VU000002'),(500016,10017,'VU000001','VU000002'),(500017,10018,'VU000001','VU000002'),(500018,10019,'VU000002','VU000003'),(500018,10020,'VU000002','VU000003'),(500019,10021,'VU000001','VU000003'),(500020,10022,'VU000001','VU000002'),(500021,10023,'VU000001','VU000003'),(500021,10024,'VU000001','VU000003');
/*!40000 ALTER TABLE `venta_pasaje_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta_pasaje_persona`
--

DROP TABLE IF EXISTS `venta_pasaje_persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta_pasaje_persona` (
  `cod_persona` int NOT NULL,
  `nombre_persona` varchar(45) NOT NULL,
  `apellido_persona` varchar(45) NOT NULL,
  `dni_persona` char(8) NOT NULL,
  `sexo_persona` char(10) NOT NULL,
  `nacionalidad_persona` varchar(45) NOT NULL,
  `domicilio_persona` varchar(120) NOT NULL,
  `estado_persona` varchar(45) NOT NULL,
  `codigoPostal_persona` varchar(20) NOT NULL,
  `pais_persona` int NOT NULL DEFAULT '1',
  `carnetVacunacion_persona` varchar(45) NOT NULL DEFAULT 'NO',
  PRIMARY KEY (`cod_persona`),
  KEY `FK_Pais_Per_idx` (`pais_persona`),
  CONSTRAINT `FK_Pais_Per` FOREIGN KEY (`pais_persona`) REFERENCES `paises` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta_pasaje_persona`
--

LOCK TABLES `venta_pasaje_persona` WRITE;
/*!40000 ALTER TABLE `venta_pasaje_persona` DISABLE KEYS */;
INSERT INTO `venta_pasaje_persona` VALUES (10001,'Carlos Juan','Estrada Albañez','78965412','Masculino','Peruana','Las Flores - 1564','San Isisdro','12354',1,'Si'),(10002,'Juan Alvion','Quispe Huamani','45987612','Masculino','Colombiana','Las Orquideas - 1545','La Molina','78965',1,'Si'),(10003,'Carlos Juan','Estrada Alvarez','123213','Masculino','Colombiana','Las Flores - 789','San Isidro','12321',1,'NO'),(10004,'Carlos Galvan','Estrada Flores','78965412','Masculino','Colombiana','Las Flores - 789','San Isidro','12321',1,'NO'),(10005,'Carlos Juan','Estrada Flores','78456912','Masculino','Colombiana','Las Flores - 789','San Isidro','12321',1,'NO'),(10006,'Carlos Juan','Estrada Flores','78456912','Masculino','Colombiana','Las Flores - 789','San Isidro','12321',1,'NO'),(10007,'Carlos Juan','Estrada Alvarez','123213','Femenino','Colombiana','Las Flores - 789','San Isidro','12321',1,'NO'),(10008,'Carlos Juan','Estrada Alvarez','123213','Masculino','Colombiana','Las Flores - 789','San Isidro','12321',1,'NO'),(10009,'Carlos Juan','Estrada Alvarez','123213','Masculino','Peruana','Las Flores - 789','San Isidro','12321',1,'NO'),(10010,'Carlos Juan','Estrada Alvarez','123213','Masculino','Peruana','Las Flores - 789','San Isidro','12321',1,'NO'),(10011,'asdas','qweqw','78456912','Masculino','Peruana','CAsa','Peru','12321',1,'NO'),(10012,'Carlos Galvan','Estrada Alvarez','123213','Masculino','Colombiana','CAsa','San Isidro','12321',1,'NO'),(10013,'Diego Andres','Estrada Albiñez','63524178','Masculino','Colombiana','Las rocas - 789','San Juan de Miraflores','78655',1,'NO'),(10014,'Andrea Angela','Arquides Euribes','78965421','Masculino','Peruana','Las Flores - 521','San Isidro','15463',14,'NO'),(10015,'AEA AEA','AEA AEA','78965421','Masculino','Peruana','Las Flores - 521','San Isidro','15463',15,'NO'),(10016,'LLosa Gutierrez','AEA AEA','78965421','Masculino','Peruana','Las Flores - 521','San Isidro','15463',3,'NO'),(10017,'LLosa Gutierrez','Hilanez Gutierrz','78965421','Masculino','Peruana','Las Flores - 521','San Isidro','15463',1,'NO'),(10018,'Andrea Angela','Albornoz Galvan','78965421','Masculino','Peruana','Las Flores - 521','San Isidro','15463',5,'NO'),(10019,'Andrea Angela','Albornoz Galvan','78965421','....','Peruana','Las Flores - 521','San Isidro','15463',4,'NO'),(10020,'Andrea Angela','Arquides Euribes','78965421','....','Peruana','Las Flores - 521','San Isidro','15463',16,'NO'),(10021,'Andrea Angela','Albornoz Galvan','999999','....','Peruana','Las Flores - 521','San Isidro','15463',44,'NO'),(10022,'Andrea Angela','AEA AEA','78965421','Masculino','Peruana','Las Flores - 521','San Isidro','15463',15,'NO'),(10023,'Andrea Angela','Albornoz Galvan','78965421','....','Peruana','Las Flores - 521','San Isidro','15463',15,'NO'),(10024,'AEA AEA','Hilanez Gutierrz','78965421','....','Peruana','Las Flores - 521','San Isidro','9999',87,'NO');
/*!40000 ALTER TABLE `venta_pasaje_persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta_pasajes`
--

DROP TABLE IF EXISTS `venta_pasajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta_pasajes` (
  `cod_venta` int NOT NULL,
  `fecha_venta` date NOT NULL,
  `clave_promo` char(15) DEFAULT NULL,
  `precioTotal_venta` double NOT NULL,
  `cantida_venta` int NOT NULL,
  `tipo_venta` varchar(45) NOT NULL,
  `checkIn_venta` char(15) NOT NULL DEFAULT 'Desactivado',
  `cod_tarjeta` int NOT NULL DEFAULT '500001',
  PRIMARY KEY (`cod_venta`),
  KEY `fk_promocion_idx` (`clave_promo`),
  KEY `FK_CodBoleta_Venta_idx` (`cod_tarjeta`),
  CONSTRAINT `FK_CodBoleta_Venta` FOREIGN KEY (`cod_tarjeta`) REFERENCES `tarjetas` (`cod_tarjeta`),
  CONSTRAINT `fk_promocion` FOREIGN KEY (`clave_promo`) REFERENCES `promocion` (`clave_promocion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta_pasajes`
--

LOCK TABLES `venta_pasajes` WRITE;
/*!40000 ALTER TABLE `venta_pasajes` DISABLE KEYS */;
INSERT INTO `venta_pasajes` VALUES (500001,'2012-12-12',NULL,1564.25,3,'-','Activado',500001),(500002,'2022-10-31','ZZZZ-9999',107.8382,1,'null','Desactivado',500001),(500003,'2022-11-02','ZZZZ-9999',107.8382,1,'null','Desactivado',500001),(500004,'2022-11-02','ZZZZ-9999',107.8382,1,'null','Desactivado',500001),(500005,'2022-11-02','ZZZZ-9999',107.8382,1,'null','Desactivado',500001),(500006,'2022-11-02','ZZZZ-9999',107.8382,1,'null','Desactivado',500001),(500007,'2022-11-02','ZZZZ-9999',107.8382,1,'null','Desactivado',500001),(500008,'2022-11-02','ZZZZ-9999',107.8382,1,'null','Desactivado',500001),(500009,'2022-11-02','ZZZZ-9999',107.8382,1,'null','Desactivado',500001),(500010,'2022-11-02','ZZZZ-9999',107.8382,1,'null','Desactivado',500001),(500011,'2022-11-02','ZZZZ-9999',107.8382,1,'null','Desactivado',500001),(500012,'2022-11-03','ZZZZ-9999',107.8382,1,'null','Desactivado',500001),(500013,'2022-11-18','ZZZZ-9999',155.18179999999998,1,'null','Desactivado',500015),(500014,'2022-11-18','ZZZZ-9999',155.18179999999998,1,'null','Desactivado',500016),(500015,'2022-11-18','ZZZZ-9999',155.18179999999998,1,'null','Desactivado',500017),(500016,'2022-11-19','ABCD-1596',89.42679999999999,1,'null','Desactivado',500018),(500017,'2022-11-20','ZZZZ-9999',155.18179999999998,1,'null','Desactivado',500019),(500018,'2022-11-23','ZZZZ-9999',369.222,2,'null','Activado',500020),(500019,'2022-11-23','ABCD-1596',90.23599999999999,1,'null','Desactivado',500021),(500020,'2022-11-23','ABCD-1596',92.65,1,'null','Desactivado',500022),(500021,'2022-11-24','DDDD-9999',153.932,2,'null','Activado',500023);
/*!40000 ALTER TABLE `venta_pasajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vuelo`
--

DROP TABLE IF EXISTS `vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vuelo` (
  `cod_vuelo` char(8) NOT NULL,
  `cod_avion` int NOT NULL,
  `piloto_vuelo` varchar(50) NOT NULL,
  `copiloto_vuelo` varchar(50) NOT NULL,
  `estado_vuelo` int NOT NULL DEFAULT '1',
  `cod_destino_salida` int NOT NULL,
  `cod_destino_llegada` int NOT NULL,
  `precio_vuelo` double NOT NULL,
  `hora_vuelo` time NOT NULL,
  `fechaSalida_vuelo` date NOT NULL,
  `fechaLlegada_vuelo` date NOT NULL,
  PRIMARY KEY (`cod_vuelo`),
  KEY `idx_cod_vuelo` (`cod_vuelo`),
  KEY `fk_destino_ida_idx` (`cod_destino_salida`),
  KEY `fk_destino_llegada_idx` (`cod_destino_llegada`),
  KEY `fk_cod_avion_idx` (`cod_avion`),
  KEY `fk_estado_vuelo_idx` (`estado_vuelo`),
  CONSTRAINT `fk_cod_avion` FOREIGN KEY (`cod_avion`) REFERENCES `avion` (`cod_avion`),
  CONSTRAINT `fk_destino_ida` FOREIGN KEY (`cod_destino_salida`) REFERENCES `destinos` (`cod_destino`),
  CONSTRAINT `fk_destino_llegada` FOREIGN KEY (`cod_destino_llegada`) REFERENCES `destinos` (`cod_destino`),
  CONSTRAINT `fk_estado_vuelo` FOREIGN KEY (`estado_vuelo`) REFERENCES `estado` (`id_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vuelo`
--

LOCK TABLES `vuelo` WRITE;
/*!40000 ALTER TABLE `vuelo` DISABLE KEYS */;
INSERT INTO `vuelo` VALUES ('VU000001',110002,'Manuel Estrada Chavez','Eurebio Grasted Howard',2,1001,1003,56.25,'16:45:00','2022-10-12','2022-10-14'),('VU000002',110003,'Andrea Miranda','Homero Graz Tiurbe',1,1002,1003,80,'10:12:00','2022-10-15','2022-10-16'),('VU000003',110004,'Estuart Galvez Juarez','Eurebio Grasted Howard',1,1002,1001,76.45,'20:45:00','2022-10-13','2022-10-20');
/*!40000 ALTER TABLE `vuelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_amae'
--

--
-- Dumping routines for database 'bd_amae'
--
/*!50003 DROP PROCEDURE IF EXISTS `usp_buscarDestino` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_buscarDestino`(_des varchar(45))
BEGIN
SELECT * FROM destinos d where d.pais_destino like concat(_des, '%') ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_ClienteBuscar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_ClienteBuscar`(des varchar(45))
BEGIN
SELECT cod_cliente, nombre_cliente,email_cliente,tipDocumento_cliente,numDocumento_cliente,tipoCliente,fechaAsociacion_cliente
FROM cliente where nombre_cliente like concat(des, '%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_cod_persona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_cod_persona`()
BEGIN
SELECT MAX(cod_persona) FROM venta_pasaje_persona;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_cod_tarjeta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_cod_tarjeta`()
BEGIN
	SELECT MAX(cod_tarjeta) FROM tarjetas;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_cod_venta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_cod_venta`()
BEGIN
	SELECT MAX(cod_venta) FROM venta_pasajes;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_filtrarxFechaCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_filtrarxFechaCliente`(_fechaAsoc DATE)
BEGIN
SELECT cod_cliente, nombre_cliente,email_cliente,tipDocumento_cliente,numDocumento_cliente,tipoCliente,fechaAsociacion_cliente FROM cliente
 WHERE fechaAsociacion_cliente = _fechaAsoc ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_ListarCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_ListarCliente`()
SELECT cod_cliente, nombre_cliente,email_cliente,tipDocumento_cliente,numDocumento_cliente,tipoCliente,fechaAsociacion_cliente FROM cliente ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarDestino` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarDestino`()
SELECT * FROM destinos ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarVuelos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarVuelos`()
SELECT v.cod_vuelo,v.piloto_vuelo,v.copiloto_vuelo,v.precio_vuelo,v.hora_vuelo,v.fechaSalida_vuelo,v.fechaLlegada_vuelo FROM vuelo v ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_reportarVuelosXFecha` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_reportarVuelosXFecha`(fecha1 date, fecha2 date)
BEGIN
SELECT v.cod_vuelo,v.piloto_vuelo,v.copiloto_vuelo,v.precio_vuelo,v.hora_vuelo,v.fechaSalida_vuelo,v.fechaLlegada_vuelo FROM vuelo v
where fechaLlegada_vuelo BETWEEN  fecha1 AND fecha2 ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_validaAcceso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_validaAcceso`(usr char(45), pas char(5))
begin
select * from tb_usuarios where usuario = usr and clave = pas;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_validaAccesoMini` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_validaAccesoMini`(usr char(45), pas char(5))
begin
select * from tb_cuenta_usuarios where usuario = usr and clave = pas;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_verficarCheckIn` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_verficarCheckIn`(codVenta int, fecha date, dni char(8))
BEGIN
SELECT V.cod_venta, V.fecha_venta, V.checkIn_venta, t.dni_tarjeta  FROM venta_pasajes as V inner join Tarjetas as T
on V.cod_tarjeta = T.cod_tarjeta where V.cod_venta = codVenta AND 
V.fecha_venta = fecha AND T.dni_tarjeta = dni;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `verficarCheckIn` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `verficarCheckIn`(codVenta int, fecha date, dni char(8))
BEGIN
SELECT V.cod_venta, V.fecha_venta, V.checkIn_venta, t.dni_tarjeta  FROM venta_pasajes as V inner join Tarjetas as T
on V.cod_tarjeta = T.cod_tarjeta where V.cod_venta = codVenta AND 
V.fecha_venta = fecha AND T.dni_tarjeta = dni;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-08 21:40:16
