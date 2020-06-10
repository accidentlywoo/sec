show user;

-- CUSTOMER SELECT 권한 받아옴.
-- SELECT * FROM CUSTOMER; 조회 안댐
SELECT * FROM test.CUSTOMER;

-- pravate 시노님 만들기
CREATE SYNONYM tc FOR test.customer;

SELECT * FROM tc;

-- 공용 시노님 만들기
CREATE PUBLIC SYNONYM ptc FOR test.customer;

SELECT * FROM ptc;