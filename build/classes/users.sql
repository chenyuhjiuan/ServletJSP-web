-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 10, 2015 at 06:53 PM
-- Server version: 5.5.32
-- PHP Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `usermanager`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `email` varchar(64) NOT NULL,
  `grade` int(11) DEFAULT '1',
  `passwd` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `email`, `grade`, `passwd`) VALUES
(1, 'emily1', 'emily1@yahoo.com', 1, '123'),
(2, 'emily21', 'emily2@yahoo.com', 1, '123456'),
(3, 'emily5', 'emily5@yahoo.com', 1, '123'),
(4, 'emily6', 'emily6@yahoo.com', 1, '123'),
(5, 'emily7', 'emily7@yahoo.com', 1, '123'),
(6, 'emily8', 'emily8@yahoo.com', 1, '123'),
(7, 'emily9', 'emily9@yahoo.com', 1, '123'),
(8, 'emily10', 'emily10@yahoo.com', 1, '123'),
(9, 'emily11', 'emily11@yahoo.com', 1, '123'),
(10, 'emily12', 'emily12@yahoo.com', 1, '123'),
(11, 'emily13', 'emily13@yahoo.com', 1, '123'),
(12, 'emily14', 'emily14@yahoo.com', 1, '123'),
(14, 'Mary Lee', 'marylee@hotmail.com', 1, '12345'),
(15, 'Nancy Wu', 'nancywu@hotmail.com', 1, 'ilovejune1'),
(16, 'Yuhjiuan Chen', 'yuhchen@yahoo.com', 1, '12345'),
(17, 'Add Users', 'addusers@yahoo.com', 1, '12345'),
(18, 'tetw', 'teryw', 1, 'tewte'),
(19, 'hsyrruer', 'gshsfh', 1, 'hfhs'),
(20, 'marywhite', 'marywhite@yahoo.com', 1, '12345'),
(21, 'ert', '234@yahoo.com', 2, '12345'),
(22, 'emily3', 'emily3@hotmail.com', 1, '45678'),
(23, 'Nancy2', 'nancy2@hotmail.com', 1, '23456');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
