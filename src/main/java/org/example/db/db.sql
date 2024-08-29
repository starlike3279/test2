DROP DATABASE IF EXISTS proj1;
CREATE DATABASE proj1;

USE proj1;

CREATE TABLE article (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	subject char(100) NOT NULL UNIQUE,
	content text
);

INSERT INTO article
SET id = 3,
subject = "test3",
content = "test3"

SELECT * FROM article;