DROP TABLE IF EXISTS message;
 
CREATE TABLE `message` (
  `id` int(45) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `creation_time` datetime NOT NULL,
  `last_update` datetime NOT NULL,
  `content` varchar(500) NOT NULL,
  `link` varchar(120),
  `icon` varchar(45),
  `tags` varchar(120),
  `due_date` date
);

INSERT INTO message VALUE (
	1,
	'2022-09-19 20:00',
	'2022-09-19 20:00',
	'Ceci est le premier message géré par le système de gestion des messages',
	'https://openclassrooms.com',
	'🥇',
	'manager,message,challenge',
	'2022-09-23 20:00'
)
