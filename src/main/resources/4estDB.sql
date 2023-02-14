SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
SET GLOBAL FOREIGN_KEY_CHECKS=0;


DROP SCHEMA IF EXISTS 4est ;
CREATE SCHEMA IF NOT EXISTS 4est DEFAULT CHARACTER SET utf8 ;
USE 4est ;

DROP TABLE IF EXISTS 4est.Location_has_Plant_Species ;
DROP TABLE IF EXISTS 4est.Entry ;
DROP TABLE IF EXISTS 4est.Location ;
DROP TABLE IF EXISTS 4est.Plant_Species ;
DROP TABLE IF EXISTS 4est.Moment ;

CREATE TABLE Moment (
  DTG TIMESTAMP NOT NULL,
  Season VARCHAR(45) NOT NULL,
  Plant_Growth_Phase VARCHAR(45) NOT NULL,
  Weather VARCHAR(45) NOT NULL,
  PRIMARY KEY (DTG)
);
CREATE TABLE Plant_Species (
  Plant_Latin_Name VARCHAR(100) NOT NULL,
  Plant_Common_Name VARCHAR(50) NOT NULL,
  Toxic TINYINT NOT NULL,
  Edible TINYINT NOT NULL,
  Medicinal TINYINT NOT NULL,
  Plant_Description LONGTEXT NOT NULL,
  PRIMARY KEY (Plant_Latin_Name)
);

CREATE TABLE Location (
  Location_Name VARCHAR(60) NOT NULL,
  Geography VARCHAR(45) NOT NULL,
  Vegetative_Zone VARCHAR(45) NOT NULL,
  Growing_Zone VARCHAR(10) NULL,
  Elevation INT NULL,
  Location_Notes LONGTEXT NOT NULL,
  PRIMARY KEY (Location_Name)
);


CREATE TABLE Entry (
  Entry_Number INT AUTO_INCREMENT NOT NULL,
  Body_Trunk_Stem_Description LONGTEXT NULL,
  Branch_Leaf_Pattern_Description LONGTEXT NULL,
  Flower_Fruit_Description LONGTEXT NULL,
  Notes LONGTEXT NOT NULL,
  Location_Name VARCHAR(60) NOT NULL,
  Plant_Latin_Name VARCHAR(100) NOT NULL,
  DTG TIMESTAMP NOT NULL,
  PRIMARY KEY (Entry_Number, DTG),
  FOREIGN KEY (Location_Name) REFERENCES Location (Location_Name) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (Plant_Latin_Name) REFERENCES Plant_Species (Plant_Latin_Name) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (DTG) REFERENCES Moment (DTG) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Location_has_Plant_Species (
  Location_Name VARCHAR(60) NOT NULL,
  Plant_Latin_Name VARCHAR(100) NOT NULL,
  FOREIGN KEY (Location_Name) REFERENCES Location (Location_Name) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (Plant_Latin_Name) REFERENCES Plant_Species (Plant_Latin_Name) ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO `4est`.`plant_species`
(`Plant_Latin_Name`,
`Plant_Common_Name`,
`Toxic`,
`Edible`,
`Medicinal`,
`Plant_Description`
)
VALUES
('Prunus Virginiana Demissa',
'Western Chokecherry',
False,
True,
True,
'The Western Chokecherry is generally described as a perennial tree or
shrub. Its most active growth period is in the spring and summer. The
Western Chokecherry has green foliage and inconspicuous white flowers,
with an abundance of conspicuous red fruits or seeds. The greatest bloom is
usually observed in the spring, with fruit and seed production starting in
June and continuing throughout the summer months. Leaves are not
retained year to year. The Western Chokecherry has a short life span
relative to most other plant species and a rapid growth rate. At maturity, the
typical Western Chokecherry will reach a maximum height of 20 feet at 20
years of age.\n
Reference:\n
LIDDIL, Audrey, et Al. Edible Wild Berries in Southeast Idaho. University of Idaho. 2011. Retreived 1 January 2023 from: https://www.uidaho.edu/-/media/UIdaho-Responsive/Files/Extension/county/Bannock/horticulture/Edible-Wild-Berries.pdf?la=en&hash=DF89BA8E1DC83EB12C9CF68D1111D0C3E3765989 
\nJournal Entries: '
);
INSERT INTO `4est`.`plant_species`
(`Plant_Latin_Name`,
`Plant_Common_Name`,
`Toxic`,
`Edible`,
`Medicinal`,
`Plant_Description`
)
VALUES
('Ribes Aureum Pursh',
'Golden Current',
False,
True,
True,
'There are many species of currants in southeast Idaho but only one species
has fruit that actually tastes very good. The Golden Currant is so named
because of its display of golden yellow flowers in early spring. It is very
common along streams and in ravines and canyons and the seed is
commonly spread by birds so it can pop up just about anywhere. The fruit
can be golden – orange, red or black on the same species, in fact stands of
Golden Currant are often found with all three colors of ripe berries next to
each other. Golden Currant berries are by far the tastiest to eat fresh, far
sweeter than most other currants. The Golden Currant has a long life span
relative to most other plant species and a moderate growth rate. At maturity,
the typical Golden Currant will reach a maximum height of 10 feet at 20
years of age.\n
Reference:\n
LIDDIL, Audrey, et Al. Edible Wild Berries in Southeast Idaho. University of Idaho. 2011. Retreived 1 January 2023 from: https://www.uidaho.edu/-/media/UIdaho-Responsive/Files/Extension/county/Bannock/horticulture/Edible-Wild-Berries.pdf?la=en&hash=DF89BA8E1DC83EB12C9CF68D1111D0C3E3765989 
\nJournal Entries: '
);
INSERT INTO `4est`.`plant_species`
(`Plant_Latin_Name`,
`Plant_Common_Name`,
`Toxic`,
`Edible`,
`Medicinal`,
`Plant_Description`
)
VALUES
('Sambucus Nigra Cerulea',
'Blue Elderberry',
True,
True,
True,
'The Blue Elderberry grows along the roadsides in the lower parts of
mountains and canyons. It is a large shrub or small tree. Blossoms are borne
in a large flat-topped umbel. When ripe, the berries are dark blue or purple,
and hang from the branches in heavy clusters. The Elderberry is fast-growing
and has sweet berries and is usually found in moist areas. The species elders
have medium-green leaves and are small trees averaging 12 feet in height,
but there are smaller ones around 6 feet in height and some as tall as 20 feet.\n
Reference:\n
LIDDIL, Audrey, et Al. Edible Wild Berries in Southeast Idaho. University of Idaho. 2011. Retreived 1 January 2023 from: https://www.uidaho.edu/-/media/UIdaho-Responsive/Files/Extension/county/Bannock/horticulture/Edible-Wild-Berries.pdf?la=en&hash=DF89BA8E1DC83EB12C9CF68D1111D0C3E3765989 
\nJournal Entries: '
);
INSERT INTO `4est`.`location`
(`Location_Name`,
`Geography`,
`Vegetative_Zone`,
`Growing_Zone`,
`Elevation`,
`Location_Notes`)
VALUES
('City Creek Lower Trail',
'Steep Rolling Hills',
'Grassland/Savannah',
'5b',
4500,
'The lower trail following Pocatello\'s city creek in Idaho'
);
INSERT INTO `4est`.`location`
(`Location_Name`,
`Geography`,
`Vegetative_Zone`,
`Growing_Zone`,
`Elevation`,
`Location_Notes`)
VALUES
('Scout Mountain Overlook Trail',
'Mountain Forest',
'Deciduous Forest',
'6b',
6900,
'The trail leading from Scout Mountain Campground overlooking the Mink Creek Valley in Idaho'
);
INSERT INTO `4est`.`location`
(`Location_Name`,
`Geography`,
`Vegetative_Zone`,
`Growing_Zone`,
`Elevation`,
`Location_Notes`)
VALUES
('Mink Creek West Fork Trail',
'Mountain Forest',
'Deciduous Forest',
'6a',
5221,
'The trail starting at Mink Creek road passing the foot of slate mountain following the West fork of Mink Creek in Idaho'
);

INSERT INTO `4est`.`moment`
(`DTG`,
`Season`,
`Plant_Growth_Phase`,
`Weather`)
VALUES
('2023-01-28 01:57:22',
'Winter',
'Dormant',
'Snowy');

INSERT INTO `4est`.`moment`
(`DTG`,
`Season`,
`Plant_Growth_Phase`,
`Weather`)
VALUES
('2022-07-28 10:57:22',
'Summer',
'Fruiting',
'Sunny');

INSERT INTO `4est`.`moment`
(`DTG`,
`Season`,
`Plant_Growth_Phase`,
`Weather`)
VALUES
('2022-04-28 11:57:22',
'Spring',
'Flowering',
'Rainy');

INSERT INTO `4est`.`entry`
(`Body_Trunk_Stem_Description`,
`Branch_Leaf_Pattern_Description`,
`Flower_Fruit_Description`,
`Notes`,
`Location_Name`,
`Plant_Latin_Name`,
`DTG`)
VALUES
('Small Tree with dark brown bark, roughly 4in diameter.',
'Long slender branches, currently very brittle, no leaves.',
'A few shriveled berries are still attached to the branches',
'This is the initial Discovery of the plant',
'Mink Creek West Fork Trail',
'Prunus Virginiana Demissa',
'2023-01-28 01:57:22');


INSERT INTO `4est`.`entry`
(`Body_Trunk_Stem_Description`,
`Branch_Leaf_Pattern_Description`,
`Flower_Fruit_Description`,
`Notes`,
`Location_Name`,
`Plant_Latin_Name`,
`DTG`)
VALUES
('large shrub with light grey bark, roughly 2 inches in diameter, grows as tightly packed bush.',
'Long, slender branches with long, spearshaped, jagged leaves.',
'Bush is covered in large umbles of white flowers. the umbles are flat.',
'This is the initial Discovery of the plant',
'Scout Mountain Overlook Trail',
'Sambucus Nigra Cerulea',
'2022-07-28 10:57:22');

INSERT INTO `4est`.`entry`
(`Body_Trunk_Stem_Description`,
`Branch_Leaf_Pattern_Description`,
`Flower_Fruit_Description`,
`Notes`,
`Location_Name`,
`Plant_Latin_Name`,
`DTG`)
VALUES
('Small shrub with light grey bark, less than 0.5 in diameter, grows as tightly packed bush.',
'Long slender branches with large-lobed small green leaves.',
'many small, plump orange colored berries, each with what appears to be a stem protruding from the end of the berry. Small clumps of yellow flowers dot the bush as well.',
'This is the initial Discovery of the plant. The bush grows on the edge of the trail on an extremely steep slope. The stems range from 4 to 6 feet tall.',
'City Creek Lower Trail',
'Ribes Aureum Pursh',
'2022-04-28 11:57:22');


SET GLOBAL FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;