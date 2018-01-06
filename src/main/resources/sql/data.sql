insert into tbuser(id, username, password, gender, image) values(1, 'user', '$2a$10$YoBKUhEAKhzJOLz/ncv9.eCyXdJEIYypsHZ60C3MoiApJy.x8TphG', 'F', 'http://lorempixel.com/100/100/animals/');
insert into tbuser(id, username, password, gender, image) values(2, 'dba', '$2a$10$4bFVFo6TZ4tygLrJU5TbMe4CbBKIG8Qi.0cYJTjfDdCx9eGpj0jlu', 'F', 'http://lorempixel.com/100/100/nightlife/');
insert into tbuser(id, username, password, gender, image) values(3, 'admin', '$2a$10$Qs19iK5M59SALDTEWN4izuhd1zfbajRkPkeYRoPw6691RFM4lhBTi', 'F', 'http://lorempixel.com/100/100/people/');

--ROLE
insert into tbrole(id, role) values(8, 'USER');
insert into tbrole(id, role) values(9, 'DBA');
insert into tbrole(id, role) values(10, 'ADMIN');

--USER's ROLE
insert into tbuser_role(user_id, role_id) values(1, 8);
insert into tbuser_role(user_id, role_id) values(2, 9);
insert into tbuser_role(user_id, role_id) values(3, 10);