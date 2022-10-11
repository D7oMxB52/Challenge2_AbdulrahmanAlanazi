CREATE TABLE IF NOT EXISTS people (
    id int NOT NULL,
    name varchar(255) DEFAULT NULL,
    address varchar(255) DEFAULT NULL,
    postcode varchar(255) DEFAULT NULL,
    age varchar(255) DEFAULT NULL,
    job varchar(255) DEFAULT NULL,
    email varchar(255) DEFAULT NULL,
    phoneno varchar(255) DEFAULT NULL
    )ENGINE=InnoDB;