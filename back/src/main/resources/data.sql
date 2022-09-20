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
