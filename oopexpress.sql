-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 11, 2020 at 09:23 AM
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
('E1', 1, '18:45:28', '05:04:42', '05:06:19', '05:13:47', '10-10-2020', '11-10-2020', '11-10-2020', '11-10-2020', 'Received'),
('N2', 2, '05:06:00', '05:06:19', '05:14:01', '05:14:16', '11-10-2020', '11-10-2020', '11-10-2020', '11-10-2020', 'Received');

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
('E1', 1, 'Thep Nimit', 'S9', '1150', 'Meen Wasun', 'S11', '1112'),
('N2', 2, 'H', 'h', 'h', 'b', 'b', 'b');

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
('E1', 1, '10-10-2020', '18:45:28', 'XL', 'Size of Box: 40x50x30 inches', 400000, 400000, 'Picked up', 'Emergency'),
('N2', 2, '11-10-2020', '05:06:00', 'M', 'Size of Box: 27x43x20 inches', 145, 145, 'Picked up', 'Normal');

-- --------------------------------------------------------

--
-- Table structure for table `updatedb`
--

CREATE TABLE `updatedb` (
  `transport_id` varchar(10) NOT NULL,
  `status` varchar(50) NOT NULL,
  `time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

--
-- Indexes for table `updatedb`
--
ALTER TABLE `updatedb`
  ADD UNIQUE KEY `transport_id` (`transport_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
