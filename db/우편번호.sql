-- building 컬럼값에 '대학교'를 포함한 행들을 모두 출력하시오
SELECT * FROM postal
WHERE building like '%대학교%'
;
SELECT 
    zipcode
    ,buildingno
    ,sido city
    ,doro
    ,building
FROM postal
WHERE building LIKE '%홍익길%'
OR doro || ' ' || building || building2 LIKE '%홍익길%'
;

SELECT * FROM order_info
;
select * from order_line
;
select * from product
;
select * from order_info
;
select * from product;

INSERT INTO order_info VALUES(ORDER_SEQ.nextval, 'id1', SYSDATE);
INSERT INTO order_line VALUES(ORDER_SEQ.currval, 'C0001', 1);
ROLLBACK;