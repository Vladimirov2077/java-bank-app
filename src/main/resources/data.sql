-- data.sql

-- Вставка данных в таблицу Customers
INSERT INTO Customers (name, surname, email, age) VALUES ('User1', 'Java', 'user1@example.com', 22);
INSERT INTO Customers (name, surname, email, age) VALUES ('User2', 'Java', 'user2@example.com', 33);

-- Вставка данных в таблицу Employers
INSERT INTO Employers (name, address) VALUES ('Company A', 'Address A');
INSERT INTO Employers (name, address) VALUES ('Company B', 'Address B');

-- Вставка данных в таблицу связи Customers и Employers
INSERT INTO Customers_Employers (customer_id, employer_id) VALUES (1, 1);
INSERT INTO Customers_Employers (customer_id, employer_id) VALUES (2, 2);

-- Вставка данных в таблицу Accounts
INSERT INTO Accounts (number, currency, balance, customer_id) VALUES (UUID(), 'UAN', 0.0, 1);
