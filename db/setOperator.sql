-- 사원의 사번, 현재 직무번호, 이전 직무번호를 출력하시오
-- 단, 이전 직무가 없는 사원도 출력한다.
SELECT 
      e.employee_id
    , e.job_id "현재 직무번호"
    , h.job_id "이전 직무번호"
FROM employees e
    LEFT OUTER JOIN job_history h
    ON (e.employee_id= h.employee_id)
ORDER BY e.employee_id     
;    
SELECT e.employee_id, e.job_id, h.job_id
FROM employees e
    LEFT OUTER JOIN job_history h
    ON (e.job_id= h.job_id)
ORDER BY e.employee_id    
;-- 존나 논리적으로 잘못된 쿼리

---------------------------------------------
-- 합집합 : UNION ALL / UNION
-- UNION : 중복제거와 Sorted
SELECT employee_id "사번1" , job_id "업무1"
FROM employees
UNION
SELECT employee_id "사번2", job_id "업무2"
FROM job_history
;-- Heading Column 췤췤!

-- UNION ALL : 중복이건 말건 걍 합침, Sorting안함
SELECT employee_id "사번1" , job_id "업무1"
FROM employees
UNION ALL
SELECT employee_id "사번2", job_id "업무2"
FROM job_history
;
-- 이전 업무와 같은 현재 업무를 담당하는 사원들의 사번, 업무번호를 출력하시오.
SELECT employee_id "사번1" , job_id "업무1"
FROM employees
INTERSECT
SELECT employee_id "사번2", job_id "업무2"
FROM job_history
;
SELECT e.employee_id, e.job_id
FROM employees e
    LEFT OUTER JOIN job_history h
    ON (e.employee_id = h.employee_id)
WHERE e.job_id = h.job_id    
;
-- 현재 업무와 다른 이전 업무를 담당했던 사원들의 사번, 이전 업무를 출력하시오.
SELECT employee_id "사번2", job_id "업무2"
FROM job_history
MINUS
SELECT employee_id "사번1" , job_id "업무1"
FROM employees
;
-- 이전 업무경력이 있는 사원의 사번을 출력하시오.
SELECT employee_id
FROM job_history
;

-- 이전 업무경력이 있는 사원의 사번을 출력하시오.
-- 사번은 중복하지 않는다.
SELECT UNIQUE employee_id
FROM job_history
;

-- 이전 업무 경력이 없는 사원의 사번을 출력하시오.
SELECT e.employee_id
FROM employees e
    LEFT OUTER JOIN job_history h
    ON (e.employee_id = h.employee_id)
WHERE h.job_id IS NULL    
;    

SELECT employee_id
FROM employees
MINUS
SELECT employee_id
FROM job_history
;    