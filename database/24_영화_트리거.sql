
USE MOVIE;

# 상영관에 좌석이 추가되면 상영관 전체 좌석수와 영화관 전체 좌석수를 업데이트하는 트리거
# SEAT 테이블에 좌석이 추가되면, SCREEN 테이블과 THEATER 테이블의 좌석수를 수정하는 트리거
DROP TRIGGER IF EXISTS INSERT_SEAT;
DELIMITER //
CREATE TRIGGER INSERT_SEAT AFTER INSERT ON SEAT
FOR EACH ROW
BEGIN
	DECLARE _SC_NUM INT;
    DECLARE _SC_SEAT INT;
    DECLARE _TH_NUM INT;
    DECLARE _TH_SEAT INT;
    # 상영관 번호
    SET _SC_NUM = NEW.SE_SC_NUM;
    # 상영관에 있는 전체 좌석수 계산 
    SET _SC_SEAT = (SELECT COUNT(*) FROM SEAT WHERE SE_SC_NUM = _SC_NUM);
    # 상영관에 있는 전체 좌석수를 업데이트
    UPDATE SCREEN SET SC_SEAT = _SC_SEAT WHERE SC_NUM = _SC_NUM;
    
    # 영화관 번호
    SET _TH_NUM = (SELECT SC_TH_NUM FROM SCREEN WHERE SC_NUM = _SC_NUM);
    # 영화관 전체 좌석 수
    SET _TH_SEAT = (SELECT 
						COUNT(*)
					FROM
						SEAT
					WHERE
						SE_SC_NUM IN (SELECT 
										SC_NUM
									FROM
										SCREEN
									WHERE
										SC_TH_NUM = _TH_NUM));
    # 영화관에 있는 전체 좌석수를 업데이트
    UPDATE THEATER SET TH_SEAT = _TH_SEAT WHERE TH_NUM = _TH_NUM;
END //
DELIMITER ;

# 상영관이 추가되면 영화관의 전체 상영관수를 업데이트하는 트리거
DROP TRIGGER IF EXISTS INSERT_SCREEN;
DELIMITER //
CREATE TRIGGER INSERT_SCREEN AFTER INSERT ON SCREEN
FOR EACH ROW
BEGIN
	DECLARE _TH_NUM INT;
    DECLARE _TH_SCREEN INT;
    
    # 영화관 번호
    SET _TH_NUM = NEW.SC_TH_NUM;
    # 영화관에 있는 전체 상영관수 계산
    SET _TH_SCREEN = (SELECT COUNT(*) FROM SCREEN WHERE SC_TH_NUM = _TH_NUM);
    
    # 영화관에 있는 전체 좌석수를 업데이트
    UPDATE THEATER SET TH_SCREEN = _TH_SCREEN WHERE TH_NUM = _TH_NUM;
END //
DELIMITER ;

# INSERT INTO SCREEN(SC_NAME, SC_SEAT, SC_TH_NUM) VALUES(4, 0, 1);



