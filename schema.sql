
USE food_delivery;
SELECT DATABASE();
SHOW TABLES;
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE employee (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    position VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE category (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255)
);
CREATE TABLE menu (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES category(id)
);
CREATE TABLE address (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    address VARCHAR(255),
    city VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
CREATE TABLE orders (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    total_amount DECIMAL(10,2),
    status VARCHAR(30),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
CREATE TABLE order_items (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_id BIGINT,
    menu_id BIGINT,
    quantity INT,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (menu_id) REFERENCES menu(id)
);
CREATE TABLE payment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_id BIGINT,
    amount DECIMAL(10,2),
    method VARCHAR(30),
    status VARCHAR(30),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);
SHOW TABLES;
DROP TABLE user;
SHOW TABLES;
SELECT * FROM users;
USE food_delivery;
DESCRIBE users;
ALTER TABLE users ADD COLUMN name VARCHAR(100);
DESCRIBE users;
ALTER TABLE users
ADD COLUMN email VARCHAR(255) UNIQUE;

INSERT INTO users (name, email, password, role)
VALUES ('Test User', 'test@gmail.com', '1234', 'USER');
DESCRIBE users;
SELECT id, username, email, password, role FROM users;
INSERT INTO users (username, name, email, password, role)
VALUES ('testuser', 'Test User', 'test@gmail.com', '1234', 'USER');
SELECT id, username, email, password, role FROM users;
DESCRIBE menu;
ALTER TABLE menu
ADD COLUMN restaurant_id BIGINT;
UPDATE menu SET restaurant_id = 1;
DESCRIBE menu;
DESCRIBE orders;
INSERT INTO users (username, password, role)
VALUES ('admin', 'admin', 'ADMIN');
DESCRIBE users;
SELECT * FROM users;
DESCRIBE users;
USE food_delivery;
DELETE FROM users;
SELECT * FROM users;
DELETE FROM users;
SELECT * FROM users;
TRUNCATE TABLE users;

DELETE FROM users;