create table products (id bigserial primary key, title varchar(255), info varchar(255), price int);
insert into products (title, info, price) values
('Хлеб', 'описание продукта', 10), ('Масло', 'описание продукта',  25), ('Сыр','описание продукта',  30), ('Яйца', 'описание продукта',  15), ('Лук', 'описание продукта',  5);
