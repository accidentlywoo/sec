SELECT location_id, COUNT(department_id)
from departments
GROUP BY location_id;

select *
from employees;

select * 
from departments;
1. �޿��� 10000�̰ų�  14000�� ������� ���, �̸�(first_name), �޿��� �˻��Ͻÿ�.

2. first_name�� ��ҹ��ڱ�������('e', 'E')�� �����ϴ� ��� ����� �˻��Ͻÿ�

3. first_name�� 'J���� �����ϰ� n���ڸ� �����ϴ� ����� ���, �̸��� �˻��Ͻÿ�.
��)
��� 	�̸�
---------------------
110 John
139 John
145 John
181 Jean
189 Jennifer
200 Jennifer
---------------------
4. �޿��� 10000�̻��� ����� ���, �μ���ȣ, �̸�, �޿�, ������ ����Ͻÿ�.��, �μ���ȣ�� 30��,60��, 90���� �μ��� �����ϰ� ����� �˻��Ѵ�.

5. �޿��� 4000���� ���� ������� �μ��� �޿���ո� ����Ͻÿ�. �� �޿������ �Ҽ�������2�ڸ����� �ݿø��մϴ�.

6.�μ���ġ�� ���� ���� ����� �����ϰ� �μ��� �޿������ ����Ͻÿ�.�� �޿������ �Ҽ�������2�ڸ����� �ݿø��մϴ�.

7. �μ���ġ�� ���� ���� ����� �����ϰ� �޿������ 10000�̻��� �μ��� �޿������ ����Ͻÿ�.�� �޿������ �Ҽ�������2�ڸ����� �ݿø��մϴ�.  

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