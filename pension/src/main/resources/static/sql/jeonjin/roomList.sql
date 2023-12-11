create table room_list(
                          room_num int not null auto_increment,
                          room_name varchar(10) not null unique,
                          room_price int not null,
                          max_person int not null,
                          min_person int not null,
                          checkin_time varchar(10) not null,
                          checkout_time varchar(10) not null,
                          primary key(room_num)
);

create table room_images(
                            id int not null,
                            orgName varchar(255),
                            savedFileName varchar(255),
                            savedPathFileName varchar(255),
                            savedFileSize bigint,
                            folderName varchar(10),
                            ext varchar(20),
                            foreign key(id) references room_list(room_num) on update cascade on delete restrict

);