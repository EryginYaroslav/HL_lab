# db_init_generator.py
# Этот скрипт генерирует SQL-скрипт для инициализации БД
# (создание таблиц и вставка тестовых данных)

sql = """
-- Создание таблицы клиентов
CREATE TABLE IF NOT EXISTS clients (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    age INTEGER,
    subscription_end_date DATE
);

-- Создание таблицы тренировок
CREATE TABLE IF NOT EXISTS trainings (
    id SERIAL PRIMARY KEY,
    type VARCHAR(50),
    duration INTEGER,
    difficulty VARCHAR(50)
);

-- Создание таблицы посещений
CREATE TABLE IF NOT EXISTS visits (
    id SERIAL PRIMARY KEY,
    client_id INTEGER REFERENCES clients(id),
    training_id INTEGER REFERENCES trainings(id),
    visit_date DATE,
    calories_burned INTEGER
);

-- Вставка данных в clients
INSERT INTO clients(full_name, age, subscription_end_date)
VALUES ('Иван Иванов', 30, '2025-12-31'),
       ('Петр Петров', 25, '2025-10-15');

-- Вставка данных в trainings
INSERT INTO trainings(type, duration, difficulty)
VALUES ('бег', 30, 'средняя'),
       ('йога', 45, 'легкая');

-- Вставка данных в visits
INSERT INTO visits(client_id, training_id, visit_date, calories_burned)
VALUES (1, 1, CURRENT_DATE, 300),
       (2, 2, CURRENT_DATE - INTERVAL '10 days', 200),
       (1, 2, CURRENT_DATE - INTERVAL '5 days', 250);
"""

with open("init.sql", "w", encoding="utf-8") as f:
    f.write(sql)

print("SQL initialization script generated and saved to init.sql.")
