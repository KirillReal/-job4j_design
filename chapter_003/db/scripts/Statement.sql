
create table cities(
                       id serial primary key,
                       name text,
                       population int
);
insert into cities(name, population) values ('Ufa', 1000000) returning (id);