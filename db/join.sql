SELECT a.employee_id, b.employee_id
FROM employees a, employees b;
-- īƼ�� ���δ�Ʈ

SELECT a.employee_id, b.employee_id
FROM employees a, employees b
WHERE b.employee_id = a.employee_id;
-- īƼ�� ���δ�Ʈ
-- īƼ�� ���δ�Ʈ�� ���Ϸ��� ������ ������ ��� �Ѵ�.

-- ����� ���, ����, �μ���ȣ, �μ����� ����Ͻÿ�.
SELECT * 
FROM employees e, departments d
where e.department_id= d.department_id;
----------------------------------------------------
-- ǥ��(ANSI)�� Oracle ���� INNER JOIN�� ������ �Ȱ���.

-- NATURAL JOIN
SELECT department_id
FROM employees NATURAL JOIN departments;
-- Natural Join : �� ���̺��� ���� ���� �÷��� ��� ã�Ƽ� ���� : �� ����
SELECT e.department_id, d.department_id
FROM employees e NATURAL JOIN departments d;
-- Natural Join �� ��Ī�� ����ؼ��� �ȵȴ�.

-- JOIN USING
SELECT department_id
FROM employees JOIN departments
USING(department_id);

SELECT e.department_id, d.department_id
FROM employees e JOIN departments d
USING(department_id);
-- Join Using �� ��Ī�� ����ؼ��� �ȵȴ�.

-- JOIN ON(ANSI) : ���̺� Alias SELECT���� ��� �� ����
SELECT *
FROM employees e JOIN departments d
on (employees.department_id = departments.department_id);
  -- �帧�� Alias : FROM -> ON -> ...
  -- on���� Alias����ϴ� ���� ����.

SELECT *
FROM employees e JOIN departments d
on (e.department_id = d.department_id);

select * 
from employees e
join employees m on (e.manager_id = m.employee_id)
and m.salary >= 5000; -- where ���� ����ؼ� ����ϴ� and

select * 
from employees e, employees m
where e.manager_id = m.employee_id
and e.salary >= 5000;



