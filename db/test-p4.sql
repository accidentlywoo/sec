--------------------------------------------------------
--  파일이 생성됨 - 수요일-6월-10-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure P4
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "TEST"."P4" 
AS 
--    vid customer.id%TYPE;
--    vpwd customer.pwd%TYPE;
--    vname customer.name%TYPE; COLUMN TYPE 컬럼 참조형
    vcustomer customer%ROWTYPE; -- 행/레코드를 참조하는 TYPE
BEGIN
--  단일행 검색
--  SELECT id, pwd, name INTO vid, vpwd, vname
    SELECT * INTO vcustomer
    FROM customer
    WHERE id = 'id1'
    ;
    DBMS_OUTPUT.PUT_LINE(vcustomer.id || ',' || vcustomer.pwd || ',' || vcustomer.name);
END P4;

/
