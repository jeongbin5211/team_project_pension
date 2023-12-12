create table member(
id int not null auto_increment,
userid varchar(20) not null unique,
userpw varchar(20) not null,
name varchar(10) not null,
phone char(11) not null,
email varchar(50) not null,
addr varchar(100),
regdate datetime,
position char(1),
primary key(id)
);

insert into member values(null, 'admin', '1234', '관리자', '01012345678', 'email@email.com', 'addr', now(), '2');
insert into member values(null, 'user', '1234', 'user', '01012345678', 'email@email.com', 'addr', now(), '1');

