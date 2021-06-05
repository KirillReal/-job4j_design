

create table devices(
                        id serial primary key,
                        name varchar(255)
);

create table people(
                       id serial primary key,
                       name varchar(255)
);

create table devices_people(
                               id serial primary key,
                               device_id int references devices(id),
                               people_id int  references people(id),
                               price float
);

insert into devices(name) values ('Phone');
insert into devices(name) values ('Laptop');
insert into devices(name) values ('PC');

insert into people(name) values ('Anna');
insert into people(name) values ('Ivan');
insert into people(name) values ('Boris');

insert into devices_people(device_id, people_id, price) values (1,1, 4455.3);
insert into devices_people(device_id, people_id, price) values (1,2, 5967.4);
insert into devices_people(device_id, people_id, price) values (1, 2, 3363.2);

insert into devices_people(device_id, people_id, price) values (2, 1, 3254.6);
insert into devices_people(device_id, people_id, price) values (2, 2, 4743.2);
insert into devices_people(device_id, people_id, price) values (2, 3, 5352.9);

insert into devices_people(device_id, people_id, price) values (3, 1, 5341.2);
insert into devices_people(device_id, people_id, price) values (3, 2, 4113.5);
insert into devices_people(device_id, people_id, price) values (3, 3, 7763.8);

select d.name, avg(dp.price) from devices_people as dp join devices d on dp.people_id = d.id
group by d.name;
select d.name, avg(dp.price) from devices_people as dp join devices d on dp.people_id = d.id
group by d.name
having avg(dp.price) > 5000;
