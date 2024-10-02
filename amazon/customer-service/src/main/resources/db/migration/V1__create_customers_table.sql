CREATE TABLE IF NOT EXISTS CUSTOMER (
    id INTEGER PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL);

insert into customer (email, first_name, last_name, id) values
('ahmadou.aboubakar@improvemyskills.com', 'Ahmadou', 'ABOUBAKAR', 1),
('king.tchalla@improvemyskills.com', 'King', 'TCHALLA', 2),
('tony.stark@improvemyskills.com', 'Tony', 'STARK', 3);