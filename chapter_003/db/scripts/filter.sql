

create table type (
                      id serial primary key,
                      name text
);

create table product (
                         id serial primary key,
                         name text,
                         type_id int references type(id),
                         expired_date date,
                         price int
);

insert into "type" (name) values
('Сырный'), ('Хлебо-Булочный'),
('Мясной'), ('Рыбный'),
('Овощной'), ('Молочный');

insert into product(name, type_id, expired_date, price) VALUES
('Адыгейский', 1, '2021-03-11', 1100),
('Пармизан', 1, '2021-01-22', 1300),
('Мраморный', 1, '2021-01-27', 850),
('Бородинский', 2, '2021-01-28', 29),
('Рижский', 2, '2021-02-27', 32),
('Батон', 2, '2021-01-26', 15),
('Свинина', 3, '2021-02-23', 280),
('Говядина', 3, '2021-01-26', 300),
('Баранина', 3, '2021-01-21', 320),
('Карп', 4, '2021-01-25', 80),
('Карась', 4, '2021-02-23', 100),
('Креветки', 4, '2021-02-24', 200),
('Огурец', 5, '2021-01-22', 40),
('Томат', 5, '2021-01-21', 60),
('Молоко', 6, '2021-01-20', 40),
('Сметана', 6, '2021-01-20', 100),
('Мороженое пломбир', 6, '2021-01-24', 40),
('Мороженое планета ссср', 6, '2021-01-24', 50);

--1. Написать запрос получение всех продуктов с типом "СЫР"
select * from product as p inner join type as t on p.type_id = t.id where t.name like '%Сыр%';
--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product where name like '%Мороженое%';
--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select *
from product
where expired_date >= date_trunc('month', current_date) + INTERVAL '1 month'
  and expired_date <= date_trunc('month', current_date) + INTERVAL '2 month';
--4. Написать запрос, который выводит самый дорогой продукт.
select max(price) from product;
select * from product where price = (select max(price) from product);
--5. Написать запрос, который выводит количество всех продуктов определенного типа.
select * from product as p inner join type as t on p.type_id = t.id where t.name like 'Рыб%';
--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select * from product as p inner join type as t on p.type_id = t.id
where t.name like 'Сыр%' or t.name like 'Моло%';
--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select t.name from product as p inner join type as t on p.type_id = t.id
group by t.name having count(t.id) < 10;
--8. Вывести все продукты и их тип.
select * from product as p inner join type as t on p.type_id = t.id;
