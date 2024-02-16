use team6;

ALTER TABLE `member` 
ADD COLUMN `me_ms_state` VARCHAR(10) NOT NULL AFTER `me_name`;

DROP TABLE IF EXISTS `member_state`;

CREATE TABLE `member_state` (
	`ms_state`	varchar(10)	primary key
);

ALTER TABLE `member` ADD CONSTRAINT `FK_member_state_TO_member_1` FOREIGN KEY (
	`me_ms_state`
)
REFERENCES `member_state` (
	`ms_state`
);

insert into member_state values('가입요청'), ('회원'), ('이용정지'),('관리자');