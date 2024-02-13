CREATE USER 'seungjoo'@'%' IDENTIFIED BY 'root'; # 사용자 추가

SET PASSWORD FOR 'seungjoo'@'%' = '1234'; # 사용자 비번 변경

DROP USER 'seungjoo'@'%'; # 사용자 삭제

SELECT User, Host FROM mysql.user;

# 권한 부여 : GRANT 권한종류 ON DB명.테이블명 TO '계정아이디'@'호스트명';
GRANT ALL PRIVILEGES ON `SHOPPINGMALL`.PRODUCT TO 'seungjoo'@'%';

# 권한 제거 : REVOKE 권한 종류 ON DB명.테이블명 FROM '계정아이디'@'호스트명';
REVOKE ALL PRIVILEGES ON `SHOPPINGMALL`.PRODUCT FROM 'seungjoo'@'%';

GRANT ALL PRIVILEGES ON `SHOPPINGMALL`.* TO 'seungjoo'@'%';
