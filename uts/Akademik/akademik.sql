-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 30, 2015 at 01:14 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `akademik`
--

-- --------------------------------------------------------

--
-- Table structure for table `matakuliah`
--

CREATE TABLE IF NOT EXISTS `matakuliah` (
  `kode` varchar(10) NOT NULL,
  `matkul` varchar(50) NOT NULL,
  `sks` int(1) NOT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matakuliah`
--

INSERT INTO `matakuliah` (`kode`, `matkul`, `sks`) VALUES
('APBO1', 'Analisa Pernc. Berorientasi Objek 1', 2),
('APBO2', 'Analisa Pernc. Berorientasi Objek 2', 3),
('BI', 'Bahasa Indonesia', 3),
('BIng', 'Bahasa Inggris', 3),
('Kj', 'Keamanan Jaringan', 3),
('Kp', 'Kerja Praktek', 6),
('P1', 'Pemrograman 1', 3),
('P2', 'Pemrograman 2', 3),
('P3', 'Pemrograman 3', 3),
('PI1', 'Pemrograman Internet 1', 3),
('PI2', 'Pemrograman Internet 2', 3),
('PI3', 'Pemrograman Internet 3', 3),
('Proyek1', 'Proyek 1', 2),
('Proyek2', 'Proyek 2', 2),
('Proyek3', 'Proyek 3', 2),
('Proyek4', 'Proyek 4', 6);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `fullname` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `fullname`) VALUES
('admin', 'admin', 'administrator'),
('testing', '123456', 'testing');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
