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
primary key(board_qna_id)
);