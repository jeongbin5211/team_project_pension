create table room_list(
                          room_id int not null auto_increment,
                          room_name varchar(10) not null unique,
                          room_price int not null,
                          max_person int not null,
                          min_person int not null,
                          primary key(room_id)
);

create table room_images(
                            id int not null,
                            orgName varchar(255),
                            savedFileName varchar(255),
                            savedPathFileName varchar(255),
                            savedFileSize bigint,
                            folderName varchar(10),
                            ext varchar(20)
);