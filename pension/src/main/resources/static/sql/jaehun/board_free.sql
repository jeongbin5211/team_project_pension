CREATE TABLE board_free (
    board_free_num INT AUTO_INCREMENT,
    board_free_subject VARCHAR(30) NOT NULL,
    board_free_writer VARCHAR(30) NOT NULL,
    board_free_passwd varchar(20) NOT NULL,
    board_free_content text,
    board_free_regdate DATE,

    PRIMARY KEY (board_free_num)
);