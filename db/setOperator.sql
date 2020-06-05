-- ����� ���, ���� ������ȣ, ���� ������ȣ�� ����Ͻÿ�
-- ��, ���� ������ ���� ����� ����Ѵ�.
SELECT 
      e.employee_id
    , e.job_id "���� ������ȣ"
    , h.job_id "���� ������ȣ"
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
;-- ���� �������� �߸��� ����

---------------------------------------------
-- ������ : UNION ALL / UNION
-- UNION : �ߺ����ſ� Sorted
SELECT employee_id "���1" , job_id "����1"
FROM employees
UNION
SELECT employee_id "���2", job_id "����2"
FROM job_history
;-- Heading Column �c�c!

-- UNION ALL : �ߺ��̰� ���� �� ��ħ, Sorting����
SELECT employee_id "���1" , job_id "����1"
FROM employees
UNION ALL
SELECT employee_id "���2", job_id "����2"
FROM job_history
;
-- ���� ������ ���� ���� ������ ����ϴ� ������� ���, ������ȣ�� ����Ͻÿ�.
SELECT employee_id "���1" , job_id "����1"
FROM employees
INTERSECT
SELECT employee_id "���2", job_id "����2"
FROM job_history
;
SELECT e.employee_id, e.job_id
FROM employees e
    LEFT OUTER JOIN job_history h
    ON (e.employee_id = h.employee_id)
WHERE e.job_id = h.job_id    
;
-- ���� ������ �ٸ� ���� ������ ����ߴ� ������� ���, ���� ������ ����Ͻÿ�.
SELECT employee_id "���2", job_id "����2"
FROM job_history
MINUS
SELECT employee_id "���1" , job_id "����1"
FROM employees
;
-- ���� ��������� �ִ� ����� ����� ����Ͻÿ�.
SELECT employee_id
FROM job_history
;

-- ���� ��������� �ִ� ����� ����� ����Ͻÿ�.
-- ����� �ߺ����� �ʴ´�.
SELECT UNIQUE employee_id
FROM job_history
;

-- ���� ���� ����� ���� ����� ����� ����Ͻÿ�.
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