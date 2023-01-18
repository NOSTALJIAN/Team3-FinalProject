SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS board_reply;
DROP TABLE IF EXISTS like_board;
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS board_category;
DROP TABLE IF EXISTS mate_user;
DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS users_profile;
DROP TABLE IF EXISTS user_info;
DROP TABLE IF EXISTS users;




/* Create Tables */

CREATE TABLE board
(
	board_id int NOT NULL AUTO_INCREMENT,
	user_code int NOT NULL,
	exercise_category_id int DEFAULT 0 NOT NULL,
	board_title varchar(30) NOT NULL,
	board_content varchar(1024) NOT NULL,
	board_regTime datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
	board_viewCount int DEFAULT 0 NOT NULL,
	board_replyCount int DEFAULT 0 NOT NULL,
	board_location varchar(50) NOT NULL,
	PRIMARY KEY (board_id)
);


CREATE TABLE board_category
(
	exercise_category_id int NOT NULL AUTO_INCREMENT,
	category_name varchar(10) NOT NULL,
	PRIMARY KEY (exercise_category_id)
);


CREATE TABLE board_reply
(
	reply_id int NOT NULL AUTO_INCREMENT,
	board_id int NOT NULL,
	user_code int NOT NULL,
	reply_content varchar(300) NOT NULL,
	reply_regTime datetime DEFAULT (CURRENT_TIMESTAMP) NOT NULL,
	reply_origin_number int DEFAULT 0 NOT NULL,
	reply_order int DEFAULT 0 NOT NULL,
	reply_isMine int DEFAULT 0 NOT NULL,
	PRIMARY KEY (reply_id)
);


CREATE TABLE like_board
(
	board_id int NOT NULL,
	user_code int NOT NULL
);


CREATE TABLE mate_user
(
	send_user int NOT NULL,
	receive_user int NOT NULL,
	send_time datetime DEFAULT (CURRENT_TIMESTAMP) NOT NULL,
	mate_state int DEFAULT 0 NOT NULL
);


CREATE TABLE message
(
	send_user_id int NOT NULL,
	recieve_user_id int NOT NULL,
	message_title varchar(30) NOT NULL,
	message_content varchar(500) NOT NULL,
	message_regTime datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
	message_confirm int DEFAULT 0 NOT NULL
);


CREATE TABLE users
(
	user_code int NOT NULL AUTO_INCREMENT,
	user_id varchar(20) NOT NULL,
	user_pwd char(60) NOT NULL,
	user_name varchar(10) NOT NULL,
	user_phone varchar(20) NOT NULL,
	user_email varchar(40) NOT NULL,
	user_nickname varchar(10) NOT NULL,
	user_addr varchar(50) NOT NULL,
	email_check int DEFAULT 0 NOT NULL,
	user_role int DEFAULT 0 NOT NULL,
	user_regDate date DEFAULT (CURRENT_DATE) NOT NULL,
	PRIMARY KEY (user_code),
	UNIQUE (user_id),
	UNIQUE (user_email),
	UNIQUE (user_nickname)
);


CREATE TABLE users_profile
(
	user_code int NOT NULL,
	user_image varchar(300),
	user_grade varchar(10) DEFAULT 'BRONZE' NOT NULL
);


CREATE TABLE user_info
(
	user_code int NOT NULL,
	user_rating float(3,2) unsigned zerofill DEFAULT 3 NOT NULL,
	user_location varchar(50) NOT NULL,
	user_like_exercise int DEFAULT 0 NOT NULL,
	user_age date NOT NULL,
	user_gender varchar(4) NOT NULL,
	exercise_level_high int DEFAULT 0 NOT NULL,
	exercise_level_middle int DEFAULT 0 NOT NULL,
	exercise_level_low int DEFAULT 0 NOT NULL
);



/* Create Foreign Keys */

ALTER TABLE board_reply
	ADD FOREIGN KEY (board_id)
	REFERENCES board (board_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE like_board
	ADD FOREIGN KEY (board_id)
	REFERENCES board (board_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board
	ADD FOREIGN KEY (exercise_category_id)
	REFERENCES board_category (exercise_category_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board
	ADD FOREIGN KEY (user_code)
	REFERENCES users (user_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board_reply
	ADD FOREIGN KEY (user_code)
	REFERENCES users (user_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE like_board
	ADD FOREIGN KEY (user_code)
	REFERENCES users (user_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE mate_user
	ADD FOREIGN KEY (receive_user)
	REFERENCES users (user_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE mate_user
	ADD FOREIGN KEY (send_user)
	REFERENCES users (user_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE message
	ADD FOREIGN KEY (send_user_id)
	REFERENCES users (user_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE message
	ADD FOREIGN KEY (recieve_user_id)
	REFERENCES users (user_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE users_profile
	ADD FOREIGN KEY (user_code)
	REFERENCES users (user_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user_info
	ADD FOREIGN KEY (user_code)
	REFERENCES users (user_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



