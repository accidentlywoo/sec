SELECT a.employee_id,  b.employee_id
FROM employees a, employees b;

SELECT a.employee_id,  b.employee_id
FROM employees a, employees b
WHERE a.employee_id = b.employee_id;
---------------------------------------
SELECT employee_id, department_id FROM employees;
SELECT * FROM departments;

--����� ���, ����, �μ���ȣ, �μ����� ����Ͻÿ�
SELECT employee_id, first_name, last_name
      ,e.department_id, department_name
FROM employees e, departments d
WHERE e.department_id =  d.department_id;
----------------------------------------------
--ǥ��ȭ�� JOIN
--Natural Join 
SELECT employee_id, first_name, last_name
      , department_id, department_name
FROM employees NATURAL JOIN  departments; 

--Join USING�� 
SELECT employee_id, first_name, last_name
      , department_id, department_name
FROM employees JOIN  departments USING(department_id); 

--Join ON��
SELECT employee_id, first_name, last_name
      , e.department_id ����μ���ȣ,  d.department_id �μ���ȣ,
      department_name
FROM  employees e JOIN departments d
ON (e.department_id = d.department_id);

--����� ���, �̸�, �μ���ȣ, �μ���, �μ��� ���� ���ø��� ����Ͻÿ�
SELECT e.employee_id,   e.first_name
     , d.department_id, d.department_name
     , l.city
FROM employees e 
     JOIN departments d ON(e.department_id = d.department_id)
     JOIN locations l ON(d.location_id = l.location_id);

--����� ���, �̸�, �μ���, �������� ����Ͻÿ�
SELECT  employee_id
, department_name
, job_title
FROM employees e
     JOIN departments d ON (e.department_id = d.department_id)
     JOIN jobs j ON (e.job_id = j.job_id);

--�μ��� ���� ���õ��� �μ���, ���ø��� ����Ͻÿ�
SELECT department_name, city
FROM departments NATURAL JOIN locations;

--SELF JOIN
--���, ����, �����ڹ�ȣ
SELECT e.employee_id ���, e.first_name||' '||e.last_name ����,
       e.manager_id �����ڹ�ȣ
       ,m.first_name||' '||m.last_name �����ڼ���       
FROM employees e
     JOIN employees m ON (e.manager_id = m.employee_id );

--�޿��� 5000�̻��� ����� ���, ����, �����ڹ�ȣ, �����ڼ����� ����Ͻÿ�
SELECT e.employee_id ���, e.first_name||' '||e.last_name ����,
       e.manager_id �����ڹ�ȣ
       ,m.first_name||' '||m.last_name �����ڼ���       
FROM employees e
     JOIN employees m ON (e.manager_id = m.employee_id )
WHERE e.salary >= 5000;

--����� �����ڰ� �ٸ��μ����� �ٹ��ϴ� �������
-- ���, ����, �μ���, �����ڹ�ȣ, �����ڼ���, �����ںμ����� ����Ͻÿ�
SELECT e.employee_id ���
     , e.first_name||' '||e.last_name ����
     , ed.department_name "�μ���"
     , e.manager_id �����ڹ�ȣ
     , m.first_name||' '||m.last_name �����ڼ���
     , md.department_name "�����ںμ���"
FROM employees e
     JOIN employees m ON (e.manager_id = m.employee_id )
     JOIN departments ed ON (e.department_id = ed.department_id)
     JOIN departments md ON (m.department_id = md.department_id)
WHERE ed.department_id <> md.department_id;     

--�����ڱ޿����� ���� �޿��� �޴� �����
--���, ����, �޿�, �����ڹ�ȣ, �����ڼ���, �����ڱ޿��� ����Ͻÿ�
SELECT e.employee_id ���, e.first_name||' '||e.last_name ����
      ,e.salary �޿�
      ,m.employee_id �����ڹ�ȣ, m.first_name||' '||m.last_name �����ڼ���
      ,m.salary �����ڱ޿�
FROM employees e
     JOIN employees m ON (e.manager_id = m.employee_id)
WHERE e.salary > m.salary;     

------------------------------------
--����� ���, �μ���ȣ, �μ����� ����Ͻÿ�--106��
SELECT employee_id, e.department_id, department_name
FROM employees e INNER JOIN departments d ON (e.department_id = d.department_id);

--OUTER JOIN
--����� ���, �μ���ȣ, �μ����� ����Ͻÿ�--107��
--�μ���ġ���� ���� ����� ����Ѵ�
SELECT employee_id, e.department_id, department_name
FROM employees e LEFT OUTER JOIN departments d ON (e.department_id = d.department_id);

--�μ���ȣ, �μ���, ���ø��� ����Ͻÿ�
--�μ��� ���� ���õ� ����Ѵ�
SELECT department_name, city
FROM departments d RIGHT JOIN locations l ON (d.location_id = l.location_id);

SELECT NVL(department_name, '�μ�����'), city
FROM departments d RIGHT JOIN locations l ON (d.location_id = l.location_id);
