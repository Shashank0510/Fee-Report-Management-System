create database admin;
use  admin;
CREATE TABLE authentication (
id int not null,
aname varchar(20) not null,
passcode varchar(20),
PRIMARY KEY(id)
);
INSERT INTO authentication (id, aname, passcode)
VALUES (1, 'admin', 'admin123');
select * from authentication;