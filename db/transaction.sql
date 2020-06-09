CREATE TABLE account(
    account_no CHAR(3) PRIMARY KEY,
    account_balance NUMBER(8) DEFAULT 0
);

INSERT INTO account VALUES(101, 1000);
INSERT INTO account VALUES(201, 1000);

SELECT * FROM account;
-- �ٸ� ����(�ٸ� ����)���� Ȯ���� �� ���� ������

commit; -- �ٸ� ����(�ٸ� ����)������ Ȯ�� ��������. DB�� �����

-- ������ü
 --1) 101�� ���¿��� 10�� ��� (O)
 --2) 901�� ���¿� 10�� �Ա� (X)
 UPDATE account
 SET account_balance = account_balance-10
 WHERE account_no = '101'
 ;--(O)
 
SELECT * FROM account;

 UPDATE account
 SET account_balance = account_balance+10
 WHERE account_no = '901'
 ;--(X)
 
 ROLLBACK;

SELECT * FROM account;
------------------------------
-- SAVEPOINT
INSERT INTO account VALUES('301', 0);
SAVEPOINT B;

UPDATE account SET account_balance = 10
WHERE account_no = '301'
;

INSERT INTO account VALUES(401, 100);
SAVEPOINT A;

--DELETE FROM�������� account 
DELETE account WHERE account_no =401;

ROLLBACK TO SAVEPOINT A; -- COMMIT �� �ʿ��ϴ�.
SELECT * FROM account; -- 101, 201,301, 401 ��� ����
                       -- �κ� ROLLBACK
-- TRANSACTION �Ϸ�
COMMIT;