create database IF NOT EXISTS data;
use data;
create table IF NOT EXISTS accounts(
			id int not null auto_increment,
			username varchar(255) not null,
			password varchar(255) not null,			
			birthday varchar(255) not null,
			gmail varchar(255) not null,
			primary key (id)
		);
create table IF NOT EXISTS images(
			id int not null,
			name varchar(255) not null primary key,
			photo mediumblob not null
		);
