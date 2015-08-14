-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 14, 2015 at 05:12 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_facturacion`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_categorias`
--

CREATE TABLE IF NOT EXISTS `tbl_categorias` (
  `codigo_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_categoria` varchar(100) NOT NULL,
  PRIMARY KEY (`codigo_categoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tbl_categorias`
--

INSERT INTO `tbl_categorias` (`codigo_categoria`, `nombre_categoria`) VALUES
(1, 'Categoria 1'),
(2, 'Categoria 2');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_lotes`
--

CREATE TABLE IF NOT EXISTS `tbl_lotes` (
  `codigo_lote` int(11) NOT NULL AUTO_INCREMENT,
  `lote` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo_lote`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tbl_lotes`
--

INSERT INTO `tbl_lotes` (`codigo_lote`, `lote`) VALUES
(1, 'Lote 1'),
(2, 'Lote 2');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_marcas`
--

CREATE TABLE IF NOT EXISTS `tbl_marcas` (
  `codigo_marca` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_marca` varchar(100) NOT NULL,
  PRIMARY KEY (`codigo_marca`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `tbl_marcas`
--

INSERT INTO `tbl_marcas` (`codigo_marca`, `nombre_marca`) VALUES
(1, 'Marca 1'),
(2, 'Marca 2'),
(3, 'Marca 3'),
(4, 'Marca X'),
(5, 'Marca Y');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_monedas`
--

CREATE TABLE IF NOT EXISTS `tbl_monedas` (
  `codigo_moneda` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_moneda` varchar(45) DEFAULT NULL,
  `abreviatura_moneda` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo_moneda`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tbl_monedas`
--

INSERT INTO `tbl_monedas` (`codigo_moneda`, `nombre_moneda`, `abreviatura_moneda`) VALUES
(1, 'Lempiras', 'L.'),
(2, 'Dolares', '$');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_productos`
--

CREATE TABLE IF NOT EXISTS `tbl_productos` (
  `codigo_producto` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_barra` varchar(45) NOT NULL,
  `nombre_producto` varchar(100) NOT NULL,
  `descripcion_de_producto` varchar(45) NOT NULL,
  `precio_de_compra` double NOT NULL,
  `precio_de_venta` double NOT NULL,
  `existencia` float NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `codigo_marca` int(11) NOT NULL,
  `codigo_categoria` int(11) NOT NULL,
  `codigo_proveedores` int(11) NOT NULL,
  `codigo_moneda` int(11) NOT NULL,
  `codigo_unidad_medida` int(11) NOT NULL,
  `codigo_lote` int(11) NOT NULL,
  PRIMARY KEY (`codigo_producto`),
  KEY `fk_tbl_productos_tbl_marcas_idx` (`codigo_marca`),
  KEY `fk_tbl_productos_tbl_categorias1_idx` (`codigo_categoria`),
  KEY `fk_tbl_productos_tbl_proveedores1_idx` (`codigo_proveedores`),
  KEY `fk_tbl_productos_tbl_monedas1_idx` (`codigo_moneda`),
  KEY `fk_tbl_productos_tbl_unidad_medidas1_idx` (`codigo_unidad_medida`),
  KEY `fk_tbl_productos_tbl_lotes1_idx` (`codigo_lote`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_proveedores`
--

CREATE TABLE IF NOT EXISTS `tbl_proveedores` (
  `codigo_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_proveedor` varchar(100) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `numero_telefono` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codigo_proveedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tbl_proveedores`
--

INSERT INTO `tbl_proveedores` (`codigo_proveedor`, `nombre_proveedor`, `direccion`, `numero_telefono`) VALUES
(1, 'Proveedor 1', NULL, NULL),
(2, 'Proveedor 2', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_unidad_medidas`
--

CREATE TABLE IF NOT EXISTS `tbl_unidad_medidas` (
  `codigo_unidad_medida` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_unidad_medida` varchar(60) NOT NULL,
  `abreviatura` varchar(10) NOT NULL,
  PRIMARY KEY (`codigo_unidad_medida`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tbl_unidad_medidas`
--

INSERT INTO `tbl_unidad_medidas` (`codigo_unidad_medida`, `nombre_unidad_medida`, `abreviatura`) VALUES
(1, 'Unidad 1', 'u1'),
(2, 'Unidad 2', 'u2');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_productos`
--
ALTER TABLE `tbl_productos`
  ADD CONSTRAINT `fk_tbl_productos_tbl_categorias1` FOREIGN KEY (`codigo_categoria`) REFERENCES `tbl_categorias` (`codigo_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbl_productos_tbl_lotes1` FOREIGN KEY (`codigo_lote`) REFERENCES `tbl_lotes` (`codigo_lote`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbl_productos_tbl_marcas` FOREIGN KEY (`codigo_marca`) REFERENCES `tbl_marcas` (`codigo_marca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbl_productos_tbl_monedas1` FOREIGN KEY (`codigo_moneda`) REFERENCES `tbl_monedas` (`codigo_moneda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbl_productos_tbl_proveedores1` FOREIGN KEY (`codigo_proveedores`) REFERENCES `tbl_proveedores` (`codigo_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbl_productos_tbl_unidad_medidas1` FOREIGN KEY (`codigo_unidad_medida`) REFERENCES `tbl_unidad_medidas` (`codigo_unidad_medida`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
