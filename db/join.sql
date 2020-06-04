SELECT a.employee_id, b.employee_id
FROM employees a, employees b;
-- 카티션 프로덕트

SELECT a.employee_id, b.employee_id
FROM employees a, employees b
WHERE b.employee_id = a.employee_id;
-- 카티션 프로덕트
-- 카티션 프로덕트를 피하려면 적절한 조건을 줘야 한다.

-- 사원의 사번, 성명, 부서번호, 부서명을 출력하시오.
SELECT * 
FROM employees e, departments d
where e.department_id= d.department_id;
----------------------------------------------------
-- 표준(ANSI)와 Oracle 전용 INNER JOIN의 성능은 똑같다.

-- NATURAL JOIN
SELECT department_id
FROM employees NATURAL JOIN departments;
-- Natural Join : 두 테이블에서 서로 같은 컬럼을 모두 찾아서 조인 : 비 권장
SELECT e.department_id, d.department_id
FROM employees e NATURAL JOIN departments d;
-- Natural Join 은 별칭을 사용해서는 안된다.

-- JOIN USING
SELECT department_id
FROM employees JOIN departments
USING(department_id);

SELECT e.department_id, d.department_id
FROM employees e JOIN departments d
USING(department_id);
-- Join Using 은 별칭을 사용해서는 안된다.

-- JOIN ON(ANSI) : 테이블 Alias SELECT문에 사용 쌉 가능
SELECT *
FROM employees e JOIN departments d
on (employees.department_id = departments.department_id);
  -- 흐름과 Alias : FROM -> ON -> ...
  -- on에서 Alias사용하는 것이 좋다.

SELECT *
FROM employees e JOIN departments d
on (e.department_id = d.department_id);

select * 
from employees e
join employees m on (e.manager_id = m.employee_id)
and m.salary >= 5000; -- where 절을 대신해서 사용하는 and

select * 
from employees e, employees m
where e.manager_id = m.employee_id
and e.salary >= 5000;



