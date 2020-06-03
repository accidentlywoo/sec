SELECT location_id, COUNT(department_id)
from departments
GROUP BY location_id;

select *
from employees;

select * 
from departments;
1. 급여가 10000이거나  14000인 사원들의 사번, 이름(first_name), 급여를 검색하시오.

2. first_name에 대소문자구별없이('e', 'E')를 포함하는 모든 사원을 검색하시오

3. first_name이 'J’로 시작하고 n문자를 포함하는 사원의 사번, 이름을 검색하시오.
예)
사번 	이름
---------------------
110 John
139 John
145 John
181 Jean
189 Jennifer
200 Jennifer
---------------------
4. 급여가 10000이상인 사원의 사번, 부서번호, 이름, 급여, 수당을 출력하시오.단, 부서번호가 30번,60번, 90번인 부서는 제외하고 사원을 검색한다.

5. 급여가 4000보다 많은 사원들의 부서별 급여평균를 출력하시오. 단 급여평균은 소숫점이하2자리에서 반올림합니다.

6.부서배치를 받지 않은 사원은 제외하고 부서별 급여평균을 출력하시오.단 급여평균은 소숫점이하2자리에서 반올림합니다.

7. 부서배치를 받지 않은 사원은 제외하고 급여평균이 10000이상인 부서별 급여평균을 출력하시오.단 급여평균은 소숫점이하2자리에서 반올림합니다.  

-- 1
SELECT department_id, first_name
FROM employees
where salary in (10000, 14000)
;

-- 2
SELECT *
FROM employees
where lower(first_name) LIKE '%e%';

-- 3
select * 
from employees
where first_name LIKE 'J%n%';

-- 4
SELECT employee_id, department_id, first_name, salary, commission_pct
FROM employees
where department_id not in (30, 60, 90);

-- 5
select department_id, ROUND(sum(salary),2)
from employees
where salary >= 4000
group by department_id;

-- 6
select department_id, ROUND(sum(salary),2)
from employees
where department_id is not null
GROUP by department_id;

-- 7
select department_id, ROUND(sum(salary),2)
from employees
where department_id is not null
GROUP by department_id
having  ROUND(sum(salary),2) >= 10000;