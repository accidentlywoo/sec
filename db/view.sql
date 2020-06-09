SELECT * FROM user_tables;
SELECT * FROM user_constraints;

SELECT id, name
FROM customer;

--system �������� �α���
-- GRANT CREATE VIEW to test;
--�ܼ���
CREATE VIEW customer_1_vu
AS SELECT id, name
FROM customer;

CREATE OR REPLACE VIEW customer_1_vu
AS SELECT id, name
FROM customer;

SELECT * FROM customer_1_vu;

-- ���պ丸���
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
        , TO_CHAR(TO_DATE(o.order_dt), 'YY/MM/DD HH24:MI:SS') "dt" --�信�� �Լ����� �ݵ�� ��Ī ���
    FROM order_info o
        JOIN customer c
        ON (o.order_id = c.id)
;

-- �� �÷� ��Ī�ִ� ��� 2
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

DESC customer_1_vu; -- �ܼ��� : DML ó�� ����

DESC order_info_1_vu;-- ���պ� : DML ó�� ����