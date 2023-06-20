CREATE SCHEMA `onePage` DEFAULT CHARACTER SET utf8;
USE onePage;
DROP DATABASE `blog`;
CREATE TABLE `onePage`.`blog` (
 `id` INT NOT NULL AUTO_INCREMENT,
 `header` VARCHAR(400) NULL DEFAULT 'Blog başlığını girmediniz',
 `content` MEDIUMBLOB,
 `crated_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`id`));

DELETE FROM `onePage`.`blog` WHERE (`id` = '1');

INSERT INTO `onePage`.`blog` (`header`, `content`) VALUES ('header', content);

UPDATE onePage.blog set header ="alper",content = "bekar" where id="1";

TRUNCATE `onePage`.`blog`;

SELECT * FROM onePage.blog;

-- find
SELECT * FROM onePage.blog WHERE id="1";

-- find name
SELECT header FROM onePage.blog WHERE id ="1";
SELECT header FROM onePage.blog;

-- count
SELECT count(*) FROM onePage.blog;

-- like --> header kolonunda f ile başlayan değerleri bul
SELECT * FROM onePage.blog WHERE header LIKE 'F%';

-- like --> header kolonunda y ile biten değerleri bul
SELECT * FROM onePage.blog WHERE header LIKE '%y';
SELECT header FROM onePage.blog WHERE header LIKE '%y';