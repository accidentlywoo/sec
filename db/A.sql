show user;

-- CUSTOMER SELECT ���� �޾ƿ�.
-- SELECT * FROM CUSTOMER; ��ȸ �ȴ�
SELECT * FROM test.CUSTOMER;

-- pravate �ó�� �����
CREATE SYNONYM tc FOR test.customer;

SELECT * FROM tc;

-- ���� �ó�� �����
CREATE PUBLIC SYNONYM ptc FOR test.customer;

SELECT * FROM ptc;