-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 11, 2020 at 12:27 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oopexpress`
--

-- --------------------------------------------------------

--
-- Table structure for table `box`
--

CREATE TABLE `box` (
  `size` varchar(4) NOT NULL,
  `width` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `depth` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `box`
--

INSERT INTO `box` (`size`, `width`, `height`, `depth`) VALUES
('l', 35, 45, 25),
('m', 27, 43, 20),
('mini', 14, 20, 6),
('s', 20, 30, 11),
('xl', 40, 50, 30);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `transport_id` varchar(11) NOT NULL,
  `package_id` int(11) NOT NULL,
  `picked_upTime` time NOT NULL,
  `transportingTime` time NOT NULL,
  `deliverTime` time NOT NULL,
  `receivedTime` time NOT NULL,
  `picked_upDate` varchar(50) NOT NULL,
  `transportingDate` varchar(50) NOT NULL,
  `deliverDate` varchar(50) NOT NULL,
  `receivedDate` varchar(50) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`transport_id`, `package_id`, `picked_upTime`, `transportingTime`, `deliverTime`, `receivedTime`, `picked_upDate`, `transportingDate`, `deliverDate`, `receivedDate`, `status`) VALUES
('N1', 1, '17:11:38', '17:12:05', '17:12:25', '17:13:17', '11-10-2020', '11-10-2020', '11-10-2020', '11-10-2020', 'Received');

-- --------------------------------------------------------

--
-- Table structure for table `transport`
--

CREATE TABLE `transport` (
  `transport_id` varchar(11) NOT NULL,
  `package_id` int(11) NOT NULL,
  `sender_name` varchar(256) NOT NULL,
  `sender_address` varchar(500) NOT NULL,
  `sender_tel` varchar(10) NOT NULL,
  `receiver_name` varchar(256) NOT NULL,
  `receiver_address` varchar(500) NOT NULL,
  `receiver_tel` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transport`
--

INSERT INTO `transport` (`transport_id`, `package_id`, `sender_name`, `sender_address`, `sender_tel`, `receiver_name`, `receiver_address`, `receiver_tel`) VALUES
('N1', 1, 'bsdf', 'sdffsd', 'sdfd', 'fsfsdfd', 'dsfsd', 'sdfds');

-- --------------------------------------------------------

--
-- Table structure for table `transport_detail`
--

CREATE TABLE `transport_detail` (
  `transport_id` varchar(11) NOT NULL,
  `package_id` int(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  `time` time NOT NULL,
  `boxsize` varchar(4) NOT NULL,
  `volume` varchar(50) NOT NULL,
  `weight` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `transport_detail` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transport_detail`
--

INSERT INTO `transport_detail` (`transport_id`, `package_id`, `date`, `time`, `boxsize`, `volume`, `weight`, `price`, `status`, `transport_detail`) VALUES
('N1', 1, '11-10-2020', '17:11:38', 'mini', 'Size of Box: 14x20x6 inches', 55, 57, 'Picked up', 'Normal');

-- --------------------------------------------------------

--
-- Table structure for table `updatedb`
--

CREATE TABLE `updatedb` (
  `dashboard` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `updatedb`
--

INSERT INTO `updatedb` (`dashboard`) VALUES
('N1 has been changed to Transport :17:12:05'),
('N1 has been changed to Deliver :17:12:25'),
('N1 has been changed to Received :17:13:17');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `box`
--
ALTER TABLE `box`
  ADD PRIMARY KEY (`size`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD UNIQUE KEY `transport_id` (`transport_id`);

--
-- Indexes for table `transport`
--
ALTER TABLE `transport`
  ADD UNIQUE KEY `transport_id` (`transport_id`);

--
-- Indexes for table `transport_detail`
--
ALTER TABLE `transport_detail`
  ADD UNIQUE KEY `transport_id` (`transport_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
