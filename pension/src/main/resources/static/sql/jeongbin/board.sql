create table board_notice (
board_notice_id int not null auto_increment,
board_notice_subject varchar(50) not null,
fk_board_notice_writer varchar(20) not null,
board_notice_content text,
board_notice_regdate datetime,
board_notice_visit int,
board_notice_grp int,
board_notice_seq int,
board_notice_depth int,
primary key(board_notice-id)
);