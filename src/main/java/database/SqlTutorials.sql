CREATE SCHEMA `onePage` DEFAULT CHARACTER SET utf8;
USE onePage;
DROP DATABASE `blog`;
CREATE TABLE `onepage`.`blog` (
 `id` INT NOT NULL AUTO_INCREMENT,
 `header` VARCHAR(400) NULL DEFAULT 'Blog başlığını girmediniz',
 `content` MEDIUMBLOB,
 `crated_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`id`));

DELETE FROM `onepage`.`blog` WHERE (`id` = '1');

INSERT INTO `onepage`.`blog` (`header`, `content`) VALUES ('header', content);

UPDATE onePage.blog set header ="alper",content = "bekar" where id="1";

TRUNCATE `onepage`.`blog`;

SELECT * FROM onepage.blog;

-- find
SELECT * FROM onePage.blog WHERE id="1";

-- find name
SELECT header FROM onepage.blog WHERE id ="1";
SELECT header FROM onepage.blog;

-- count
SELECT count(*) FROM onepage.blog;

-- like --> header kolonunda f ile başlayan değerleri bul
SELECT * FROM onepage.blog WHERE header LIKE 'F%';

-- like --> header kolonunda y ile biten değerleri bul
SELECT * FROM onepage.blog WHERE header LIKE '%y';
SELECT header FROM onepage.blog WHERE header LIKE '%y';