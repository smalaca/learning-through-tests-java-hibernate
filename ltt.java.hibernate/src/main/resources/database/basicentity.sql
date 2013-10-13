USE learning_through_test;

CREATE TABLE Person (
	person_id MEDIUMINT UNSIGNED AUTO_INCREMENT NOT NULL,
		PRIMARY KEY(person_id),
	name VARCHAR(767) NOT NULL,
	home_address VARCHAR(128),
	UNIQUE INDEX PersonNameUnique (name)
) ENGINE = InnoDB;
