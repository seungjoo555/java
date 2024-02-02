/* 여러줄 주석
*/

# 데이터베이스 삭제(있으면)
drop database if exists `test`;
# drop schema if exists test;

# 데이터베이스 추가(없으면)
create database if not exists test;
# create schema if not exists `test`;

use test;

# 테이블 삭제
drop table if exists member;

# 테이블 생성
create table if not exists member(
	id varchar(13) primary key,
    pw varchar(15) not null,
    email varchar(30) not null unique
);
desc member;
DROP TABLE IF EXISTS BOARD;
create table if not exists board(
	num int auto_increment,
    title varchar(50) not null,
    content longtext not null,
    view int not null default 0,
    ID VARCHAR(13) NOT NULL,
    PRIMARY KEY(NUM),
    FOREIGN KEY(ID) REFERENCES MEMBER(ID)
);
DESC BOARD;

use test;

# member 테이블에 가입일 컬럼을 추가
alter table member add date datetime not null;
# member 테이블에 가입일을 의미하는 DATE를 REG_DATE로 변경
ALTER TABLE `MEMBER` CHANGE `DATE` `REG_DATE` DATETIME NOT NULL;
# MEMBER 테이블에 불필요한 컬럼 COUNT를 추가
ALTER TABLE `MEMBER` ADD `COUNT` INT NOT NULL;
# MEMBER TABLE에서 COUNT 컬럼을 삭제
ALTER TABLE `MEMBER` DROP `COUNT`;

