--------------------------------------------------------
--  파일이 생성됨 - 수요일-6월-10-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure P2
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "TEST"."P2" (num IN NUMBER)
AS 
    result NUMBER;
    grade CHAR;
BEGIN
    SELECT MOD(num, 2) INTO result
    FROM dual;
  -- NUM값이 홀수인 경우
  IF result = 1 THEN
    DBMS_OUTPUT.PUT_LINE('홀수입니다.');
      
  -- 짝수인 경우
  ELSE
    DBMS_OUTPUT.PUT_LINE('짝수입니다.');
  END IF;
  
  -- num 값이 90이상일 경우 'A' 출력
  IF num >= 90 THEN 
    grade:= 'A';
  -- num 값이 80           'B'
  ELSIF  num >= 80 THEN 
    grade:= 'B';
  -- num     70           'C'
  ELSIF  num >= 70 THEN 
    grade:= 'C';
  --        그외의 값      'D'
    grade:= 'D';
  END IF;
  DBMS_OUTPUT.PUT_LINE(grade);
END P2;

/
