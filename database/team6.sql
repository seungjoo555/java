DROP DATABASE IF EXISTS `team6`;
CREATE 	DATABASE IF NOT EXISTS `team6`;

use `team6`;

DROP TABLE IF EXISTS `member`;

CREATE TABLE IF NOT EXISTS`member` (
	`me_id`	varchar(15)	primary key NOT NULL,
    `me_pw`	varchar(20)	NOT NULL,
	`me_email`	varchar(30)	NOT NULL,
    `me_authority` varchar(5) NOT NULL DEFAULT 'USER',
	`me_address`	varchar(30)	NOT NULL,
	`me_phoneNum`	varchar(11)	NOT NULL,
    `me_name`	varchar(30)	NOT NULL
);