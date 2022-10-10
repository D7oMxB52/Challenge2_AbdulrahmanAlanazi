CREATE TABLE IF NOT EXISTS accounts (
    id int NOT NULL,
    account_type ENUM("Term_Investment","Loan","Saving") DEFAULT NULL,
    account_number varchar(255) DEFAULT NULL,
    account_name varchar(255) DEFAULT NULL,
    balance varchar(255) DEFAULT NULL,
    date date DEFAULT NULL
    )ENGINE=InnoDB;