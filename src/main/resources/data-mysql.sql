insert ignore into usermanagement.user (id, date_created, first_name, last_name, password, status, username)
values (0, current_date , 'Admin', 'Admin', '$2a$10$JHnr4q16FIpUkir3J2AjsOcHj3sSD8DaVFb4rpcoa2odoPHvYK5qe', 'ACTIVE', 'admin');
insert ignore into user_role (user_id, roles) values (0, 'ADMIN')