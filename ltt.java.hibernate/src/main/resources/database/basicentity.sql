USE learning_through_test;

CREATE TABLE Person (
	person_id MEDIUMINT UNSIGNED AUTO_INCREMENT NOT NULL,
		PRIMARY KEY(person_id),
	name VARCHAR(100) NOT NULL,
	home_address VARCHAR(100),
	UNIQUE INDEX PersonNameUnique (name)
) ENGINE = InnoDB;
