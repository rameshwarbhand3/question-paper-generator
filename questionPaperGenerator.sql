
drop database if exists questionPaperGeneratorDb;

create database questionPaperGeneratorDb;

use  questionPaperGeneratorDb;


DROP TABLE IF EXISTS `users`;

CREATE TABLE users (
    username VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(50),
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    PRIMARY KEY (email , username)
);
insert ignore into users values('ram',MD5('ram'),'ram@luv2code.com','Rameshwar','Bhand');
insert ignore into users values('sham',MD5('sham'),'sham@luv2code.com','Sham','Bhand');


DROP TABLE IF EXISTS `questionBank`;

CREATE TABLE `questionBank` (
    `SrNo` INT(3) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `Question` VARCHAR(100) DEFAULT NULL,
    `optionA` VARCHAR(50) DEFAULT NULL,
    `optionB` VARCHAR(50) DEFAULT NULL,
    `optionC` VARCHAR(80) DEFAULT NULL,
    `OptionD` VARCHAR(50) DEFAULT NULL,
    `CorrectAns` VARCHAR(10) DEFAULT NULL,
    `Category` VARCHAR(15) DEFAULT NULL,
    `Complexity` VARCHAR(15) DEFAULT NULL
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;


--
-- Dumping data for table `questionBank`
--


INSERT INTO `questionBank` VALUES 
(1,'What is the satellite of the earth called?','sun','moon','mars','saturn','B','Geography','Simple'),
(2,'Which city is the capital of Maharashtra?','Pune','Nashik','Nagpur','Mumbai','D','History','Complex'),
(3,'When did the state of Gujrat come into existence?','1May 1961','1May 1960','1May 1965','1May 1970','B','History','Medium'),
(4,'In which state did Shivaji Maharaj establish the Swaraj?','Gujrat','Bihar','Maharashtra','Keral','C','History','Simple'),
(5,'Who was the king who ruled over Bijapur?','Nijamshah','Deshmukhs','Mugal Badshaha','Adilshah','D','History','Complex'),
(6,'Which period did Leonardo Da Vinci belong to?','Renaissance','Ancient','Modern','Medieval','A','GK','Simple'),
(7,'Name Sant Dnyaneshwar\'s sister.','Muktabai','Geetabai','Saibai','Jijabai','A','History','Complex'),
(8,'Which book did Dnyaneshwar write?','Geeta','Dasbodh','Leelachritra','Dnyaneshwari','D','GK','Medium'),
(9,'Who wrote Dasbodh?','Tukaram','Namdeo','Sopandeo','Sant Ramdas','D','History','Medium'),
(10,'Where was Gandhiji born?','Mumbai','Porbandar','Johannesberg','Baroda','B','History','Simple'),
(11,'What was the first name of the teacher of Shivaji Maharaj?','Vithoji','Dattoji','Dadoji','Balaji','C','History','Simple'),
(12,'What was the name of the state established by Bajirao\'s grandson?','Uttar Pradesh','Banda','Kanda','Pune','B','History','Medium'),
(13,'In which language did Dnyaneshwar write his book?','Hindi','Sanskrit','Marathi','Urdu','C','History','Simple'),
(14,'The water that gets stored under the ground is called------?','ground water','pond','reservoir','lake','A','Science','Complex'),
(15,'In the following, which is the hill-station in Sahyandri mountain?','Pal','Mahabaleshwar','Chikhaldara','Toranmal','B','Geography','Simple'),
(16,'From June to September, in which direction the mansoon winds blow over Maharashtra?','south-east','north-west','south-west','north-east','C','Geography','Medium'),
(17,'Which city in Maharashtra receives the highest rainfall?','Chikhaldara','Toranmal','Gadchiroli','Amboli','D','Geography','Simple'),
(18,'Which is the highest peak in Maharashtra?','Mahabaleshwar','Salher','Pachgani','Kalsubai','D','Geography','Complex'),
(19,'Which is the state tree of Maharashtra?','Banyan','Mango','Peepul','Jackfruit','B','GK','Medium'),
(20,'Which is the State animal of Maharashtra?','tiger','porcupine','shekaroo','fox','C','GK','Complex'),
(21,'India\'s first satellite is named after','Aryabhatta','Bhaskara II','Bhaskara I','Albert Einstein','A','GK','Simple'),
(22,'Galileo was an Italian astronomer who','developed the telescope','discovered four satellites of Jupiter','discovered that the movement of pendulum produces a regular time measurement','All of the above','D','GK','Simple'),
(23,'How many red blood cells does the bone marrow produce every second?','5 million','7 million','10 million','12 million','C','GK','Simple'),
(24,'How many red blood cells does the bone marrow produce every second?','5 million','7 million','10 million','12 million','C','Science','Medium'),
(25,'How many Layers of skin are there in human body?','5','7','10','12','B','Science','Medium'),
(26,'How many sence organs do we have?','5 ','7 ','10 ','12','A','Science','Simple'),
(27,'Thinking part of human body is called_____','head','brain','mind','eyes','B','Science','Simple');





















