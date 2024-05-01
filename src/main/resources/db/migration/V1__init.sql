
CREATE TABLE IF NOT EXISTS customer (
id SERIAL,
name VARCHAR(50) NOT NULL,
lastname VARCHAR(50) NOT NULL,
age INT,
email VARCHAR(50) NOT NULL ,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS doctor (
    id SERIAL,
    fullName VARCHAR(50) NOT NULL,
    specialty VARCHAR(50) NOT NULL,
    age INT,
    email VARCHAR(50) NOT NULL ,
    PRIMARY KEY (id)
);


