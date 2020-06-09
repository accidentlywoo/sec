SELECT * FROM user_tables;
SELECT * FROM user_constraints;

SELECT id, name
FROM customer;

--system 계정으로 로그인
-- GRANT CREATE VIEW to test;
--단순뷰
CREATE VIEW customer_1_vu
AS SELECT id, name
FROM customer;

CREATE OR REPLACE VIEW customer_1_vu
AS SELECT id, name
FROM customer;

SELECT * FROM customer_1_vu;

-- 복합뷰만들기
SELECT 
      o.order_no
    , o.order_id
    , c.name
    , o.order_dt
FROM order_info o
    JOIN customer c
    ON (o.order_id = c.id)
;

CREATE OR REPLACE VIEW order_info_1_vu
AS SELECT 
          o.order_no "no"
        , o.order_id "id"
        , c.name
        , TO_CHAR(TO_DATE(o.order_dt), 'YY/MM/DD HH24:MI:SS') "dt" --뷰에서 함수사용시 반드시 별칭 사용
    FROM order_info o
        JOIN customer c
        ON (o.order_id = c.id)
;

-- 뷰 컬럼 별칭주는 방법 2
CREATE OR REPLACE VIEW order_info_1_vu(no,id,name,dt)
AS SELECT 
          o.order_no 
        , o.order_id 
        , c.name
        , TO_CHAR(TO_DATE(o.order_dt), 'YY/MM/DD HH24:MI:SS') 
    FROM order_info o
        JOIN customer c
        ON (o.order_id = c.id)
;
SELECT * FROM order_info_1_vu;

DESC customer_1_vu; -- 단순뷰 : DML 처리 간편

DESC order_info_1_vu;-- 복합뷰 : DML 처리 불편