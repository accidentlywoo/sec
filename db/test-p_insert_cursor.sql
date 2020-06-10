--------------------------------------------------------
--  파일이 생성됨 - 수요일-6월-10-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure P_INSERT_CUSTOMER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "TEST"."P_INSERT_CUSTOMER" 
    (
    pid IN customer.id%TYPE,
    ppwd IN customer.pwd%TYPE,
    pqtt IN customer.name%TYPE
    )
AS 
BEGIN
  INSERT INTO customer(id, pwd, name)
  VALUES(pid, ppwd, pqtt)
  ;
  INSERT INTO point(POINT_ID)
  VALUES(pid)
  ;
  COMMIT;
END P_INSERT_CUSTOMER;

/
