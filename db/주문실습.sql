-- ��ǰ ��Ϻ���
SELECT prod_no, prod_name, prod_price
FROM product
;

-- 1 �������� �ش��ϴ� ��ǰ��Ϻ��� (�������� 3�Ǿ�, ��ǰ ��ȣ������ ��������)
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
-- 2 ��������
SELECT *
FROM (SELECT ROWNUM list, a.*
        FROM (SELECT * FROM product ORDER BY prod_no) a)-- ������ ���⼭ ����
WHERE list BETWEEN 4 AND 6
;
-- ��ǰ�� ��ǰ��ȣ�� �˻��ϱ�
SELECT *
FROM product
WHERE prod_no='C0001'
;

-- ��ǰ�� ��ǰ��ȣ�� ù���ڰ� 'C'�� ��ǰ���� �˻��ϱ�
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
;-- ���� �����ڸ� ����ϴ� ���� ���ɿ� ����.

-- ��ǰ�� ��ǰ������ �˻��ϱ�
SELECT *
FROM product
WHERE prod_name LIKE '%�Ƹ�%'
ORDER BY prod_name ASC
;
-- �ֹ� �⺻������ ����Ͻÿ�
SELECT *
FROM order_info
;

-- �ֹ� �������� ����Ͻÿ�
SELECT *
FROM order_line
;

-- �ֹ� �⺻������ �������� �˻��ϱ�
SELECT * 
FROM order_info oi
    JOIN order_line ol
    ON(oi.order_no = ol.order_no)
;    

-- �ֹ���ȣ, �ֹ���ID, �ֹ�����, �ֹ��Ȼ�ǰ��ȣ, �ֹ������� ����Ѵ�.
SELECT oi.order_no, oi.order_id, oi.order_dt, ol.order_prod_no, ol.order_quantity 
FROM order_info oi
    JOIN order_line ol
    ON(oi.order_no = ol.order_no)
ORDER BY oi.order_no desc
; 

-- 'id1' ���� �ֹ��� �ֹ��⺻������ �������� �˻��ϱ�
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

-- �ֹ��� ��ǰ ����� ����Ͻÿ�(��ǰ��ȣ, ��ǰ��, �ֹ���ȣ, �ֹ�����)
-- ��, �ֹ����� ���� ��ǰ�� ����Ѵ�.
SELECT
    p.prod_no
    , p.prod_name
    , ol.order_no
    , ol.order_quantity
FROM order_line ol
    RIGHT OUTER JOIN product p
    ON(ol.order_prod_no = p.prod_no)  
;

-- ��ǰ�� �ֹ������� ���� ���Ͻÿ�(��ǰ��ȣ, �ֹ����� ��)
-- ���� ���� �Ǹŵ� ��ǰ������ ���
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

-- ��ǰ�� �ֹ������� ���� ���Ͻÿ�(��ǰ��ȣ, �ֹ����� ��)
-- ���� ���� �Ǹŵ� ��ǰ������ ���
-- �ֹ����ڰ� 20/06/08�� �ֹ���
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

-- �ֹ����� �ʴ� ��ǰ��ȣ�� ���
SELECT p.prod_no
FROM product p
MINUS
SELECT order_prod_no
FROM order_line
;
 -- ���տ���� �÷� ������ ������� �Ѵ�.
SELECT *
FROM product
WHERE prod_no IN
    (SELECT p.prod_no
        FROM product p
    MINUS
    SELECT order_prod_no 
        FROM order_line)
;