
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

#유저 권한
INSERT INTO `music`.`auth` (`role`) VALUES ('관리자');
INSERT INTO `music`.`auth` (`role`) VALUES ('운영자');
INSERT INTO `music`.`auth` (`role`) VALUES ('사용자');

#유저 상태
INSERT INTO `music`.`state` (`state`) VALUES ('이용중');
INSERT INTO `music`.`state` (`state`) VALUES ('탈퇴중');
INSERT INTO `music`.`state` (`state`) VALUES ('정지중');

#asd123회원 추가
INSERT INTO `music`.`user` (`user_id`, `user_pw`, `user_nickname`, `user_email`, `user_birth`, `user_state_date`, `user_role`, `user_state`) 
VALUES ('asd123', 'asd123', '테스터', 'asd123@test.com', '2024-01-01', '2024-01-01', '사용자', '이용중');

#자유 게시판 게시글 추가
INSERT INTO `music`.`post` (`post_id`, `post_board_num`, `post_title`, `post_content`, `post_date`, `post_view`, `post_upvotes`, `post_reported`, `post_user_id`)
VALUES ('1', '3', '첫번째게시글', '첫번째', '2024-03-12', '0', '0', '0', 'asd123');