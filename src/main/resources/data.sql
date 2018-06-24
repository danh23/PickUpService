insert into users(id, city, country, email, first_name, last_name, username, password) values
(1, 'Bucuresti', 'Romania', 'test@test.ro','test', 'test', 'test', '12345');

insert into users(id, city, country, email,  first_name, last_name, username, password) values
(2, 'Bucuresti', 'Romania', 'client@test.ro',  'Client', 'Test', 'client.test', '12345');

insert into users(id, city, country, email,  first_name, last_name, username, password) values
(3, 'Bucuresti', 'Romania', 'driver@test.ro', 'Driver', 'Test', 'driver.test', '12345');

insert into location(id, latitude, longitude, user_id) values
(1, 45, 18,1);

insert into car_type(id, name, width, length, height, weight) values
(1, 'berlina', 1,0.5, 0.5, 200);

insert into car_type(id, name, width, length, height, weight) values
(2, 'monovolum', 1.5,1.5, 1.5, 400);

insert into driver_settings(id, user_id, latitude, longitude, take_fragile, car_type_id) values
(1, '3', 45,26, true, 1);

insert into orders(id, user_id, title, pick_up_latitude, pick_up_longitude, drop_off_latitude, drop_off_longitude, width, height, length, weight) values
(1, 2, 'Victoriei', 26.087539, 44.451843, 26.12, 44.49, 2, 3, 1, 200);

insert into orders(id, user_id, title, pick_up_latitude, pick_up_longitude, drop_off_latitude, drop_off_longitude, width, height, length, weight) values
(2, 2, 'EH',44.45130, 26.087889, 26.13, 44.48, 1.5, 1.5, 1, 500);

insert into orders(id, user_id, title, pick_up_latitude, pick_up_longitude, drop_off_latitude, drop_off_longitude, width, height, length, weight) values
(3, 2, 'Antipa', 44.453190, 26.085145, 26.13, 44.48, 1.5, 1.5, 1, 500);

insert into orders(id, user_id, title, pick_up_latitude, pick_up_longitude, drop_off_latitude, drop_off_longitude, width, height, length, weight) values
(4, 2, 'Romana', 44.444856, 26.097890, 26.13, 44.48, 1.5, 1.5, 1, 500);