--1. 직책(job_title)이 'President'인 사원의 사번, 이름을 출력하시오: (NaturalJOIN으로 표현)
SELECT employee_id, first_name
FROM employees
    NATURAL JOIN jobs
WHERE job_title = 'President'    
;
select * from jobs;
select * from employees;
--2. 직책(job_title)이 'President'가 아닌 사원의 사번, 이름을 출력하시오(USING으로 표현)
SELECT * 
FROM employees
    JOIN jobs USING(job_id)
WHERE job_title NOT IN ('President')
;

--3. 부서번호, 부서명, 부서별 급여총액과 평균급여를 출력하시오.
--단, 급여총액이 낮은 순으로 정렬하고, 
--평균급여는 소수점 이하 1 자리까지 나타나도록 반올림해야 한다.
SELECT e.department_id, d.department_name, sum(e.salary), round(avg(e.salary),1)
FROM employees e
    INNER JOIN departments d
    ON e.department_id = d.department_id
GROUP BY e.department_id, d.department_name
ORDER BY sum(e.salary)asc;

--4. 'Seattle', 'Toronto'도시에  근무하는 
--사원들의 도시명,사번, 이름, 부서ID, 부서명 을 출력하시오
select * from locations;
select * from departments;
SELECT e.employee_id, e.first_name, l.city, d.department_name
FROM employees e
    INNER JOIN departments d
    ON e.department_id = d.department_id
    INNER JOIN locations l
    ON d.location_id = l.location_id
WHERE l.city IN ('Seattle', 'Toronto')
;
--5. 'Seattle'을 제외한 도시의 부서별 사원수가 5명미만인 
--도시명, 부서ID, 부서명, 사원수를 출력하시오 
SELECT e.employee_id, e.first_name, l.city, d.department_name
FROM employees e
    INNER JOIN departments d
    ON e.department_id = d.department_id
    INNER JOIN locations l
    ON d.location_id = l.location_id
WHERE l.city NOT IN ('Seattle')
GROUP BY e.employee_id, e.first_name, l.city, d.department_name
HAVING COUNT(e.department_id) <= 5
;

--6. 부서ID가 50 이거나 80인 부서에 근무하는 사원들의 직무ID와 직책(job_title)을 출력하시오.
--결과에서 직종(job_id)의 중복은 제거하시오 --5건
SELECT DISTINCT j.job_id, j.job_title
FROM employees e
    INNER JOIN departments d
    ON e.department_id = d.department_id
    INNER JOIN jobs j
    ON e.job_id = j.job_id
WHERE e.department_id in (50, 80)    
;
--7. 사원의 사번, 관리자번호, 부서ID, 부서명, 부서장ID를 출력하시오
select * from employees;
select * from departments;

SELECT e.employee_id, e.manager_id, d.department_id,d.department_name, d.manager_id
FROM employees e
    INNER JOIN departments d
    ON e.department_id = d.department_id
;    

--8. 사원의 사번, 관리자번호, 부서ID, 부서명, 부서장ID를 출력하시오. 단, 부서없는 사원도, 사원이 없는 부서도 출력한다
SELECT e.employee_id, e.manager_id, d.department_id,d.department_name, d.manager_id
FROM employees e
    FULL OUTER JOIN departments d
    ON e.department_id = d.department_id
;
--9. 성이 'Davies'인 사원의 부서ID와 급여를 출력하시오.
SELECT e.department_id, e.salary
FROM employees e
WHERE e.last_name = 'Davies'
;
--10. 성이 'Davies'인 사원과 같은 부서에 근무하는 사원들의 사번, 성, 이름을 출력하시오--44건
--e.first_name = 'Davies'
SELECT e.employee_id, e.first_name, e.last_name
FROM employees e
    INNER JOIN departments d
    ON e.department_id = d.department_id
WHERE d.department_id = 50
AND e.last_name NOT IN 'Davies' 
;