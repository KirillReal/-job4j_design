select version();
create database cars;
create table cars(
                     id serial primary key,
                     name varchar(255),
                     year int,
                     mileage int
);
insert into cars(name, year, mileage) values ('Lada',2009,40000);
select * from cars;
update cars set year = 2010
where id = 1;
select * from cars;
delete from cars;