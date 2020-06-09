-- Scalar SubQuery : SELECT 절

-- 4. 'Seattle', 'Toronto'도시에  근무하는 
-- 사원들의 도시명,사번, 이름, 부서ID, 부서명 을 출력하시오
SELECT *
FROM employees e
    JOIN departments d
    ON (e.department_id = d.department_id)
    JOIN locations l
    ON (d.location_id = l.location_id)
WHERE l.city IN ('Seattle', 'Toronto')
;
-- Scalar Query는 Main Query와 연관 관계가 없으면 사용할 수 없다.
SELECT employee_id, first_name, department_id,
    (SELECT d.department_name FROM departments d
    WHERE d.department_id = e.department_id)    
FROM employees e
;

-- 사원들의 사번, 이름, 부서ID, 부서명, 도시명을 출력하시오 : Scalar
SELECT e.employee_id, e.first_name, e.department_id,
    (SELECT d.department_name
        FROM departments d 
        WHERE d.department_id = e.department_id) as 부서명,
    (SELECT (SELECT l.city FROM locations l WHERE l.location_id = d.location_id) -- Main Table과 관계를 맺어야되기때문에, 중복 쌉많음
        FROM departments d 
        WHERE d.department_id = e.department_id) as 도시명
FROM employees e
;
-- 논리적 튜닝(SQL)은 실행을 해보고 계획을 짜야된다.

-- 4. 'Seattle', 'Toronto'도시에  근무하는 
-- 사원들의 도시명,사번, 이름, 부서ID, 부서명 을 출력하시오. -> 모두 스칼라쿼리로 만들 수 있나?
SELECT e.employee_id, e.first_name, e.department_id,
    (SELECT d.department_name
        FROM departments d 
        WHERE d.department_id = e.department_id) as 부서명,
    (SELECT l.city as 도시명
        FROM locations l 
        WHERE l.location_id= (SELECT l.location_id FROM departments d WHERE l.location_id = d.location_id)
        AND city IN ('Seattle', 'Toronto'))
FROM employees e
; -- ERROR 발생

SELECT e.employee_id, e.first_name, e.department_id,
    (SELECT d.department_name
        FROM departments d 
        WHERE d.department_id = e.department_id) as 부서명,
    (SELECT (SELECT l.city FROM locations l WHERE l.location_id = d.location_id)
        FROM departments d 
        WHERE d.department_id = e.department_id) as 도시명
FROM employees e
WHERE e.department_id IN (SELECT d.department_id
                        FROM departments d
                        WHERE d.location_id IN (SELECT l.location_id
                                                FROM locations l
                                                WHERE l.city IN ('Seattle', 'Toronto')
                                                )
                        )
;        
