-- Ʈ���� �׽�Ʈ
-- �ֹ��⺻����(order_info)�� �߰��Ǹ� �ڵ� POINT(point)�� 1�� �����ȴ�.
INSERT INTO order_info(order_no, order_id, order_dt)
VALUES (ORDER_SEQ.nextval, 'id1', SYSDATE);

SELECT * FROM order_info;
SELECT * FROM point;

-- �ֹ� Ʈ�����
-- 1) �ֹ��⺻���� �߰�
----  2) ����Ʈ���� ���� : �ڵ�
-- 3) �ֹ������� �߰�
INSERT INTO order_line(order_no, order_prod_no, order_quantity)
VALUES(ORDER_SEQ.CURRVAL, 'C0001', 1);

commit;

select * FROM order_line;