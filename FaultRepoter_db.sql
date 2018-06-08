/* SQL Manager for MySQL                              5.6.2.48160 */
/* -------------------------------------------------------------- */
/* Host     : localhost                                           */
/* Port     : 3306                                                */
/* Database : FaultRepoter_db                                     */


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES 'utf8' */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `faultrepoter_db`;

CREATE DATABASE `FaultRepoter_db`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `faultrepoter_db`;

/* Structure for the `residence` table : */

CREATE TABLE `residence` (
  `id` INTEGER(11) NOT NULL,
  `rezName` VARCHAR(40) COLLATE utf8_general_ci NOT NULL,
  `roomNO` CHAR(5) COLLATE utf8_general_ci NOT NULL,
  `faultDescription` TEXT COLLATE utf8_general_ci NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
;

/* Data for the `residence` table  (LIMIT 0,500) */

INSERT INTO `residence` (`id`, `rezName`, `roomNO`, `faultDescription`, `date`) VALUES
  (1,'chumani','1d2','broken window','2016-11-04'),
  (2,'chumani','333','fused light bulb','2016-05-05'),
  (3,'silimela','124','no plugs','2016-03-04'),
  (4,'Silimela','147','broken window','1969-12-31'),
  (6,'sdf','213','sff','1969-12-31'),
  (8,'ktc','72','no closet','1969-12-31'),
  (233,'as','123','asa','1969-12-31'),
  (409,'gf','45','d','1969-12-31'),
  (785,'Silimela','14147','broken window','1969-12-31');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;