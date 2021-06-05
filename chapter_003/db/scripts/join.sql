

create table faculties (
                           id serial primary key,
                           name varchar(255)
);
create table studentsOfFaculty (
                                   id serial primary key,
                                   name varchar(255),
                                   faculty_id int references faculties(id)
);

insert into faculties(name) values ('math');
insert into faculties(name) values ('physics');
insert into faculties(name) values ('management');
insert into faculties(name) values ('philosophy');

insert into studentsOfFaculty(name, faculty_id) values ('Vladimir', 1);
insert into studentsOfFaculty(name, faculty_id) values ('Nikolay', 1);
insert into studentsOfFaculty(name, faculty_id) values ('Ivan', 1);
insert into studentsOfFaculty(name, faculty_id) values ('Petr', 1);
insert into studentsOfFaculty(name, faculty_id) values ('Nikita', null);

insert into studentsOfFaculty(name, faculty_id) values ('Lev', 2);
insert into studentsOfFaculty(name, faculty_id) values ('Alexey', 2);

insert into studentsOfFaculty(name, faculty_id) values ('Kirill', 3);
insert into studentsOfFaculty(name, faculty_id) values ('Andrey', 3);

--Выполнить запросы
select * from studentsOfFaculty s join faculties f on f.id = s.faculty_id;
select * from studentsOfFaculty s join faculties f on f.id = s.faculty_id where s.faculty_id is null;
select ss.name from studentsOfFaculty as ss join faculties as s on ss.faculty_id = s.id;
select ss.name as Имя from studentsOfFaculty as ss join faculties as s on ss.faculty_id = s.id;