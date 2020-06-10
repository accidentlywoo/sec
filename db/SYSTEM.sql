-- 계정 생성하기
CREATE USER a IDENTIFIED BY 1;

select * from user_tables;

-- A 계정을 이용해서 DB 접속 및 테이블/인덱스/시퀀스 객체 생성가능
-- 권한 허용
GRANT connect, resource TO a;
-- resource 여러가지 privilage가 묶여있는 role -> resource

-- 시노님 생성권한 허용
GRANT create synonym, create public synonym TO a;
