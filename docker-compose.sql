CREATE DATABASE IF NOT EXISTS books;
USE books;

CREATE TABLE IF NOT EXISTS authors
(
  `id`         int(11) NOT NULL AUTO_INCREMENT,
  `name`     text,
  `email`    text,
  PRIMARY KEY (`id`)
);

INSERT INTO authors (name, email) VALUES ("hoge", "hoge@foo.com");
