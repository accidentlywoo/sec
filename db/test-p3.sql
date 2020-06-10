--------------------------------------------------------
--  파일이 생성됨 - 수요일-6월-10-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure P3
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "TEST"."P3" 
AS 
    start_num NUMBER := 1;
    max_num NUMBER := 10;
    i_num NUMBER := 0;
BEGIN
    i_num := start_num;
    LOOP
        dbms_output.put_line(i_num);
        IF i_num = max_num THEN
            EXIT; -- LOOP ESCAPE
        END IF;
        i_num := i_num+1;
    END LOOP;
    
    dbms_output.put_line('---------------');
    i_num := start_num;
    WHILE i_num <= max_num LOOP
        dbms_output.put_line(i_num);
        i_num := i_num+1;
    END LOOP;
    
     dbms_output.put_line('---------------');
    FOR i_num IN  start_num..max_num LOOP
        dbms_output.put_line(i_num);
    END LOOP;
    
END P3;

/
