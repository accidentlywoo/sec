SELECT employee_id, first_name, last_name, hire_date, salary
FROM employees;

SELECT employee_id 사번, 
       first_name ||' '|| last_name 성명, 
       salary 급여,
       12*(salary + salary*commission_pct) "실제 연봉"
FROM employees;

--NULL관련 함수 : NVL( )
SELECT employee_id 사번, 
       first_name ||' '|| last_name 성명, 
       salary 급여,
       12*(salary + salary*NVL(commission_pct, 0)) "실제 연봉"
FROM employees;

--중복제거 : DISTINCT
SELECT department_id
FROM employees;

SELECT DISTINCT department_id, job_id 
FROM employees;




SELECT처리순서
 FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY
 
SELECT구문
 SELECT
 FROM
 [
 WHERE
 GROUP BY
 HAVING
 ORDER BY
 ]
-----------------------------------------------
연산자
-산술연산자 : +, -, *, /
-비교연산자 : >, >=, <, <=, =, <>
-논리연산자 : AND, OR, NOT
-BETWEEN연산자
-IN 연산자
-LIKE 연산자

--부서번호가 90인
--사원들의 사번, 성명, 급여, 부서번호를 출력하시오
SELECT employee_id 사번
     , first_name||' '||last_name 성명 
     , salary 급여
     , department_id 부서번호
FROM employees
WHERE department_id=90;

--부서번호가 90이 아닌
--사원들의 사번, 성명, 급여, 부서번호를 출력하시오
SELECT employee_id 사번
     , first_name||' '||last_name 성명 
     , salary 급여
     , department_id 부서번호
FROM employees
WHERE department_id <> 90;

--90번부서에 근무하면서 급여가 20000미만인 사원들을
--출력하시오
SELECT employee_id 사번
     , first_name||' '||last_name 성명 
     , salary 급여
     , department_id 부서번호
FROM employees
WHERE department_id=90 AND salary < 20000;

--급여가 10000이상이고 20000이하인 사원들을 출력하시오
SELECT employee_id 사번
     , first_name||' '||last_name 성명 
     , salary 급여
     , department_id 부서번호
FROM employees
--WHERE salary >= 10000 AND salary<= 20000;
WHERE salary BETWEEN 10000 AND 20000;

--부서가 10번부서이거나 90번부서인 사원들을 출력하시오
--OR연산자 또는 IN연산자 
SELECT employee_id 사번
     , first_name||' '||last_name 성명 
     , salary 급여
     , department_id 부서번호
FROM employees
--WHERE department_id=10 OR department_id=90;
WHERE department_id IN (10, 90);

--급여가 10000미만이거나 20000초과인 사원들을 출력하시오
SELECT employee_id 사번
     , first_name||' '||last_name 성명 
     , salary 급여
     , department_id 부서번호
FROM employees
--WHERE salary < 10000 OR salary > 20000;
WHERE NOT (salary BETWEEN 10000 AND 20000);


--부서가 (10번, 90번)부서가 아닌 부서인 사원들을 출력하시오
SELECT employee_id 사번
     , first_name||' '||last_name 성명 
     , salary 급여
     , department_id 부서번호
FROM employees
--WHERE department_id<>10 AND department_id<>90;
WHERE department_id NOT IN (10, 90);

--부서번호가 10, 90번 부서이고
--급여가 1000이상20000이하인 사원들을 출력하시오 
SELECT employee_id 사번
     , first_name||' '||last_name 성명 
     , salary 급여
     , department_id 부서번호
FROM employees
--WHERE (department_id = 10 OR department_id=90)
--AND salary >= 1000 AND salary <= 20000;
WHERE department_id IN(10, 90)
AND salary BETWEEN 1000 AND 20000;

SELECT * FROM departments;
--부서이름에 'IT'가 포함된 부서들을 출력하시오
SELECT *
FROM departments
WHERE department_name LIKE '%IT%';

--직무명(job_title)이 'Manager'로 끝나는 
--모든 직무를 출력하시오
SELECT *
FROM jobs
WHERE job_title LIKE '%Manager';
--사원이름(first_name)의 두번째세번째글자가 'an'인
--사원들을 출력하시오
SELECT *
FROM employees
WHERE first_name LIKE '__an%';

--수당(commission_pct)을 받지 않는 사원들을 출력하시오
SELECT *
FROM employees
WHERE commission_pct IS NULL;

--많은 급여를 받는 사원순으로 사원들을 출력하시오.
SELECT *
FROM employees
ORDER BY salary DESC;
--많은 급여를 받는 사원순으로 사원들을 출력하시오. 
--단 급여가 같으면 부서를 사전순으로 정렬하시오
SELECT *
FROM employees
ORDER BY salary DESC, department_id;  

--실급여(급여+급여*수당률)가 적은 순서로 
--사원들의 사번, 성명, 부서번호, 급여, 실급여를 출력하시오
SELECT  employee_id 사번, first_name||' '||last_name 성명,
        department_id 부서번호,
        salary 급여, salary + (salary*NVL(commission_pct, 0)) 실급여
FROM employees
--ORDER BY salary + (salary*NVL(commission_pct, 0));
--ORDER BY 실급여;
ORDER BY 5;

--장기근속자부터 사원들을 출력하시오.
SELECT *
FROM employees
ORDER BY hire_date;

--부서번호가 10, 50, 80부서의 사원들을 출력하시오
--단 급여가 많은 사원부터 출력하시오
SELECT *
FROM employees
WHERE department_id IN(10,50, 80)
ORDER BY salary DESC;

--부서번호가 10, 50, 80부서의 사원들의 사번, 이름을 출력하시오
--단 급여가 많은 사원부터 출력하시오
SELECT employee_id, first_name
FROM employees
WHERE department_id IN(10,50, 80)
ORDER BY salary DESC;

