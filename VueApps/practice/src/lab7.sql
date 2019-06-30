CREATE TABLE users(

	id int(11) NOT NULL AUTO_INCREMENT,
	UserName varchar(255) NOT NULL,
	Password char(60) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT UC_users UNIQUE (UserName)


);