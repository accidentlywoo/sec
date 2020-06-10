--------------------------------------------------------
--  파일이 생성됨 - 수요일-6월-10-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure P4CURSOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "TEST"."P4CURSOR" 
AS
    vcustomer customer%ROWTYPE;
    CURSOR c1 IS
    SELECT * FROM customer;
BEGIN
-- 다중행 출력!
-- 커서의 행수를 출력한다.
--    DBMS_OUTPUT.PUT_LINE('고객 수:' || c1%ROWCOUNT);
    SELECT * INTO vcustomer
    FROM customer
    WHERE id = 'id1'
    ;
    DBMS_OUTPUT.PUT_LINE('-----------');
    FOR r IN c1 LOOP
        DBMS_OUTPUT.PUT_LINE(vcustomer.id || ',' || vcustomer.pwd || ',' || vcustomer.name);
        DBMS_OUTPUT.PUT_LINE('고객 수:' || c1%ROWCOUNT);
    END LOOP;
END P4CURSOR;

/
