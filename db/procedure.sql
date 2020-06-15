SET SERVEROUTPUT ON; -- ���ǿ��� ��ũ��Ʈ ��� �κп� ��µǰ� ���� Default : off
execute P1(1, 2); -- ���� ���� �� ���

-- IF
EXECUTE p2(88);

-- LOOP
EXECUTE p3;

-- CURSOR : ������ SELECT
EXECUTE p4cursor;
----------------------------------------------
-- ���� �ֹ��ϸ� ����Ʈ������ �����ȴ�.

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
MODIFY point_score NOT NULL  -- COLUMN LEVEL : NOT NULL ���������� COLUMN�������Ǹ� ��밡��
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

-- p_insert_customer ���ν����� �����ϸ� �� ���̺� ���� �߰��ǰ�
-- ����Ʈ���̺��� ���� �߰��ȴ�
EXEC p_insert_customer('id1','p1','n3');

SELECT * FROM customer;
SELECT * FROM point;

