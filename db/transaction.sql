CREATE TABLE account(
    account_no CHAR(3) PRIMARY KEY,
    account_balance NUMBER(8) DEFAULT 0
);

INSERT INTO account VALUES(101, 1000);
INSERT INTO account VALUES(201, 1000);

SELECT * FROM account;
-- 다른 세션(다른 접속)에서 확인할 수 없는 데이터

commit; -- 다른 세션(다른 접속)에서도 확인 가능해짐. DB에 적용됨

-- 계좌이체
 --1) 101번 계좌에서 10원 출금 (O)
 --2) 901번 계좌에 10원 입금 (X)
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

--DELETE FROM생략가능 account 
DELETE account WHERE account_no =401;

ROLLBACK TO SAVEPOINT A; -- COMMIT 이 필요하다.
SELECT * FROM account; -- 101, 201,301, 401 모두 보임
                       -- 부분 ROLLBACK
-- TRANSACTION 완료
COMMIT;