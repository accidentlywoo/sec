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

-- �ֹ����� �߰��ϱ�
INSERT INTO order_info 
VALUES(order_seq.NEXTVAL,'id3' , SYSDATE)
;
-- NEXTVAL�� ȣ���ؼ� ����� ���� ROLLBACK�� �ص� �������� �ʴ´�.
INSERT INTO order_line 
VALUES(order_seq.CURRVAL,'C0001' , 1)
;
select * from order_info;
select * from order_line;
COMMIT;