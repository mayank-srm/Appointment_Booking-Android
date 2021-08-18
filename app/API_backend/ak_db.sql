-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 18, 2021 at 03:38 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ak_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `id` int(5) NOT NULL,
  `name` varchar(20) NOT NULL,
  `type` varchar(10) NOT NULL,
  `phone` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`id`, `name`, `type`, `phone`) VALUES
(1, 'Akshay', 'Doctor', 1212121212),
(2, 'Mayank', 'Lawyer', 1231231231),
(3, 'aman', 'doctor', 1231231231);

-- --------------------------------------------------------

--
-- Table structure for table `bookingtbl`
--

CREATE TABLE `bookingtbl` (
  `id` int(10) NOT NULL,
  `type` varchar(20) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookingtbl`
--

INSERT INTO `bookingtbl` (`id`, `type`, `date`) VALUES
(1, 'doctor', '0000-00-00'),
(20, 'Plumber', '2021-08-15'),
(21, 'Plumber', '2021-08-15'),
(22, 'Electrician', '2021-08-16'),
(23, 'Plumber', '2021-08-18'),
(24, '', '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` text NOT NULL,
  `gender` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `email`, `password`, `gender`) VALUES
(1, 'mayank', 'mayank@gmail.com', '4297f44b13955235245b2497399d7a93', 'male'),
(2, 'mayank198', 'abc123@gmai.com', 'f5bb0c8de146c67b44babbf4e6584cc0', 'Male'),
(3, 'mayank1', 'mayank12@gmail.com', '4297f44b13955235245b2497399d7a93', 'male'),
(4, 'akshay', 'akshay123@gmail.com', '4297f44b13955235245b2497399d7a93', 'Male'),
(5, 'akshay1', 'akshay1@gmail.com', '4297f44b13955235245b2497399d7a93', 'Male'),
(6, 'akshay12', 'akshay12@gmail.com', '4297f44b13955235245b2497399d7a93', 'Male'),
(7, 'Mayank1211', 'mayank1211@gmail.com', '4297f44b13955235245b2497399d7a93', 'Male');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bookingtbl`
--
ALTER TABLE `bookingtbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookingtbl`
--
ALTER TABLE `bookingtbl`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
