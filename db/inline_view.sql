-- INLINE VIEW

-- rownum : 행번호를 알려주는 의사컬럼
SELECT ROWNUM, employee_id, salary
FROM employees
WHERE salary > 10000
ORDER BY salary DESC
; -- ROWNUM 발급 시점은 SELECT 시점 : ROWNUM이 뒤죽 밥죽
-- 처리 순서
-- FROM -> WHERE -> GROUP BY -> HAVING -> ROWNUM :: SELECT -> ORDER BY

-- 급여가 많은 사원부터 출력하시오. 단 행번호를 순차 출력한다.
SELECT ROWNUM, a.*
FROM (SELECT employee_id, salary
        FROM employees
        WHERE salary > 10000
        ORDER BY salary DESC) a 
;
-- 급여가 많은 사원부터 출력하시오. 단 행번호를 순차 출력한다.
-- 1~5행까지만 출력한다. [TOP END Query]
SELECT ROWNUM, a.*
FROM (SELECT employee_id, salary
        FROM employees
        WHERE salary > 10000
        ORDER BY salary DESC) a 
WHERE ROWNUM <= 5      
;

-- 급여가 많은 사원부터 출력하시오. 단 행번호를 순차 출력한다.
-- 5~10행까지만 출력한다. [TOP END Query]
SELECT *
FROM (SELECT ROWNUM list, a.* -- Alias 설정하지 않으면 바깥에서 사용하기 어렵다.
        FROM (SELECT employee_id, salary
                FROM employees
                WHERE salary > 10000
                ORDER BY salary DESC) a 
        ) b
WHERE b.list BETWEEN 6 AND 10
;