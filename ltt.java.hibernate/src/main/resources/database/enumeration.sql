/**
 * One enumeration should be with using enum mysql type and second as a db relation.
 */
USE learning_through_test;

CREATE TABLE Task (
	task_id MEDIUMINT UNSIGNED AUTO_INCREMENT NOT NULL,
		PRIMARY KEY(task_id),
	title VARCHAR(128) NOT NULL,
	status MEDIUMINT UNSIGNED NOT NULL,
	priority VARCHAR(10) NOT NULL
) ENGINE = InnoDB;