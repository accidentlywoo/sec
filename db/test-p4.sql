--------------------------------------------------------
--  ������ ������ - ������-6��-10-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure P4
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "TEST"."P4" 
AS 
--    vid customer.id%TYPE;
--    vpwd customer.pwd%TYPE;
--    vname customer.name%TYPE; COLUMN TYPE �÷� ������
    vcustomer customer%ROWTYPE; -- ��/���ڵ带 �����ϴ� TYPE
BEGIN
--  ������ �˻�
--  SELECT id, pwd, name INTO vid, vpwd, vname
    SELECT * INTO vcustomer
    FROM customer
    WHERE id = 'id1'
    ;
    DBMS_OUTPUT.PUT_LINE(vcustomer.id || ',' || vcustomer.pwd || ',' || vcustomer.name);
END P4;

/
