SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS add_mate;
DROP TABLE IF EXISTS board_reply;
DROP TABLE IF EXISTS like_board;
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS board_category;
DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS user_info;
DROP TABLE IF EXISTS user_profile;
DROP TABLE IF EXISTS user_relationship;
DROP TABLE IF EXISTS user;




/* Create Tables */

CREATE TABLE add_mate
(
	uid varchar(20) NOT NULL,
	receive_user varchar(20) NOT NULL,
	send_time datetime DEFAULT (CURRENT_TIMESTAMP) NOT NULL,
	mate_state int DEFAULT 0 NOT NULL
);


CREATE TABLE board
(
	bid int NOT NULL AUTO_INCREMENT,
	uid varchar(20) NOT NULL,
	exercise_category_id int DEFAULT 0 NOT NULL,
	b_title varchar(30) NOT NULL,
	b_content varchar(1024) NOT NULL,
	b_regTime datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
	b_viewCount int DEFAULT 0 NOT NULL,
	b_replyCount int DEFAULT 0 NOT NULL,
	b_location varchar(50) NOT NULL,
	isDeleted int DEFAULT 0 NOT NULL,
	PRIMARY KEY (bid)
);


CREATE TABLE board_category
(
	exercise_category_id int NOT NULL AUTO_INCREMENT,
	category_name varchar(10) NOT NULL,
	PRIMARY KEY (exercise_category_id)
);


CREATE TABLE board_reply
(
	r_id int NOT NULL AUTO_INCREMENT,
	bid int NOT NULL,
	uid varchar(20) NOT NULL,
	r_content varchar(300) NOT NULL,
	r_regTime datetime DEFAULT (CURRENT_TIMESTAMP) NOT NULL,
	r_origin_number int DEFAULT 0 NOT NULL,
	r_order int DEFAULT 0 NOT NULL,
	r_isMine int DEFAULT 0 NOT NULL,
	PRIMARY KEY (r_id)
);


CREATE TABLE like_board
(
	bid int NOT NULL,
	uid varchar(20) NOT NULL
);


CREATE TABLE message
(
	send_user_id varchar(20) NOT NULL,
	recieve_user_id varchar(20) NOT NULL,
	m_title varchar(30) NOT NULL,
	m_content varchar(500) NOT NULL,
	m_regTime datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
	m_confirm int DEFAULT 0 NOT NULL
);


CREATE TABLE user
(
	uid varchar(20) NOT NULL,
	pwd char(60) NOT NULL,
	uname varchar(10) NOT NULL,
	phoneNum varchar(20) NOT NULL,
	nickname varchar(10) NOT NULL,
	email varchar(40) NOT NULL,
	email_check int DEFAULT 0 NOT NULL,
	role int DEFAULT 0 NOT NULL,
	u_regDate date DEFAULT (CURRENT_DATE) NOT NULL,
	isDeleted int DEFAULT 0 NOT NULL,
	PRIMARY KEY (uid),
	UNIQUE (uid),
	UNIQUE (phoneNum),
	UNIQUE (nickname),
	UNIQUE (email)
);


CREATE TABLE user_info
(
	uid varchar(20) NOT NULL,
	u_addr varchar(50) NOT NULL,
	like_exercise int DEFAULT 0 NOT NULL,
	birth_date int NOT NULL,
	gender varchar(4) NOT NULL,
	u_rating float(3,2) unsigned zerofill DEFAULT 3 NOT NULL
);


CREATE TABLE user_profile
(
	uid varchar(20) NOT NULL,
	u_image varchar(300),
	grade varchar(10) DEFAULT 'BRONZE' NOT NULL,
	level_high int DEFAULT 0 NOT NULL,
	level_middle int DEFAULT 0,
	level_low int DEFAULT 0 NOT NULL
);


CREATE TABLE user_relationship
(
	uid varchar(20) NOT NULL,
	user_code_2 varchar(20) NOT NULL,
	rrelationship int DEFAULT 0 NOT NULL
);



/* Create Foreign Keys */

ALTER TABLE board_reply
	ADD FOREIGN KEY (bid)
	REFERENCES board (bid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE like_board
	ADD FOREIGN KEY (bid)
	REFERENCES board (bid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board
	ADD FOREIGN KEY (exercise_category_id)
	REFERENCES board_category (exercise_category_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE add_mate
	ADD FOREIGN KEY (uid)
	REFERENCES user (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE add_mate
	ADD FOREIGN KEY (receive_user)
	REFERENCES user (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board
	ADD FOREIGN KEY (uid)
	REFERENCES user (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board_reply
	ADD FOREIGN KEY (uid)
	REFERENCES user (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE like_board
	ADD FOREIGN KEY (uid)
	REFERENCES user (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE message
	ADD FOREIGN KEY (send_user_id)
	REFERENCES user (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE message
	ADD FOREIGN KEY (recieve_user_id)
	REFERENCES user (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user_info
	ADD FOREIGN KEY (uid)
	REFERENCES user (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user_profile
	ADD FOREIGN KEY (uid)
	REFERENCES user (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user_relationship
	ADD FOREIGN KEY (user_code_2)
	REFERENCES user (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user_relationship
	ADD FOREIGN KEY (uid)
	REFERENCES user (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



