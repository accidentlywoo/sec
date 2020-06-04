-- SubQuery
-- ���������� ��ȯ�ϴ� ����� ����
-- ������ �Լ�
-- ������ �Լ�

-- ���������� ��ġ�� ����
-- �Ϲ����� ��������-�������� : WHERE ��, HAVING ��
-- Inline View : FROM ��
-- Scalar Subquery : SELECT ��
-- ���������� ��ȯ�ϴ� ����� ���� �з�

-- �ִ�޿��� ���
SELECT MAX(salary)
FROM employees
;

-- �ִ�޿��� �޴� ����� ���, ����, �޿��� ����Ͻÿ�.
-- 1) �ִ�޿��� ����Ѵ�. -> SubQuery
-- 2) 1)�� ���� �޿��� �޴� ����� �˻��Ѵ�. -> MainQuery
SELECT e.employee_id, e.first_name ||' '|| e.last_name
FROM employees e
WHERE e.salary = (SELECT MAX(salary) FROM employees)
;

-- �ִ�޿��� �޴� ����� ���� �μ����� �ٹ��ϴ� ��� ���� ����Ͻÿ�. 3.
--0) �ִ�޿��� ����Ѵ�.
--1)0)�� ���� �޿��� �޴� ����� �μ���ȣ�� �˻��Ѵ�.
--2)1)�� ���� �μ���ȣ�� ���� ����� �˻��Ѵ�.

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
-- ������ ��������
-- �μ��� ��ձ޿��� ����Ͻÿ�.
SELECT department_id, TO_CHAR(ROUND(AVG(salary), 1), '99,999.0')
FROM employees
GROUP BY department_id
;
--�μ��� ��ձ޿����� ���� �޿��� �޴� ������� ����Ͻÿ�.
SELECT employee_id, department_id, salary
FROM employees
ORDER BY department_id DESC
;

-- �μ��� ��ձ޿����� ���� �޿��� �޴� ������� ����Ͻÿ�
-- 1) �μ��� ��ձ޿� ����Ѵ�.
-- 2)1) ���� ���� �޿��� ���� ����� ���
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

-- �μ��� �ּұ޿��� �޴� ������� ����Ͻÿ�
-- 1) �μ��� �ּұ޿� ����Ѵ�.
-- 2)1) �� ���� �޿��� ���� ����� ���
SELECT MIN(salary)
FROM employees
GROUP BY department_id
;

SELECT *
FROM employees 
WHERE salary IN (SELECT MIN(salary)
                    FROM employees
                    GROUP BY department_id)                   
; -- �߸��� ����� ���´�. �ٸ� �μ��� �ּڰ��� ���ؿ��� ������ ���ϴ� ������� �ƴϴ�..

-- Pair Wising (ONLY Oracle)
SELECT *
FROM employees 
WHERE (department_id, salary) IN (SELECT department_id, MIN(salary)
                                    FROM employees
                                    GROUP BY department_id)                   
; -- department_id -> SubQuery�� department_id / salary -> SubQuery�� MIN(salary)

-- ��å(job_title)�� 'President'�� ����� ���, �̸��� ����Ͻÿ�
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
--10. ���� 'Davies'�� ����� ���� �μ��� �ٹ��ϴ� ������� ���, ��, �̸��� ����Ͻÿ�--44��
--e.first_name = 'Davies'
SELECT *
FROM employees
WHERE 1 = 1 
AND last_name <> 'Davies'
AND department_id = (SELECT department_id
                        FROM employees
                        WHERE last_name = 'Davies')                
;                        

-- 'sales' �μ��� ��ձ޿����� ���� �޿��� �޴�
-- 'sales' �μ��� ������� ����Ͻÿ�.
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
-- ��ȣ ���� ���������� �ذ��� ����
SELECT department_id, employee_id, salary
FROM employees e
WHERE department_id= (SELECT department_id
                        FROM departments
                        WHERE department_name = 'Sales')
AND salary > (SELECT AVG(employees.salary)
                FROM employees
                WHERE department_id = e.department_id) -- e.department_id WHERE���� 1��° �������� �ݺ� ��� �԰���
;
-- ������ �ټ��� �ش� -> Network�� DB Server�� ����������� �پ��� -> Network �ӵ��� ��������.

-- ����� 1���̶� �ִ� �μ��� ����Ͻÿ�.
SELECT *
FROM departments d
WHERE EXISTS (SELECT * FROM employees WHERE d.department_id = department_id)
; -- True/False�� ��ȯ
-- �������������� ����� �� �ִ�. �ݵ�� ���� ���� ���̺��� ����ؾ� �Ѵ�.
-- �Ϲ����� ������������ ������� ���ϰ�, ��ȣ���� ���������϶��� ����ؾ� �Ѵ�.

-- ����� 1�� ���� �ִ� �μ��� ����Ͻÿ�.
SELECT *
FROM departments d
WHERE NOT EXISTS (SELECT * 
                    FROM employees 
                    WHERE department_id = d.department_id)
;