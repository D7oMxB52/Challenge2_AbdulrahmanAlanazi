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

CREATE TABLE IF NOT EXISTS accounts (
    id int NOT NULL,
    account_type ENUM("Term Investment","Loan","Saving") DEFAULT NULL,
    account_number varchar(255) DEFAULT NULL,
    account_name varchar(255) DEFAULT NULL,
    balance varchar(255) DEFAULT NULL,
    date date DEFAULT NULL
    )ENGINE=InnoDB;