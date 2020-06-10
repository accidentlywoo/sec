-- 함수
-- 함수는 반환값이 반드시 있다.
-- 반환값이 대입된 변수는 var또는 variable로 선언한다.
-- 변수에 대입할때는 :변수명 :=함수;
-- 변수를 출력할때는 print 명령어를 사용한다.
-- 잘안씀.
VARIABLE msg VARCHAR2;
EXECUTE :msg := f1;
print msg;

SELECT f1 FROM dual;

SELECT id ||' ' || f1 FROM customer;