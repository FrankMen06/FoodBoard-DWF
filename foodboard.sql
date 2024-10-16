-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-10-2024 a las 06:01:55
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `foodboard`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `idCategoria` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `estado` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `codigoClient` varchar(8) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `idMesa` int(11) NOT NULL,
  `codigo` varchar(8) NOT NULL,
  `tiempo` int(11) DEFAULT NULL,
  `estado` varchar(25) NOT NULL,
  `id_mesa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE `comentario` (
  `idComentario` int(11) NOT NULL,
  `comentario` varchar(500) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `codigo` varchar(8) NOT NULL,
  `contraseña` varchar(200) NOT NULL,
  `nombre1` varchar(100) NOT NULL,
  `nombre2` varchar(100) NOT NULL,
  `apellido1` varchar(100) NOT NULL,
  `apellido2` varchar(100) NOT NULL,
  `correo` varchar(200) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `dui` varchar(10) NOT NULL,
  `fechaNac` varchar(12) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `municipio` varchar(200) NOT NULL,
  `departamento` varchar(200) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  `estadoCivil` varchar(50) NOT NULL,
  `rol` varchar(25) NOT NULL,
  `estado` varchar(25) NOT NULL,
  `estado_civil` varchar(15) NOT NULL,
  `fecha_nac` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`codigo`, `contraseña`, `nombre1`, `nombre2`, `apellido1`, `apellido2`, `correo`, `telefono`, `dui`, `fechaNac`, `direccion`, `municipio`, `departamento`, `sexo`, `estadoCivil`, `rol`, `estado`, `estado_civil`, `fecha_nac`) VALUES
('1234', '$2b$12$9uJEXLA99h8TNOm2zc3gLu5TDK7yISADTXnqlmzu2iZhxSFb89ldu', 'Oscar', 'José', 'Gallegos', 'Hernández', 'xd@gmail.com', '7635-8954', '12345678-6', '2003-06-29', 'Calle a tonacatepeque', 'San Salvador Este', 'San Salvador', 'Masculino', 'Soltera/o', 'Mesero', 'si', '', '2024-10-14'),
('maca123', '$2a$10$7PT6xnUN5mlwZtP5oEQlaeU6.6HN72U2mgaEvCXZEoWRB.L9uRWy6', 'maria', 'Josefa', 'Vásquez', 'castillo', 'maria@gmail.com', '7346-1937', '12345678-4', '2004-01-29', 'Soyapango', 'Cuscatlán Norte', 'San Salvador', 'Masculino', 'Soltera/o', 'Administrador', 'si', '', '2024-10-14'),
('mo0111', '$2a$10$7PT6xnUN5mlwZtP5oEQlaeU6.6HN72U2mgaEvCXZEoWRB.L9uRWy6', 'Benito', 'Antonio', 'Martinez', 'Ocasio', 'xd2@gmail.com', '7389-1256', '12345678-2', '2004-11-01', 'Distrito de soyapango', 'Primero seleccione un departamento', 'San Salvador', 'Masculino', 'Soltera/o', 'Recepcionista', 'si', '', '2024-10-14'),
('ms222712', '$2b$12$9uJEXLA99h8TNOm2zc3gLu5TDK7yISADTXnqlmzu2iZhxSFb89ldu', 'José', 'Macario', 'Rojas', 'Arévalo', 'oficial.count@gmail.com', '7346-1947', '12345678-1', '2004-10-23', 'Soya', 'Primero seleccione un departamento', 'San Salvador', 'Masculino', 'Soltera/o', 'Mesero', 'si', '', '2024-10-14'),
('Pedidos', '$2b$12$9uJEXLA99h8TNOm2zc3gLu5TDK7yISADTXnqlmzu2iZhxSFb89ldu', 'Pedidos', 'Pedidos', 'Pedidos', 'Pedidos', 'Pedidos', 'Pedidos', 'Pedidos', '2004-11-01', 'Pedidos', 'Pedidos', 'Pedidos', 'Pedidos', 'Pedidos', 'Pedidos', 'si', '', '2024-10-14'),
('XD', '$2b$12$9uJEXLA99h8TNOm2zc3gLu5TDK7yISADTXnqlmzu2iZhxSFb89ldu', 'Roberto', 'Carlos', 'Ramirez', 'Ochoa', 'kjjkl.am29@gmail.com', '7695-8954', '12345678-5', '2004-01-29', 'Distrito de soyapango', 'Ahuachapán Norte', 'Ahuachapán', 'Masculino', 'Casada/o', 'Mesero', 'si', '', '2024-10-14'),
('xd01', '$2b$12$9uJEXLA99h8TNOm2zc3gLu5TDK7yISADTXnqlmzu2iZhxSFb89ldu', 'furcio', 'Godofredo', 'murcia', 'Hernández', 'furcio@gmail.com', '7822-1744', '12345678-3', '2004-12-25', 'Algo', 'San Salvador Este', 'San Salvador', 'Masculino', 'Viuda/o', 'JefeCocina', 'si', '', '2024-10-14');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesas`
--

CREATE TABLE `mesas` (
  `idMesa` int(11) NOT NULL,
  `Capacidad` int(11) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `id_Sector` int(11) NOT NULL,
  `Estado` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden`
--

CREATE TABLE `orden` (
  `idOrden` int(11) NOT NULL,
  `codigoClient` varchar(8) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `tiempoEspera` time DEFAULT NULL,
  `total` double NOT NULL,
  `comentario` varchar(200) NOT NULL,
  `estado` varchar(25) NOT NULL,
  `codigo_client` varchar(8) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `tiempo_espera` time(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `precio` double NOT NULL,
  `imagen` varchar(100) NOT NULL,
  `tiempo` time NOT NULL,
  `estado` varchar(25) NOT NULL,
  `id_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sector`
--

CREATE TABLE `sector` (
  `id_Sector` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`codigoClient`),
  ADD KEY `idMesa` (`idMesa`),
  ADD KEY `codigo` (`codigo`);

--
-- Indices de la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`idComentario`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `mesas`
--
ALTER TABLE `mesas`
  ADD PRIMARY KEY (`idMesa`),
  ADD KEY `id_Sector` (`id_Sector`);

--
-- Indices de la tabla `orden`
--
ALTER TABLE `orden`
  ADD PRIMARY KEY (`idOrden`),
  ADD KEY `codigoClient` (`codigoClient`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `idCategoria` (`idCategoria`);

--
-- Indices de la tabla `sector`
--
ALTER TABLE `sector`
  ADD PRIMARY KEY (`id_Sector`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `comentario`
--
ALTER TABLE `comentario`
  MODIFY `idComentario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `mesas`
--
ALTER TABLE `mesas`
  MODIFY `idMesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `orden`
--
ALTER TABLE `orden`
  MODIFY `idOrden` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=122;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT de la tabla `sector`
--
ALTER TABLE `sector`
  MODIFY `id_Sector` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`idMesa`) REFERENCES `mesas` (`idMesa`) ON UPDATE CASCADE,
  ADD CONSTRAINT `clientes_ibfk_2` FOREIGN KEY (`codigo`) REFERENCES `empleados` (`codigo`);

--
-- Filtros para la tabla `mesas`
--
ALTER TABLE `mesas`
  ADD CONSTRAINT `mesas_ibfk_1` FOREIGN KEY (`id_Sector`) REFERENCES `sector` (`id_Sector`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `orden`
--
ALTER TABLE `orden`
  ADD CONSTRAINT `orden_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`) ON UPDATE CASCADE,
  ADD CONSTRAINT `orden_ibfk_2` FOREIGN KEY (`codigoClient`) REFERENCES `clientes` (`codigoClient`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`idCategoria`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
