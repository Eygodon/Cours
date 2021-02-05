-- phpMyAdmin SQL Dump
-- version 4.1.11
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mer 20 Janvier 2021 à 11:14
-- Version du serveur :  5.5.41-0+wheezy1
-- Version de PHP :  5.4.36-0+deb7u3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `gsubrena`
--

-- --------------------------------------------------------

--
-- Structure de la table `tp_articles`
--

CREATE TABLE IF NOT EXISTS `tp_articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auteur_id` int(11) NOT NULL,
  `titre` varchar(80) NOT NULL,
  `contenu` text NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `auteur_id` (`auteur_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `tp_articles`
--

INSERT INTO `tp_articles` (`id`, `auteur_id`, `titre`, `contenu`, `date`) VALUES
(1, 1, 'premier article de Gilles', 'contenu du premier article de Gilles	', '1922-06-11'),
(2, 1, 'Deuxième article de Gilles', 'contenu du 2me article de Gilles', '2099-11-19'),
(3, 3, 'algèbre pour cerveaux positroniques', 'Mise en évidence d''une faille dans l''application des 3 lois de la robotique', '2010-03-10');

-- --------------------------------------------------------

--
-- Structure de la table `tp_auteurs`
--

CREATE TABLE IF NOT EXISTS `tp_auteurs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(80) NOT NULL,
  `ville_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ville_id` (`ville_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `tp_auteurs`
--

INSERT INTO `tp_auteurs` (`id`, `nom`, `ville_id`) VALUES
(1, 'Gilles', 1),
(2, 'Personne', NULL),
(3, 'Rita', 1),
(4, 'Asterix', 1),
(5, 'Lucky Luke', 3),
(6, 'Jolly Jumper', 3),
(7, 'Joe Dalton', 2),
(8, 'Rantanplan', 2);

-- --------------------------------------------------------

--
-- Structure de la table `tp_villes`
--

CREATE TABLE IF NOT EXISTS `tp_villes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(80) NOT NULL,
  `code` varchar(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `tp_villes`
--

INSERT INTO `tp_villes` (`id`, `nom`, `code`) VALUES
(1, 'Poitiers', '86000'),
(2, 'Paris', '75000'),
(3, 'Lyon', '69000'),
(4, 'Lille', '59000');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `tp_articles`
--
ALTER TABLE `tp_articles`
  ADD CONSTRAINT `tp_articles_ibfk_1` FOREIGN KEY (`auteur_id`) REFERENCES `tp_auteurs` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `tp_auteurs`
--
ALTER TABLE `tp_auteurs`
  ADD CONSTRAINT `tp_auteurs_ibfk_1` FOREIGN KEY (`ville_id`) REFERENCES `tp_villes` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
