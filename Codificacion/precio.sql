-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.31-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para precio
DROP DATABASE IF EXISTS `precio`;
CREATE DATABASE IF NOT EXISTS `precio` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `precio`;


-- Volcando estructura para tabla precio.dimensiones
DROP TABLE IF EXISTS `dimensiones`;
CREATE TABLE IF NOT EXISTS `dimensiones` (
  `ID_DIMENSION` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` tinytext NOT NULL,
  PRIMARY KEY (`ID_DIMENSION`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla precio.dimensiones: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `dimensiones` DISABLE KEYS */;
INSERT INTO `dimensiones` (`ID_DIMENSION`, `NOMBRE`) VALUES
	(1, 'Peso'),
	(2, 'Volumen'),
	(3, 'Unidades');
/*!40000 ALTER TABLE `dimensiones` ENABLE KEYS */;


-- Volcando estructura para tabla precio.estados_transacciones
DROP TABLE IF EXISTS `estados_transacciones`;
CREATE TABLE IF NOT EXISTS `estados_transacciones` (
  `ID_ESTADO_TRANSACCION` tinyint(2) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` tinytext NOT NULL,
  PRIMARY KEY (`ID_ESTADO_TRANSACCION`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla precio.estados_transacciones: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `estados_transacciones` DISABLE KEYS */;
INSERT INTO `estados_transacciones` (`ID_ESTADO_TRANSACCION`, `NOMBRE`) VALUES
	(1, 'Nuevo'),
	(2, 'Cancelada');
/*!40000 ALTER TABLE `estados_transacciones` ENABLE KEYS */;


-- Volcando estructura para tabla precio.marcas
DROP TABLE IF EXISTS `marcas`;
CREATE TABLE IF NOT EXISTS `marcas` (
  `ID_MARCA` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` tinytext NOT NULL,
  PRIMARY KEY (`ID_MARCA`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla precio.marcas: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` (`ID_MARCA`, `NOMBRE`) VALUES
	(1, 'Still'),
	(2, 'Bosh'),
	(3, 'Arcor');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;


-- Volcando estructura para tabla precio.personas
DROP TABLE IF EXISTS `personas`;
CREATE TABLE IF NOT EXISTS `personas` (
  `ID_PERSONA` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_TIPO_PERSONA` tinyint(2) unsigned NOT NULL,
  `APELLIDO` tinytext NOT NULL,
  `APELLIDO2` tinytext,
  `NOMBRES` tinytext NOT NULL,
  `DOCUMENTO` tinytext,
  `CORREO_ELECTRONICO` tinytext,
  PRIMARY KEY (`ID_PERSONA`),
  KEY `personas_fk_tipos_personas` (`ID_TIPO_PERSONA`),
  CONSTRAINT `personas_fk_tipos_personas` FOREIGN KEY (`ID_TIPO_PERSONA`) REFERENCES `tipos_personas` (`ID_TIPO_PERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla precio.personas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;


-- Volcando estructura para tabla precio.precios
DROP TABLE IF EXISTS `precios`;
CREATE TABLE IF NOT EXISTS `precios` (
  `ID_PRECIO` bigint(30) unsigned NOT NULL AUTO_INCREMENT,
  `ID_PRODUCTO` bigint(10) unsigned NOT NULL,
  `ID_MARCA` int(10) unsigned NOT NULL,
  `ID_UNIDAD` int(10) unsigned NOT NULL,
  `PRECIO` decimal(10,2) unsigned NOT NULL,
  `FECHA_INICIO` datetime NOT NULL,
  PRIMARY KEY (`ID_PRECIO`),
  KEY `precios_fk_unidades` (`ID_UNIDAD`),
  KEY `precios_fk_productos` (`ID_PRODUCTO`),
  KEY `precios_fk_marcas` (`ID_MARCA`),
  CONSTRAINT `precios_fk_marcas` FOREIGN KEY (`ID_MARCA`) REFERENCES `marcas` (`ID_MARCA`),
  CONSTRAINT `precios_fk_productos` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `productos` (`ID_PRODUCTO`),
  CONSTRAINT `precios_fk_unidades` FOREIGN KEY (`ID_UNIDAD`) REFERENCES `unidades` (`ID_UNIDAD`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla precio.precios: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `precios` DISABLE KEYS */;
INSERT INTO `precios` (`ID_PRECIO`, `ID_PRODUCTO`, `ID_MARCA`, `ID_UNIDAD`, `PRECIO`, `FECHA_INICIO`) VALUES
	(1, 5, 3, 1, 34.00, '2015-09-09 00:11:52');
/*!40000 ALTER TABLE `precios` ENABLE KEYS */;


-- Volcando estructura para tabla precio.productos
DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `ID_PRODUCTO` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` tinytext NOT NULL,
  PRIMARY KEY (`ID_PRODUCTO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla precio.productos: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` (`ID_PRODUCTO`, `NOMBRE`) VALUES
	(1, 'Alambre'),
	(2, 'Azucar'),
	(3, 'Hierro'),
	(4, 'Cablehh'),
	(5, 'Cemento'),
	(6, 'Clavos');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;


-- Volcando estructura para tabla precio.recursos
DROP TABLE IF EXISTS `recursos`;
CREATE TABLE IF NOT EXISTS `recursos` (
  `ID_RECURSO` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` tinytext NOT NULL,
  `RECURSO` tinytext NOT NULL,
  `ID_TIPO_RECURSO` int(10) unsigned NOT NULL,
  KEY `ID_RECURSO` (`ID_RECURSO`),
  KEY `recursos_fk_tipos_recursos` (`ID_TIPO_RECURSO`),
  CONSTRAINT `recursos_fk_tipos_recursos` FOREIGN KEY (`ID_TIPO_RECURSO`) REFERENCES `tipos_recursos` (`ID_TIPO_RECURSO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla precio.recursos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `recursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `recursos` ENABLE KEYS */;


-- Volcando estructura para tabla precio.tipos_personas
DROP TABLE IF EXISTS `tipos_personas`;
CREATE TABLE IF NOT EXISTS `tipos_personas` (
  `ID_TIPO_PERSONA` tinyint(2) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` tinytext NOT NULL,
  PRIMARY KEY (`ID_TIPO_PERSONA`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla precio.tipos_personas: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `tipos_personas` DISABLE KEYS */;
INSERT INTO `tipos_personas` (`ID_TIPO_PERSONA`, `NOMBRE`) VALUES
	(1, 'Fisica'),
	(2, 'Juridica');
/*!40000 ALTER TABLE `tipos_personas` ENABLE KEYS */;


-- Volcando estructura para tabla precio.tipos_productos
DROP TABLE IF EXISTS `tipos_productos`;
CREATE TABLE IF NOT EXISTS `tipos_productos` (
  `ID_TIPO_PRODUCTO` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` tinytext NOT NULL,
  PRIMARY KEY (`ID_TIPO_PRODUCTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla precio.tipos_productos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tipos_productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipos_productos` ENABLE KEYS */;


-- Volcando estructura para tabla precio.tipos_recursos
DROP TABLE IF EXISTS `tipos_recursos`;
CREATE TABLE IF NOT EXISTS `tipos_recursos` (
  `ID_TIPO_RECURSO` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` tinytext NOT NULL,
  KEY `ID_TIPO_RECURSO` (`ID_TIPO_RECURSO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla precio.tipos_recursos: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `tipos_recursos` DISABLE KEYS */;
INSERT INTO `tipos_recursos` (`ID_TIPO_RECURSO`, `NOMBRE`) VALUES
	(1, 'PAGINA'),
	(2, 'OPERACION');
/*!40000 ALTER TABLE `tipos_recursos` ENABLE KEYS */;


-- Volcando estructura para tabla precio.tipos_transacciones
DROP TABLE IF EXISTS `tipos_transacciones`;
CREATE TABLE IF NOT EXISTS `tipos_transacciones` (
  `ID_TIPO_TRANSACCION` tinyint(2) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` tinytext,
  PRIMARY KEY (`ID_TIPO_TRANSACCION`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla precio.tipos_transacciones: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `tipos_transacciones` DISABLE KEYS */;
INSERT INTO `tipos_transacciones` (`ID_TIPO_TRANSACCION`, `NOMBRE`) VALUES
	(1, 'Compra'),
	(2, 'Venta'),
	(3, 'Presupuesto'),
	(4, 'Pedido'),
	(5, 'Uso Personal');
/*!40000 ALTER TABLE `tipos_transacciones` ENABLE KEYS */;


-- Volcando estructura para tabla precio.transacciones
DROP TABLE IF EXISTS `transacciones`;
CREATE TABLE IF NOT EXISTS `transacciones` (
  `ID_TRANSACCION` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `FECHA_TRANSACCION` datetime NOT NULL,
  `ID_PERSONA_EMISOR` bigint(10) unsigned NOT NULL,
  `ID_PERSONA_RECEPTOR` bigint(10) unsigned NOT NULL,
  `ID_TIPO_TRANSACCION` tinyint(3) unsigned NOT NULL,
  `ID_ESTADO_TRANSACCION` tinyint(3) unsigned NOT NULL,
  `DESCUENTO` decimal(6,2) unsigned DEFAULT NULL,
  `INTERES` decimal(6,2) unsigned DEFAULT NULL,
  `AJUSTE` decimal(3,2) DEFAULT NULL,
  PRIMARY KEY (`ID_TRANSACCION`),
  KEY `transacciones_fk_personas_e` (`ID_PERSONA_EMISOR`),
  KEY `transacciones_fk_personas_r` (`ID_PERSONA_RECEPTOR`),
  KEY `transacciones_fk_estados_transacciones` (`ID_ESTADO_TRANSACCION`),
  KEY `transacciones_fk_tipos_transacciones` (`ID_TIPO_TRANSACCION`),
  CONSTRAINT `transacciones_fk_estados_transacciones` FOREIGN KEY (`ID_ESTADO_TRANSACCION`) REFERENCES `estados_transacciones` (`id_estado_transaccion`),
  CONSTRAINT `transacciones_fk_personas_e` FOREIGN KEY (`ID_PERSONA_EMISOR`) REFERENCES `personas` (`id_persona`),
  CONSTRAINT `transacciones_fk_personas_r` FOREIGN KEY (`ID_PERSONA_RECEPTOR`) REFERENCES `personas` (`id_persona`),
  CONSTRAINT `transacciones_fk_tipos_transacciones` FOREIGN KEY (`ID_TIPO_TRANSACCION`) REFERENCES `tipos_transacciones` (`id_tipo_transaccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Transacciones que pueden ser \nVentas\nCompras\nPedidos\nPresupuestos\nEtc';

-- Volcando datos para la tabla precio.transacciones: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `transacciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `transacciones` ENABLE KEYS */;


-- Volcando estructura para tabla precio.transacciones_items
DROP TABLE IF EXISTS `transacciones_items`;
CREATE TABLE IF NOT EXISTS `transacciones_items` (
  `ID_TRANSACCION_ITEM` bigint(30) unsigned NOT NULL AUTO_INCREMENT,
  `ID_TRANSACCION` bigint(20) unsigned NOT NULL,
  `CANTIDAD` decimal(10,2) unsigned NOT NULL,
  `ID_UNIDAD` int(10) unsigned NOT NULL,
  `ID_PRODUCTO` bigint(10) unsigned NOT NULL,
  `ID_MARCA` int(10) unsigned NOT NULL,
  `PRECIO_UNITARIO` decimal(10,2) unsigned NOT NULL,
  PRIMARY KEY (`ID_TRANSACCION_ITEM`),
  KEY `transacciones_items_fk_transacciones` (`ID_TRANSACCION`),
  KEY `transacciones_items_fk_productos` (`ID_PRODUCTO`),
  KEY `transacciones_items_fk_marcas` (`ID_MARCA`),
  KEY `transacciones_items_fk_unidades` (`ID_UNIDAD`),
  CONSTRAINT `transacciones_items_fk_marcas` FOREIGN KEY (`ID_MARCA`) REFERENCES `marcas` (`ID_MARCA`),
  CONSTRAINT `transacciones_items_fk_productos` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `productos` (`ID_PRODUCTO`),
  CONSTRAINT `transacciones_items_fk_transacciones` FOREIGN KEY (`ID_TRANSACCION`) REFERENCES `transacciones` (`ID_TRANSACCION`),
  CONSTRAINT `transacciones_items_fk_unidades` FOREIGN KEY (`ID_UNIDAD`) REFERENCES `unidades` (`ID_UNIDAD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla precio.transacciones_items: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `transacciones_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `transacciones_items` ENABLE KEYS */;


-- Volcando estructura para tabla precio.unidades
DROP TABLE IF EXISTS `unidades`;
CREATE TABLE IF NOT EXISTS `unidades` (
  `ID_UNIDAD` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_DIMENSION` tinyint(3) unsigned NOT NULL,
  `NOMBRE` tinytext NOT NULL,
  `SIMBOLO` tinytext NOT NULL,
  `FACTOR_NUMERADOR` tinyint(3) unsigned NOT NULL,
  `FACTOR_DENOMINADOR` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`ID_UNIDAD`),
  KEY `unidades_fk_dimensiones` (`ID_DIMENSION`),
  CONSTRAINT `unidades_fk_dimensiones` FOREIGN KEY (`ID_DIMENSION`) REFERENCES `dimensiones` (`ID_DIMENSION`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla precio.unidades: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `unidades` DISABLE KEYS */;
INSERT INTO `unidades` (`ID_UNIDAD`, `ID_DIMENSION`, `NOMBRE`, `SIMBOLO`, `FACTOR_NUMERADOR`, `FACTOR_DENOMINADOR`) VALUES
	(1, 2, 'Litro', 'L', 1, 1);
/*!40000 ALTER TABLE `unidades` ENABLE KEYS */;


-- Volcando estructura para tabla precio.usuarios
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `ID_USUARIO` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `USUARIO` varchar(30) NOT NULL,
  `CLAVE` tinytext,
  PRIMARY KEY (`ID_USUARIO`),
  UNIQUE KEY `USUARIO_UK` (`USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla precio.usuarios: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`ID_USUARIO`, `USUARIO`, `CLAVE`) VALUES
	(1, 'fabio', 'clabe'),
	(2, 'sergio', 'clabe');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
