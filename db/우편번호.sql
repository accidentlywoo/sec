-- building �÷����� '���б�'�� ������ ����� ��� ����Ͻÿ�
SELECT * FROM postal
WHERE building like '%���б�%'
;
SELECT 
    zipcode
    ,buildingno
    ,sido city
    ,doro
    ,building
FROM postal
WHERE building LIKE '%ȫ�ͱ�%'
OR doro || ' ' || building || building2 LIKE '%ȫ�ͱ�%'
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