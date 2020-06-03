SELECT a.employee_id,  b.employee_id
FROM employees a, employees b;

SELECT a.employee_id,  b.employee_id
FROM employees a, employees b
WHERE a.employee_id = b.employee_id;
---------------------------------------
SELECT employee_id, department_id FROM employees;
SELECT * FROM departments;

--사원의 사번, 성명, 부서번호, 부서명을 출력하시오
SELECT employee_id, first_name, last_name
      ,e.department_id, department_name
FROM employees e, departments d
WHERE e.department_id =  d.department_id;
----------------------------------------------
--표준화된 JOIN
--Natural Join 
SELECT employee_id, first_name, last_name
      , department_id, department_name
FROM employees NATURAL JOIN  departments; 

--Join USING절 
SELECT employee_id, first_name, last_name
      , department_id, department_name
FROM employees JOIN  departments USING(department_id); 

--Join ON절
SELECT employee_id, first_name, last_name
      , e.department_id 사원부서번호,  d.department_id 부서번호,
      department_name
FROM  employees e JOIN departments d
ON (e.department_id = d.department_id);

--사원의 사번, 이름, 부서번호, 부서명, 부서가 속한 도시명을 출력하시오
SELECT e.employee_id,   e.first_name
     , d.department_id, d.department_name
     , l.city
FROM employees e 
     JOIN departments d ON(e.department_id = d.department_id)
     JOIN locations l ON(d.location_id = l.location_id);

--사원의 사번, 이름, 부서명, 직무명을 출력하시오
SELECT  employee_id
, department_name
, job_title
FROM employees e
     JOIN departments d ON (e.department_id = d.department_id)
     JOIN jobs j ON (e.job_id = j.job_id);

--부서가 속한 도시들의 부서명, 도시명을 출력하시오
SELECT department_name, city
FROM departments NATURAL JOIN locations;

--SELF JOIN
--사번, 성명, 관리자번호
SELECT e.employee_id 사번, e.first_name||' '||e.last_name 성명,
       e.manager_id 관리자번호
       ,m.first_name||' '||m.last_name 관리자성명       
FROM employees e
     JOIN employees m ON (e.manager_id = m.employee_id );

--급여가 5000이상인 사원의 사번, 성명, 관리자번호, 관리자성명을 출력하시오
SELECT e.employee_id 사번, e.first_name||' '||e.last_name 성명,
       e.manager_id 관리자번호
       ,m.first_name||' '||m.last_name 관리자성명       
FROM employees e
     JOIN employees m ON (e.manager_id = m.employee_id )
WHERE e.salary >= 5000;

--사원과 관리자가 다른부서에서 근무하는 사원들의
-- 사번, 성명, 부서명, 관리자번호, 관리자성명, 관리자부서명을 출력하시오
SELECT e.employee_id 사번
     , e.first_name||' '||e.last_name 성명
     , ed.department_name "부서명"
     , e.manager_id 관리자번호
     , m.first_name||' '||m.last_name 관리자성명
     , md.department_name "관리자부서명"
FROM employees e
     JOIN employees m ON (e.manager_id = m.employee_id )
     JOIN departments ed ON (e.department_id = ed.department_id)
     JOIN departments md ON (m.department_id = md.department_id)
WHERE ed.department_id <> md.department_id;     

--관리자급여보다 많은 급여를 받는 사원의
--사번, 성명, 급여, 관리자번호, 관리자성명, 관리자급여를 출력하시오
SELECT e.employee_id 사번, e.first_name||' '||e.last_name 성명
      ,e.salary 급여
      ,m.employee_id 관리자번호, m.first_name||' '||m.last_name 관리자성명
      ,m.salary 관리자급여
FROM employees e
     JOIN employees m ON (e.manager_id = m.employee_id)
WHERE e.salary > m.salary;     

------------------------------------
--사원의 사번, 부서번호, 부서명을 출력하시오--106건
SELECT employee_id, e.department_id, department_name
FROM employees e INNER JOIN departments d ON (e.department_id = d.department_id);

--OUTER JOIN
--사원의 사번, 부서번호, 부서명을 출력하시오--107건
--부서배치받지 않은 사원도 출력한다
SELECT employee_id, e.department_id, department_name
FROM employees e LEFT OUTER JOIN departments d ON (e.department_id = d.department_id);

--부서번호, 부서명, 도시명을 출력하시오
--부서가 없는 도시도 출력한다
SELECT department_name, city
FROM departments d RIGHT JOIN locations l ON (d.location_id = l.location_id);

SELECT NVL(department_name, '부서없음'), city
FROM departments d RIGHT JOIN locations l ON (d.location_id = l.location_id);
