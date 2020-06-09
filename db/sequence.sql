CREATE SEQUENCE order_seq
START WITH 3
INCREMENT BY 2
MAXVALUE 40
MINVALUE 1
CYCLE;

SELECT order_seq.NEXTVAL
    , order_seq.CURRVAL
FROM dual;

DROP SEQUENCE order_seq;

CREATE SEQUENCE order_seq
START WITH 3;

-- 주문정보 추가하기
INSERT INTO order_info 
VALUES(order_seq.NEXTVAL,'id3' , SYSDATE)
;
-- NEXTVAL을 호출해서 변경된 값은 ROLLBACK을 해도 복원되지 않는다.
INSERT INTO order_line 
VALUES(order_seq.CURRVAL,'C0001' , 1)
;
select * from order_info;
select * from order_line;
COMMIT;