
# 카테고리
INSERT INTO `music`.`category` (`category_name`) VALUES ('없음');
INSERT INTO `music`.`category` (`category_name`) VALUES ('일반카테고리');
INSERT INTO `music`.`category` (`category_name`) VALUES ('음악카테고리');
INSERT INTO `music`.`category` (`category_name`) VALUES ('QnA');

#게시판
INSERT INTO `music`.`board` (`board_name`, `board_category_num`) VALUES ('공지게시판', '1');
INSERT INTO `music`.`board` (`board_name`, `board_category_num`) VALUES ('전체게시판', '1');
INSERT INTO `music`.`board` (`board_name`, `board_category_num`) VALUES ('자유게시판', '2');
INSERT INTO `music`.`board` (`board_name`, `board_category_num`) VALUES ('홍보게시판', '2');
INSERT INTO `music`.`board` (`board_name`, `board_category_num`) VALUES ('정보게시판', '2');
INSERT INTO `music`.`board` (`board_name`, `board_category_num`) VALUES ('음악추천', '3');
INSERT INTO `music`.`board` (`board_name`, `board_category_num`) VALUES ('장르추천', '3');
INSERT INTO `music`.`board` (`board_name`, `board_category_num`) VALUES ('질문하기', '4');
INSERT INTO `music`.`board` (`board_name`, `board_category_num`) VALUES ('건의사항', '4');