DROP DATABASE IF EXISTS learningThroughTest;

CREATE DATABASE learningThroughTest;

USE learningThroughTest;

CREATE TABLE Person (
	person_id MEDIUMINT UNSIGNED AUTO_INCREMENT NOT NULL,
		PRIMARY KEY(person_id),
	name VARCHAR(767) NOT NULL,
	home_address VARCHAR(128),
	UNIQUE INDEX PersonNameUnique (name)
) ENGINE = InnoDB;
