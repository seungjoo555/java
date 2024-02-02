# 쇼핑몰 데이터베이스 삭제 후 추가
drop database if exists shoppingmall;
create database if not exists shoppingmall;

use shoppingmall;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(13)	primary key,
	`me_pw`	varchar(20) not	NULL,
	`me_email`	varchar(30) not	NULL,
	`me_phone`	varchar(13) not	NULL,
	`me_authority`	varchar(10) not null default  "user",
	`me_try_count`	int not null default 0
);

DROP TABLE IF EXISTS `certification`;

CREATE TABLE `certification` (
	`ce_num`	int	primary key,
	`ce_code`	char(6) not	NULL,
	`ce_limit`	datetime not NULL,
	`ce_me_id`	varchar(13)	NOT NULL
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`pr_code`	varchar(15)	primary key,
	`pr_title`	varchar(50) not	NULL,
	`pr_content`	text not NULL,
	`pr_price`	int not null default 0,
	`pr_ca_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`ca_num`	int	primary key,
	`ca_name`	varchar(10) not	NULL
);

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
	`or_num`	int	primary key auto_increment,
	`or_date`	datetime not null default current_timestamp,
	`or_state`	varchar(10) not null default "결제완료",
	`or_amount`	int not null default 0,
	`or_total_price`	int not	NULL,
	`or_me_id`	varchar(13)	NOT NULL,
	`or_pr_code`	varchar(15)	NOT NULL
);

DROP TABLE IF EXISTS `basket`;

CREATE TABLE `basket` (
	`ba_num`	int	primary key auto_increment,
	`ba_amount`	int not null default 0,
	`ba_me_id`	varchar(13)	NOT NULL,
	`ba_pr_code`	varchar(15)	NOT NULL
);

DROP TABLE IF EXISTS `image`;

CREATE TABLE `image` (
	`im_num`	int	primary key auto_increment,
	`im_file`	varchar(50) not	NULL,
	`im_pr_code`	varchar(15)	NOT NULL
);

ALTER TABLE `certification` ADD CONSTRAINT `FK_member_TO_certification_1` FOREIGN KEY (
	`ce_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `product` ADD CONSTRAINT `FK_category_TO_product_1` FOREIGN KEY (
	`pr_ca_num`
)
REFERENCES `category` (
	`ca_num`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_member_TO_order_1` FOREIGN KEY (
	`or_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_product_TO_order_1` FOREIGN KEY (
	`or_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_member_TO_basket_1` FOREIGN KEY (
	`ba_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_product_TO_basket_1` FOREIGN KEY (
	`ba_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `image` ADD CONSTRAINT `FK_product_TO_image_1` FOREIGN KEY (
	`im_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

