
CREATE TABLE IF NOT EXISTS PRODUCT(
    id INTEGER PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id FLOAT NOT NULL,
    price FLOAT NOT NULL,
    quantity INTEGER NOT NULL,
    discount float NOT NULL
);

insert into product(id, name, category_id, price, quantity, discount) values
    (1, 'product1', 1, 450.0, 10, 0.2),
    (2, 'product2', 2, 225.0, 10, 0.2),
    (3, 'product3', 3, 140.0, 10, 0.2),
    (4, 'product4', 4, 312.0, 10, 0.2);