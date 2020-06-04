-- SubQuery
-- 서브쿼리가 반환하는 행수에 따라
-- 단일행 함수
-- 여러행 함수

-- 서브쿼리의 위치에 따라
-- 일반적인 서브쿼리-서브쿼리 : WHERE 절, HAVING 절
-- Inline View : FROM 절
-- Scalar Subquery : SELECT 절
-- 서브쿼리가 반환하는 행수에 따른 분류

-- 최대급여를 출력
SELECT MAX(salary)
FROM employees
;

-- 최대급여를 받는 사원의 사번, 성명, 급여를 출력하시오.
-- 1) 최대급여를 계산한다. -> SubQuery
-- 2) 1)과 같은 급여를 받는 사원을 검색한다. -> MainQuery
SELECT e.employee_id, e.first_name ||' '|| e.last_name
FROM employees e
WHERE e.salary = (SELECT MAX(salary) FROM employees)
;

-- 최대급여를 받는 사원과 같은 부서에서 근무하는 사원 들을 출력하시오. 3.
--0) 최대급여를 계산한다.
--1)0)와 같은 급여를 받는 사원의 부서번호를 검색한다.
--2)1)과 같은 부서번호를 갖는 사원을 검색한다.

SELECT MAX(salary)
FROM employees
;

SELECT department_id
FROM employees
WHERE salary = (SELECT MAX(salary) FROM employees)
;

SELECT *
FROM employees
WHERE department_id = (SELECT department_id
                        FROM employees
                        WHERE salary = (SELECT MAX(salary) FROM employees))
;
-------------------------------------------------------------------
-- 여러행 서브쿼리
-- 부서별 평균급여를 출력하시오.
SELECT department_id, TO_CHAR(ROUND(AVG(salary), 1), '99,999.0')
FROM employees
GROUP BY department_id
;
--부서별 평균급여보다 많은 급여를 받는 사원들을 출력하시오.
SELECT employee_id, department_id, salary
FROM employees
ORDER BY department_id DESC
;

-- 부서별 평균급여보다 많은 급여를 받는 사원들을 출력하시오
-- 1) 부서별 평균급여 계산한다.
-- 2)1) 보다 많은 급여를 갖는 사원을 출력
SELECT AVG(salary)
FROM employees
GROUP BY department_id
;

SELECT *
FROM employees
WHERE salary IN (SELECT AVG(salary)
                    FROM employees
                    GROUP BY department_id)--(X)
;

-- 부서별 최소급여를 받는 사원들을 출력하시오
-- 1) 부서별 최소급여 계산한다.
-- 2)1) 와 같은 급여를 갖는 사원을 출력
SELECT MIN(salary)
FROM employees
GROUP BY department_id
;

SELECT *
FROM employees 
WHERE salary IN (SELECT MIN(salary)
                    FROM employees
                    GROUP BY department_id)                   
; -- 잘못된 결과가 나온다. 다른 부서의 최솟값도 비교해오기 때문에 원하는 결과값이 아니다..

-- Pair Wising (ONLY Oracle)
SELECT *
FROM employees 
WHERE (department_id, salary) IN (SELECT department_id, MIN(salary)
                                    FROM employees
                                    GROUP BY department_id)                   
; -- department_id -> SubQuery의 department_id / salary -> SubQuery의 MIN(salary)

-- 직책(job_title)이 'President'인 사원의 사번, 이름을 출력하시오
select * from employees
;
SELECT *
FROM employees
WHERE job_id = (SELECT job_id 
                FROM jobs 
                WHERE job_title = 'President')
;
SELECT *
FROM employees
WHERE job_id <> (SELECT job_id
                FROM jobs 
                WHERE job_title = 'President')-- <>
;
--10. 성이 'Davies'인 사원과 같은 부서에 근무하는 사원들의 사번, 성, 이름을 출력하시오--44건
--e.first_name = 'Davies'
SELECT *
FROM employees
WHERE 1 = 1 
AND last_name <> 'Davies'
AND department_id = (SELECT department_id
                        FROM employees
                        WHERE last_name = 'Davies')                
;                        

-- 'sales' 부서의 평균급여보다 많은 급여를 받는
-- 'sales' 부서의 사원들을 출력하시오.
SELECT *
FROM departments
WHERE department_name = 'Sales'
;

SELECT *
FROM employees
WHERE department_id= (SELECT department_id
                        FROM departments
                        WHERE department_name = 'Sales')
AND salary > (SELECT AVG(employees.salary)
                FROM employees
                WHERE department_id = (SELECT department_id
                        FROM departments
                        WHERE department_name = 'Sales'))
;                        
-- 상호 연관 서브쿼리로 해결해 보자
SELECT department_id, employee_id, salary
FROM employees e
WHERE department_id= (SELECT department_id
                        FROM departments
                        WHERE department_name = 'Sales')
AND salary > (SELECT AVG(employees.salary)
                FROM employees
                WHERE department_id = e.department_id) -- e.department_id WHERE절의 1번째 조건절을 반복 사용 쌉가능
;
-- 쿼리의 줄수가 준다 -> Network로 DB Server에 쿼리적용양이 줄어든다 -> Network 속도가 빨라진다.

-- 사원이 1명이라도 있는 부서를 출력하시오.
SELECT *
FROM departments d
WHERE EXISTS (SELECT * FROM employees WHERE d.department_id = department_id)
; -- True/False만 반환
-- 서브쿼리에서만 사용할 수 있다. 반드시 메인 쿼리 테이블을 사용해야 한다.
-- 일반적인 서브쿼리에서 사용하지 못하고, 상호연관 서브쿼리일때만 사용해야 한다.

-- 사원이 1명도 없는 있는 부서를 출력하시오.
SELECT *
FROM departments d
WHERE NOT EXISTS (SELECT * 
                    FROM employees 
                    WHERE department_id = d.department_id)
;