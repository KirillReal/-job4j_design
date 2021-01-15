insert into roles(name) values ('guest');
insert into roles(name) values ('admin');

insert into rules(name) values ('chat');
insert into rules(name) values ('change');

insert into roles_rules(role_id, rule_id) values (1,1);
insert into roles_rules(role_id, rule_id) values (2,2);

insert into categories(name) values ('warning');
insert into categories(name) values ('usual');

insert into states(name) values ('solved');
insert into states(name) values ('unsolved');

insert into users(name, roles_id) values ('ds',1);
insert into users(name, roles_id) values ('dss',2);

insert into items(name, category_id, state_id, user_id) values ('first',1,2,1);
insert into items(name, category, state_id, user_id) values ('second',2,1,2);

insert into comments(name) values ('help');
insert into comments(name) values ('delete');

insert into attachs(name) values ('*.txt');
insert into attachs(name) values ('*.txt');