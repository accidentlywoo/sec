SET SERVEROUTPUT ON; -- 세션에서 스크립트 출력 부분에 출력되게 해줌 Default : off
execute P1(1, 2); -- 변수 선언 및 사용

-- IF
EXECUTE p2(88);

-- LOOP
EXECUTE p3;

-- CURSOR : 여러행 SELECT
EXECUTE p4cursor;
----------------------------------------------
-- 고객이 주문하면 포인트점수가 누적된다.

CREATE TABLE POINT(
    point_id VARCHAR2(10),
    point_score NUMBER(4)
);
ALTER TABLE POINT
ADD CONSTRAINT point_id_pk PRIMARY KEY(point_id);

ALTER TABLE POINT
ADD CONSTRAINT point_score_check CHECK(point_score>=0)
;

ALTER TABLE POINT
MODIFY point_score NOT NULL  -- COLUMN LEVEL : NOT NULL 제약조건은 COLUMN제약조건만 사용가능
;

ALTER TABLE POINT
MODIFY point_score DEFAULT 0
;
ALTER TABLE POINT
ADD CONSTRAINT point_id_fk FOREIGN KEY(point_id) REFERENCES customer(ID);

SELECT * FROM customer;
SELECT * FROM point;

DELETE order_line;
DELETE order_info;
DELETE customer;
COMMIT;

-- p_insert_customer 프로시저를 실행하면 고객 테이블에 행이 추가되고
-- 포인트테이블에도 행이 추가된다
EXEC p_insert_customer('id1','p1','n3');

SELECT * FROM customer;
SELECT * FROM point;

