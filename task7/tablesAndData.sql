--1. TABLE employeesAge


CREATE TABLE employeesAge (
	id SERIAL PRIMARY KEY,
	employeeName VARCHAR(50),
	age INTEGER
);

DROP TABLE employeesAge;

DELETE FROM
	public.employeesAge;

DO 

$ $ BEGIN FOR i in 1..10000 LOOP
INSERT INTO
	employeesAge (employeeName, age)
SELECT
	(
		SELECT
			*
		FROM
			(
				VALUES
					('John'),
					('Alice'),
					('Michael'),
					('Emily'),
					('Daniel'),
					('Sophia'),
					('James'),
					('Olivia'),
					('William'),
					('Emma')
			)
		ORDER BY
			random()
		LIMIT
			1
	), (random() * 40 + 20) :: int;

END LOOP;

END;

$ $ 

--2. TABLE departmentSalary
CREATE TABLE departmentSalary (
	id SERIAL PRIMARY KEY,
	employeeName VARCHAR(50),
	departmentName VARCHAR(50),
	salary BIGINT
);

DROP TABLE departmentSalary
DELETE FROM
	public.departmentSalary;

DO $ $ BEGIN FOR i in 1..10000 LOOP
INSERT INTO
	departmentSalary (employeeName, departmentName, salary)
SELECT
	(
		SELECT
			*
		FROM
			(
				VALUES
					('John'),
					('Alice'),
					('Michael'),
					('Emily'),
					('Daniel'),
					('Sophia'),
					('James'),
					('Olivia'),
					('William'),
					('Emma')
			)
		ORDER BY
			random()
		LIMIT
			1
	), (
		SELECT
			*
		FROM
			(
				VALUES
					('Software Development'),
					('Information Security'),
					('IT Infrastructure'),
					('Technical Support'),
					('Data Analytics'),
					('Quality Assurance'),
					('System Administration'),
					('IT Sales and Marketing'),
					('Project Management'),
					('Research and Development')
			)
		ORDER BY
			random()
		LIMIT
			1
	), 5000 + (random() * (450000 - 5000 + 1)) :: BIGINT;

END LOOP;

END;

$ $ 

--3. TABLES departmentLocation & departmentEmployee
DROP TABLE departmentLocation;

DELETE FROM
	public.departmentLocation;

CREATE TABLE departmentLocation (
	id SERIAL PRIMARY KEY,
	departmentName VARCHAR(50),
	location VARCHAR(100)
);

DO $ $ BEGIN FOR i in 1..10000 LOOP
INSERT INTO
	departmentLocation (location, departmentName)
SELECT
	(
		SELECT
			*
		FROM
			(
				VALUES
					('Floor 1'),
					('Floor 2'),
					('Michael'),
					('Floor 3'),
					('Central office'),
					('First wing'),
					('Second wing'),
					('Unit in the technology park'),
					('Central office'),
					('Third wing')
			)
		ORDER BY
			random()
		LIMIT
			1
	), (
		SELECT
			*
		FROM
			(
				VALUES
					('Software Development'),
					('Information Security'),
					('IT Infrastructure'),
					('Technical Support'),
					('Data Analytics'),
					('Quality Assurance'),
					('System Administration'),
					('IT Sales and Marketing'),
					('Project Management'),
					('Research and Development')
			)
		ORDER BY
			random()
		LIMIT
			1
	);

END LOOP;

END;

$ $ DROP TABLE departmentEmployee;

DELETE FROM
	public.departmentEmployee;

CREATE TABLE departmentEmployee (
	id SERIAL PRIMARY KEY,
	employeeName VARCHAR(50),
	departmentId INTEGER REFERENCES departmentLocation(id)
);

DO $ $ BEGIN FOR i in 1..10000 LOOP
INSERT INTO
	departmentEmployee (employeeName, departmentId)
SELECT
	(
		SELECT
			*
		FROM
			(
				VALUES
					('John'),
					('Alice'),
					('Michael'),
					('Emily'),
					('Daniel'),
					('Sophia'),
					('James'),
					('Olivia'),
					('William'),
					('Emma')
			)
		ORDER BY
			random()
		LIMIT
			1
	), (
		SELECT
			id
		from
			departmentLocation
		ORDER BY
			random()
		LIMIT
			1
	);

END LOOP;

END;

$ $