--------------------------------------------------------
--  ������ ������ - ������-6��-10-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure P1
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "TEST"."P1" (num1 NUMBER, num2 NUMBER)
IS num3 NUMBER; 
   vname customer.name%TYPE;
   vpwd customer.pwd%TYPE;
--(AS/IS), �ڷ���/����� ���� ��ҹ��� ����x 
BEGIN
  num3 := num1 + num2;
  dbms_output.put_line(num1 || '+' || num2 || '=' ||num3 );
  
  INSERT INTO customer(id, pwd, name)
  VALUES ('id8', 'p8', 'n8');
  
  UPDATE customer SET name = '�̸�8'
  WHERE id = 'id8';
  COMMIT;
  dbms_output.put_line('id8 �� �����߰� �� ����');
  
  SELECT pwd, name INTO vpwd, vname 
  FROM customer 
  WHERE id = 'id8';
  
  dbms_output.put_line('id8 ���� �̸� : ' || vname || ', ��й�ȣ : '||vpwd);
END P1;
-- �����ϵ� Ȯ�� �ʼ�

/
