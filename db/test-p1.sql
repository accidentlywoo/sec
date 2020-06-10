--------------------------------------------------------
--  파일이 생성됨 - 수요일-6월-10-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure P1
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "TEST"."P1" (num1 NUMBER, num2 NUMBER)
IS num3 NUMBER; 
   vname customer.name%TYPE;
   vpwd customer.pwd%TYPE;
--(AS/IS), 자료형/예약어 사용시 대소문자 구분x 
BEGIN
  num3 := num1 + num2;
  dbms_output.put_line(num1 || '+' || num2 || '=' ||num3 );
  
  INSERT INTO customer(id, pwd, name)
  VALUES ('id8', 'p8', 'n8');
  
  UPDATE customer SET name = '이름8'
  WHERE id = 'id8';
  COMMIT;
  dbms_output.put_line('id8 고객 정보추가 및 수정');
  
  SELECT pwd, name INTO vpwd, vname 
  FROM customer 
  WHERE id = 'id8';
  
  dbms_output.put_line('id8 고객의 이름 : ' || vname || ', 비밀번호 : '||vpwd);
END P1;
-- 컴파일됨 확인 필수

/
