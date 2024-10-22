DROP DATABASE IF EXISTS Forma;
CREATE DATABASE Forma;
USE Forma;

CREATE TABLE T_Users (
	idUser				int(4)		PRIMARY KEY AUTO_INCREMENT,
	Name				varchar(40)	NOT NULL UNIQUE,
	FirstName			varchar(40)	NOT NULL UNIQUE,
	password			varchar(40)	NOT NULL UNIQUE,
	email				varchar(40)	NOT NULL UNIQUE,
	adress				varchar(40)	NOT NULL UNIQUE,
	phoneNumber			int(20)		NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Users (idUser, Name, FirstName, password, email, adress, phoneNumber) VALUES ( 1, 'Estaque' ,	'Remi', 'Thema1418', 'estaque.remi@gmail.com','10 rue Desaix', 0608834156);
INSERT INTO T_Users (idUser, Name, FirstName, password, email, adress, phoneNumber) VALUES ( 2, 'Banisu' ,	'Lenny', 'cest moi cest moi omg cest moi', 'mdrjensaisrieng@gmail.com','fjt', 0788563265);
INSERT INTO T_Users (idUser, Name, FirstName, password, email, adress, phoneNumber) VALUES ( 3, 'Driger' ,	'Eliel', 'heiiiiiiiiiiin', 'propovmariokart@gmail.com','allersansretour', 666999222);


CREATE TABLE T_Training (
	IdTraining			int(4) PRIMARY KEY AUTO_INCREMENT,
	NameT				varchar(40)	NOT NULL UNIQUE,
	description			varchar(80)	NOT NULL UNIQUE,
	durationD			INT (40),
	format				varchar(40)	NOT NULL,
	price				INT (40)
) ENGINE = InnoDB;

INSERT INTO T_Training (IdTraining, NameT, description, durationD, format, price) VALUES (1, 'DevWeb', 'Formation pour coder', 60, 'Mixte', 900);
INSERT INTO T_Training (IdTraining, NameT, description, durationD, format, price) VALUES (2, 'Cms', 'Formation pour... jen sais rien ', 140, 'Distanciel', 300);
INSERT INTO T_Training (IdTraining, NameT, description, durationD, format, price) VALUES (3, 'Bureautique', 'Formation pour taper au clavier', 500, 'Distanciel', 50);
INSERT INTO T_Training (IdTraining, NameT, description, durationD, format, price) VALUES (4, 'IA', 'Formation pour travailler avec les IA', 20, 'Mixte', 7000);
INSERT INTO T_Training (IdTraining, NameT, description, durationD, format, price) VALUES (5, 'CyberSecu', 'Formation pour securiser les sites internet', 40, 'Presentiel', 2300);
INSERT INTO T_Training (IdTraining, NameT, description, durationD, format, price) VALUES (6, 'Conducteur Poid Lourd', 'Formation pour conduire', 120, 'Presentiel', 80000);

CREATE TABLE T_Admin (
	IdAdmin 			int(4) PRIMARY KEY AUTO_INCREMENT,
	NickName			varchar(40)	NOT NULL UNIQUE,
	passwordA			varchar(40)	NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Admin (IdAdmin, NickName, passwordA) VALUES (1, 'MasterMind', 'Bigcerveau');

CREATE TABLE T_Basket (
	IdBasket 			int(4) PRIMARY KEY AUTO_INCREMENT,
	FormaList			varchar(400)	NOT NULL,
	idUser				int(4),
	FOREIGN KEY (idUser)	REFERENCES T_Users(idUser)
) ENGINE = InnoDB;

INSERT INTO T_Basket (IdBasket, FormaList, idUser) VALUES (1, 'DevWeb, Cms, IA, CyberSecu', idUser);

SHOW Tables;
SELECT * from T_Users;
SELECT * from T_Training;
SELECT * from T_Admin;
SELECT * from T_Basket;