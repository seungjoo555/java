# DB 생성
drop DATABASE IF EXISTS `music`;
CREATE DATABASE IF NOT EXISTS `music`;

# DB 선택
use `music`;

#유저 정보
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`user_id`	varchar(12)	NOT NULL primary key,
	`user_pw`	varchar(15)	NOT NULL,
	`user_nickname`	varchar(12)	NOT NULL,
	`user_email`	varchar(30)	NOT NULL,
	`user_birth`	datetime	NOT NULL,
	`user_state_date`	datetime	NOT NULL,	
	`user_role`	char(3)	NOT NULL	DEFAULT '사용자',
	`user_state`	varchar(3)	NOT NULL	DEFAULT '이용중'
);
#카테고리
DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`category_id`	int	NOT NULL primary key	AUTO_INCREMENT,
	`category_name`	varchar(10)	NOT NULL
);
#게시판
DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
	`board_id`	int	NOT NULL primary key	AUTO_INCREMENT,
	`board_name`	varchar(10)	NOT NULL,
	`board_category_num`	int	NOT NULL
);
#게시글
DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
	`post_id`	int	NOT NULL primary key	AUTO_INCREMENT,
	`post_board_num`	int	NOT NULL,
	`post_title`	varchar(50)	NOT NULL,
	`post_content`	text	NOT NULL,
	`post_date`	datetime	NOT NULL,
	`post_view`	int	NOT NULL	DEFAULT 0,
	`post_upvotes`	int	NOT NULL	DEFAULT 0,
	`post_reported`	int	NOT NULL	DEFAULT 0,
	`post_user_id`	varchar(12)	NOT NULL
);
#댓글
DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`comment_id`	int	NOT NULL primary key	AUTO_INCREMENT,
	`comment_user_id`	varchar(12)	NOT NULL,
	`comment_post_num`	int	NOT NULL,
	`comment_content`	text	NULL
);
#유저 상태(이용중, 이용정지, 탈퇴)
DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
	`state`	varchar(3)	NOT NULL	primary key DEFAULT '이용중'
);
#유저 권한(관리자, 운영자, 사용자)
DROP TABLE IF EXISTS `auth`;

CREATE TABLE `auth` (
	`role`	char(3)	NOT NULL primary key	DEFAULT '사용자'
);
#신고 상세 정보
DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
	`report_id`	int	NOT NULL primary key	AUTO_INCREMENT,
	`report_post_id`	int	NOT NULL,
	`report_reason`	varchar(30)	NOT NULL,
	`report_content`	varchar(100)	NULL,
	`report_date`	datetime	NOT NULL,
	`report_state`	varchar(10)	NOT NULL,
	`report_user_id`	varchar(12)	NOT NULL
);
#유저 차단 테이블
DROP TABLE IF EXISTS `blocked`;

CREATE TABLE `blocked` (
	`blocked_id`	int	NOT NULL primary key	AUTO_INCREMENT,
	`blocking_user_id`	varchar(12)	NOT NULL,
	`blocked_user_id`	varchar(12)	NOT NULL
);
#첨부파일, 주소 테이블
DROP TABLE IF EXISTS `attach`;

CREATE TABLE `attach` (
	`attach_num`	int	NOT NULL primary key	AUTO_INCREMENT,
	`attach_link_check`	int	NOT NULL	COMMENT '1이면 url 0이면 파일경로',
	`attach_path`	varchar(100)	NOT NULL,
	`attach_post_id`	int	NOT NULL
);
#좋아요 테이블
DROP TABLE IF EXISTS `upvote`;

CREATE TABLE `upvote` (
	`post_id`	int	NOT NULL,
	`user_id`	varchar(12)	NOT NULL,
	`upvote`	boolean	NOT NULL
);
#신고 처리 상태(처리중, 처리완료)
DROP TABLE IF EXISTS `report_state`;

CREATE TABLE `report_state` (
	`report_state`	varchar(10)	NOT NULL primary key
);
#신고 사유(욕설, 혐오, 기타, 그냥)
DROP TABLE IF EXISTS `report_reason`;

CREATE TABLE `report_reason` (
	`report_reason`	varchar(30)	NOT NULL primary key
);

#comment date 추가 
ALTER TABLE `comment`
ADD COLUMN `comment_date` datetime NOT NULL; 
#추천테이블 외래키
ALTER TABLE `upvote` ADD CONSTRAINT `FK_post_TO_upvote_1` FOREIGN KEY (
	`post_id`
)
REFERENCES `post` (
	`post_id`
);

ALTER TABLE `upvote` ADD CONSTRAINT `FK_user_TO_upvote_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `user` (
	`user_id`
);
#사용자테이블 외래키
ALTER TABLE `user` ADD CONSTRAINT `FK_state_TO_user_1` FOREIGN KEY (
	`user_state`
)
REFERENCES `state` (
	`state`
);

ALTER TABLE `user` ADD CONSTRAINT `FK_auth_TO_user_1` FOREIGN KEY (
	`user_role`
)
REFERENCES `auth` (
	`role`
);
#차단하는 사용자 외래키 (로그인한 유저)
ALTER TABLE `blocked` ADD CONSTRAINT `FK_user_TO_blocked_1` FOREIGN KEY (
	`blocking_user_id`
)
REFERENCES `user` (
	`user_id`
);
#차단 당하는 사용자 외래키(로그인한 유저가 차단하는 유저)
ALTER TABLE `blocked` ADD CONSTRAINT `FK_user_TO_blocked_2` FOREIGN KEY (
	`blocked_user_id`
)
REFERENCES `user` (
	`user_id`
);
#게시판테이블 외래키
ALTER TABLE `board` ADD CONSTRAINT `FK_category_TO_board_1` FOREIGN KEY (
	`board_category_num`
)
REFERENCES `category` (
	`category_id`
);
#게시글 테이블 외래키
ALTER TABLE `post` ADD CONSTRAINT `FK_board_TO_post_1` FOREIGN KEY (
	`post_board_num`
)
REFERENCES `board` (
	`board_id`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_user_TO_post_1` FOREIGN KEY (
	`post_user_id`
)
REFERENCES `user` (
	`user_id`
);
#댓글 테이블 외래키
ALTER TABLE `comment` ADD CONSTRAINT `FK_user_TO_comment_1` FOREIGN KEY (
	`comment_user_id`
)
REFERENCES `user` (
	`user_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_post_TO_comment_1` FOREIGN KEY (
	`comment_post_num`
)
REFERENCES `post` (
	`post_id`
);
#첨부파일테이블 외래키
ALTER TABLE `attach` ADD CONSTRAINT `FK_post_TO_attach_1` FOREIGN KEY (
	`attach_post_id`
)
REFERENCES `post` (
	`post_id`
);
#신고게시글테이블 외래키
ALTER TABLE `report` ADD CONSTRAINT `FK_post_TO_report_1` FOREIGN KEY (
	`report_post_id`
)
REFERENCES `post` (
	`post_id`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_report_reason_TO_report_1` FOREIGN KEY (
	`report_reason`
)
REFERENCES `report_reason` (
	`report_reason`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_report_state_TO_report_1` FOREIGN KEY (
	`report_state`
)
REFERENCES `report_state` (
	`report_state`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_user_TO_report_1` FOREIGN KEY (
	`report_user_id`
)
REFERENCES `user` (
	`user_id`
);



