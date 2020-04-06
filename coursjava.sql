-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 06 avr. 2020 à 10:56
-- Version du serveur :  5.7.19
-- Version de PHP :  7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `coursjava`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(200) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `prenom` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `numero`, `nom`, `prenom`) VALUES
(1, 'xxr', 'xxx', 'xxx'),
(2, 'xx', 'xx', 'xx'),
(3, 'yyyy', 'yyy', 'yyy');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(50) NOT NULL,
  `solde` double NOT NULL,
  `createAt` date DEFAULT NULL,
  `type` varchar(50) NOT NULL,
  `frais` int(11) DEFAULT NULL,
  `taux` int(11) DEFAULT NULL,
  `dateDeblocage` date DEFAULT NULL,
  `idClient` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id`, `numero`, `solde`, `createAt`, `type`, `frais`, `taux`, `dateDeblocage`, `idClient`) VALUES
(1, 'xx', 233, '2020-04-06', 'xx', NULL, NULL, NULL, 1),
(2, 'CCH01', 500000, NULL, 'Cheque', 200, 0, NULL, 1),
(3, 'CE01', 500000, NULL, 'Epargne', 0, 5, NULL, 1),
(4, 'CE02', 500000, NULL, 'Epargne', 0, 5, NULL, 3),
(5, 'CCH01', 5000000, NULL, 'Cheque', 200, 0, NULL, 3),
(6, 'CCH06', 600000, NULL, 'Cheque', 200, 0, NULL, 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
