-- 상품 목록보기
SELECT prod_no, prod_name, prod_price
FROM product
;

-- 1 페이지에 해당하는 상품목록보기 (페이지당 3건씩, 상품 번호순으로 오름차순)
SELECT prod_no, prod_name, prod_price
FROM product
WHERE ROWNUM <= 3
ORDER BY prod_no desc
;

SELECT *
FROM (SELECT ROWNUM list, a.*
        FROM (SELECT * FROM product ORDER BY prod_no) a)
WHERE list BETWEEN 1 AND 3
;
-- 2 페이지에
SELECT *
FROM (SELECT ROWNUM list, a.*
        FROM (SELECT * FROM product ORDER BY prod_no) a)-- 조건을 여기서 주자
WHERE list BETWEEN 4 AND 6
;
-- 상품을 상품번호로 검색하기
SELECT *
FROM product
WHERE prod_no='C0001'
;

-- 상품을 상품번호의 첫문자가 'C'인 상품들을 검색하기
SELECT *
FROM product
WHERE prod_no like 'C%'
;

SELECT INSTR(prod_no, 'C'),prod_no, prod_name, prod_price
FROM product
;
SELECT *
FROM product
WHERE INSTR(prod_no, 'C') = 1
;

SELECT *
FROM product
WHERE SUBSTR(prod_no, 1, 1) = 'C'
;-- 문자 연산자를 사용하는 것이 성능에 좋다.

-- 상품을 상품명으로 검색하기
SELECT *
FROM product
WHERE prod_name LIKE '%아메%'
ORDER BY prod_name ASC
;
-- 주문 기본정보를 출력하시오
SELECT *
FROM order_info
;

-- 주문 상세정보를 출력하시오
SELECT *
FROM order_line
;

-- 주문 기본정보와 상세정보를 검색하기
SELECT * 
FROM order_info oi
    JOIN order_line ol
    ON(oi.order_no = ol.order_no)
;    

-- 주문번호, 주문자ID, 주문일자, 주문된상품번호, 주문수량을 출력한다.
SELECT oi.order_no, oi.order_id, oi.order_dt, ol.order_prod_no, ol.order_quantity 
FROM order_info oi
    JOIN order_line ol
    ON(oi.order_no = ol.order_no)
ORDER BY oi.order_no desc
; 

-- 'id1' 고객이 주문한 주문기본정보와 상세정보를 검색하기
SELECT oi.order_no, oi.order_id, oi.order_dt, ol.order_prod_no, ol.order_quantity 
FROM order_info oi
    JOIN order_line ol
    ON(oi.order_no = ol.order_no)
WHERE oi.order_id = 'id1'    
ORDER BY oi.order_no desc
;

-- 
SELECT 
      oi.order_no
    , oi.order_id
    , oi.order_dt
    , ol.order_prod_no
    , ol.order_quantity 
    , p.prod_name
    , p.prod_no
    , p.prod_price
    , p.prod_price * ol.order_quantity as total
FROM order_info oi
    JOIN order_line ol
    ON(oi.order_no = ol.order_no)
    JOIN product p
    ON(ol.order_prod_no = p.prod_no)
WHERE oi.order_id = 'id1'    
ORDER BY oi.order_no desc
;
-- order_no order_id order_dt order_prod_no order_quantity

-- 주문된 상품 목록을 출력하시오(상품번호, 상품명, 주문번호, 주문수량)
-- 단, 주문되지 않은 상품도 출력한다.
SELECT
    p.prod_no
    , p.prod_name
    , ol.order_no
    , ol.order_quantity
FROM order_line ol
    RIGHT OUTER JOIN product p
    ON(ol.order_prod_no = p.prod_no)  
;

-- 상품별 주문수량의 합을 구하시오(상품번호, 주문수량 합)
-- 가장 많이 판매된 상품순으로 출력
SELECT   
    p.prod_no
    , SUM(ol.order_quantity)
FROM order_line ol
    RIGHT OUTER JOIN product p
    ON(ol.order_prod_no = p.prod_no)
    GROUP BY p.prod_no
-- ORDER BY SUM(ol.order_quantity) DESC  
 ORDER BY 2 DESC  
;

-- 상품별 주문수량의 합을 구하시오(상품번호, 주문수량 합)
-- 가장 많이 판매된 상품순으로 출력
-- 주문일자가 20/06/08인 주문중
SELECT TO_CHAR(TO_DATE(order_dt), 'YY/MM/DD HH24:MI:SS')
FROM order_info
--WHERE order_dt >='20/06/08' AND order_dt <'20/06/09'
WHERE order_dt = '20/06/08'
;

SELECT order_prod_no, SUM(order_quantity)
FROM order_line
WHERE order_no IN (SELECT order_no FROM order_info 
                    WHERE order_dt = '20/06/08' )
GROUP BY order_prod_no
ORDER BY 2 DESC
;

-- 주문되지 않는 상품번호를 출력
SELECT p.prod_no
FROM product p
MINUS
SELECT order_prod_no
FROM order_line
;
 -- 집합연산시 컬럼 갯수를 맞춰줘야 한다.
SELECT *
FROM product
WHERE prod_no IN
    (SELECT p.prod_no
        FROM product p
    MINUS
    SELECT order_prod_no 
        FROM order_line)
;