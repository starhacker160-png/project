CREATE DATABASE IF NOT EXISTS shop_billing_db
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE shop_billing_db;

CREATE TABLE IF NOT EXISTS product (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255),
    price DECIMAL(10,2) NOT NULL,
    stock INT DEFAULT 0,
    PRIMARY KEY (id),
    CONSTRAINT chk_product_stock CHECK (stock >= 0),
    CONSTRAINT chk_product_price CHECK (price >= 0)
);

CREATE TABLE IF NOT EXISTS sale (
    id BIGINT NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(255),
    sale_date DATETIME(6),
    total DECIMAL(12,2),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS sale_item (
    id BIGINT NOT NULL AUTO_INCREMENT,
    product_id BIGINT,
    product_name VARCHAR(255),
    quantity INT,
    price DECIMAL(10,2),
    subtotal DECIMAL(12,2),
    PRIMARY KEY (id),
    CONSTRAINT chk_sale_item_quantity CHECK (quantity > 0),
    CONSTRAINT fk_sale_item_product FOREIGN KEY (product_id)
        REFERENCES product(id)
);

CREATE TABLE IF NOT EXISTS sale_items (
    sale_id BIGINT NOT NULL,
    items_id BIGINT NOT NULL,
    PRIMARY KEY (items_id),
    UNIQUE KEY uk_sale_items_item (items_id),
    CONSTRAINT fk_sale_items_sale FOREIGN KEY (sale_id)
        REFERENCES sale(id),
    CONSTRAINT fk_sale_items_item FOREIGN KEY (items_id)
        REFERENCES sale_item(id)
);

INSERT INTO product (name, category, price, stock)
SELECT 'Tea', 'Drink', 20.00, 100
WHERE NOT EXISTS (SELECT 1 FROM product WHERE name = 'Tea');

INSERT INTO product (name, category, price, stock)
SELECT 'Coffee', 'Drink', 30.00, 80
WHERE NOT EXISTS (SELECT 1 FROM product WHERE name = 'Coffee');

INSERT INTO product (name, category, price, stock)
SELECT 'Biscuits', 'Food', 25.00, 50
WHERE NOT EXISTS (SELECT 1 FROM product WHERE name = 'Biscuits');

INSERT INTO product (name, category, price, stock)
SELECT 'Milk', 'Drink', 35.00, 40
WHERE NOT EXISTS (SELECT 1 FROM product WHERE name = 'Milk');
