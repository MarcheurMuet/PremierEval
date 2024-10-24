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



CREATE TABLE T_Format (
	IdFormat 			int(4) PRIMARY KEY AUTO_INCREMENT,
	format 				varchar(10) NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Format (IdFormat, format) VALUES (1, 'Mixte');
INSERT INTO T_Format (IdFormat, format) VALUES (2, 'Distentiel');
INSERT INTO T_Format (IdFormat, format) VALUES (3, 'Presentiel');

CREATE TABLE T_Training (
	IdTraining			int(4) PRIMARY KEY AUTO_INCREMENT,
	NameT				varchar(40)	NOT NULL UNIQUE,
	description			varchar(80)	NOT NULL UNIQUE,
	durationD			INT (40),
	price				DOUBLE (40),
	IdFormat			INT(40)	NOT NULL,
	FOREIGN KEY (IdFormat)	REFERENCES T_Format(IdFormat)
) ENGINE = InnoDB;

INSERT INTO T_Training (IdTraining, NameT, description, durationD, price, IdFormat) VALUES (1, 'DevWeb', 'Formation pour coder', 60, 900, 1);
INSERT INTO T_Training (IdTraining, NameT, description, durationD, price, IdFormat) VALUES (2, 'Cms', 'Formation pour... jen sais rien ', 140, 300, 1);
INSERT INTO T_Training (IdTraining, NameT, description, durationD, price, IdFormat) VALUES (3, 'Bureautique', 'Formation pour taper au clavier', 500, 50, 2);
INSERT INTO T_Training (IdTraining, NameT, description, durationD, price, IdFormat) VALUES (4, 'IA', 'Formation pour travailler avec les IA', 20, 7000, 2);
INSERT INTO T_Training (IdTraining, NameT, description, durationD, price, IdFormat) VALUES (5, 'CyberSecu', 'Formation pour securiser les sites internet', 40, 2300, 3);
INSERT INTO T_Training (IdTraining, NameT, description, durationD, price, IdFormat) VALUES (6, 'Conducteur Poid Lourd', 'Formation pour conduire', 120, 80000, 3);


CREATE TABLE T_Admin (
	IdAdmin 			int(4) PRIMARY KEY AUTO_INCREMENT,
	NickName			varchar(40)	NOT NULL UNIQUE,
	passwordA			varchar(40)	NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Admin (IdAdmin, NickName, passwordA) VALUES (1, 'MasterMind', 'Bigcerveau');

CREATE TABLE T_Basket (
	IdBasket 			int(4) PRIMARY KEY AUTO_INCREMENT,
	Amount				float(4) NOT NULL DEFAULT 0,
	DateBasket			DATE NOT NULL DEFAULT NOW(),
	idUser				int(4),
	FOREIGN KEY (idUser)	REFERENCES T_Users(idUser)
) ENGINE = InnoDB;

CREATE TABLE T_Basket_Items (
	IdBasketItem			int(4)	PRIMARY KEY AUTO_INCREMENT,
	IdTraining           INT(4)   NOT NULL,
	FOREIGN KEY(IdTraining) REFERENCES T_Training(IdTraining),
	Quantity			FLOAT(4) NOT NULL DEFAULT 1,
	UnitaryPrice		FLOAT(4)	NOT NULL DEFAULT 0,
	IdBasket             INT(4)   NOT NULL,
	FOREIGN KEY(IdBasket) REFERENCES T_Basket(IdBasket)
) ENGINE = InnoDB;

SHOW Tables;
SELECT * FROM T_Users;
SELECT * FROM T_Training;
SELECT * FROM T_Formats;
SELECT * FROM T_Admin;
SELECT * from T_Basket;
SELECT * from T_Basket_Items;