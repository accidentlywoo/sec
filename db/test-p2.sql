--------------------------------------------------------
--  ������ ������ - ������-6��-10-2020   
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
  -- NUM���� Ȧ���� ���
  IF result = 1 THEN
    DBMS_OUTPUT.PUT_LINE('Ȧ���Դϴ�.');
      
  -- ¦���� ���
  ELSE
    DBMS_OUTPUT.PUT_LINE('¦���Դϴ�.');
  END IF;
  
  -- num ���� 90�̻��� ��� 'A' ���
  IF num >= 90 THEN 
    grade:= 'A';
  -- num ���� 80           'B'
  ELSIF  num >= 80 THEN 
    grade:= 'B';
  -- num     70           'C'
  ELSIF  num >= 70 THEN 
    grade:= 'C';
  --        �׿��� ��      'D'
    grade:= 'D';
  END IF;
  DBMS_OUTPUT.PUT_LINE(grade);
END P2;

/
