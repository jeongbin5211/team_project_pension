create table reserve_list(
	id int not null,
	order_num varchar(20) not null unique,
	checkin date not null,
	checkout date not null,
	person int not null,
	reserve_email varchar(30) not null,
	reserve_name varchar(20) not null,
	reserve_tell varchar(11) not null,
	pay_money int not null,
	room_name varchar(1) not null,
	settlement_time datetime not null,
	settlement_state int not null,
	day_night int not null,
	foreign key(id) references member(id) ON UPDATE cascade ON DELETE restrict
);


-- DTO만!!
-- create table room_check(
-- 	checkin date not null,
-- 	checkout date not null,
-- 	person int not null,
-- 	day_night int not null,
-- );

-- create table reserve(
-- 	id int not null auto_increment,
-- 	room_name varchar(10) not null,
-- 	room_price int not null,
-- 	person int not null,
-- 	reserver_name varchar(20) not null,
-- 	reserver_tell varchar(20) not null,
-- 	primary key(id)
-- );