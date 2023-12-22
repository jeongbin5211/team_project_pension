create table board_notice (
board_notice_id int not null auto_increment,
board_notice_subject varchar(50) not null,
board_notice_writer varchar(20) not null,
board_notice_content text,
board_notice_regdate date,
board_notice_visit int,
primary key(board_notice_id)
);

create table board_qna (
board_qna_id int not null auto_increment,
board_qna_subject varchar(50) not null,
board_qna_writer varchar(20) not null,
board_qna_content text,
board_qna_regdate date,
board_qna_visit int,
board_qna_grp int,
board_qna_seq int,
board_qna_depth int,
board_answer_check int,
primary key(board_qna_id)
);

create table board_answer (
board_answer_id int not null auto_increment,
fk_board_qna_id int not null,
board_answer_writer varchar(20) not null,
board_answer_content text,
board_answer_regdate date,
primary key(board_answer_id),
foreign key(fk_board_qna_id) references board_qna(board_qna_id)
on update cascade
on delete cascade
);

create table files(
id int not null,
originalName varchar(255),
savedFileName varchar(255),
savedPathName varchar(255),
folderName varchar(10),
ext varchar(20)
);