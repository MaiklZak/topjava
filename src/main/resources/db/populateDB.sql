DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);


INSERT INTO meals (description, calories, datetime, user_id)
VALUES ('Breakfast', 500, '2020-01-30 10:00:00', 100000),
       ('Lunch', 1000, '2020-01-30 13:00:00', 100000 ),
       ('Dinner', 850, '2020-01-30 19:00:00', 100000),
       ('Breakfast', 700, '2020-01-31 10:30:00', 100000),
       ('Lunch', 1100, '2020-01-31 13:30:00', 100001),
       ('Dinner', 650, '2020-01-31 19:00:00', 100001);