--1. ��å(job_title)�� 'President'�� ����� ���, �̸��� ����Ͻÿ�: (NaturalJOIN���� ǥ��)
SELECT employee_id, first_name
FROM employees
    NATURAL JOIN jobs
WHERE job_title = 'President'    
;
select * from jobs;
select * from employees;
--2. ��å(job_title)�� 'President'�� �ƴ� ����� ���, �̸��� ����Ͻÿ�(USING���� ǥ��)
SELECT * 
FROM employees
    JOIN jobs USING(job_id)
WHERE job_title NOT IN ('President')
;

--3. �μ���ȣ, �μ���, �μ��� �޿��Ѿװ� ��ձ޿��� ����Ͻÿ�.
--��, �޿��Ѿ��� ���� ������ �����ϰ�, 
--��ձ޿��� �Ҽ��� ���� 1 �ڸ����� ��Ÿ������ �ݿø��ؾ� �Ѵ�.
SELECT e.department_id, d.department_name, sum(e.salary), round(avg(e.salary),1)
FROM employees e
    INNER JOIN departments d
    ON e.department_id = d.department_id
GROUP BY e.department_id, d.department_name
ORDER BY sum(e.salary)asc;

--4. 'Seattle', 'Toronto'���ÿ�  �ٹ��ϴ� 
--������� ���ø�,���, �̸�, �μ�ID, �μ��� �� ����Ͻÿ�
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
--5. 'Seattle'�� ������ ������ �μ��� ������� 5��̸��� 
--���ø�, �μ�ID, �μ���, ������� ����Ͻÿ� 
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

--6. �μ�ID�� 50 �̰ų� 80�� �μ��� �ٹ��ϴ� ������� ����ID�� ��å(job_title)�� ����Ͻÿ�.
--������� ����(job_id)�� �ߺ��� �����Ͻÿ� --5��
SELECT DISTINCT j.job_id, j.job_title
FROM employees e
    INNER JOIN departments d
    ON e.department_id = d.department_id
    INNER JOIN jobs j
    ON e.job_id = j.job_id
WHERE e.department_id in (50, 80)    
;
--7. ����� ���, �����ڹ�ȣ, �μ�ID, �μ���, �μ���ID�� ����Ͻÿ�
select * from employees;
select * from departments;

SELECT e.employee_id, e.manager_id, d.department_id,d.department_name, d.manager_id
FROM employees e
    INNER JOIN departments d
    ON e.department_id = d.department_id
;    

--8. ����� ���, �����ڹ�ȣ, �μ�ID, �μ���, �μ���ID�� ����Ͻÿ�. ��, �μ����� �����, ����� ���� �μ��� ����Ѵ�
SELECT e.employee_id, e.manager_id, d.department_id,d.department_name, d.manager_id
FROM employees e
    FULL OUTER JOIN departments d
    ON e.department_id = d.department_id
;
--9. ���� 'Davies'�� ����� �μ�ID�� �޿��� ����Ͻÿ�.
SELECT e.department_id, e.salary
FROM employees e
WHERE e.last_name = 'Davies'
;
--10. ���� 'Davies'�� ����� ���� �μ��� �ٹ��ϴ� ������� ���, ��, �̸��� ����Ͻÿ�--44��
--e.first_name = 'Davies'
SELECT e.employee_id, e.first_name, e.last_name
FROM employees e
    INNER JOIN departments d
    ON e.department_id = d.department_id
WHERE d.department_id = 50
AND e.last_name NOT IN 'Davies' 
;