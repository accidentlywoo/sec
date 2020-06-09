-- Scalar SubQuery : SELECT ��

-- 4. 'Seattle', 'Toronto'���ÿ�  �ٹ��ϴ� 
-- ������� ���ø�,���, �̸�, �μ�ID, �μ��� �� ����Ͻÿ�
SELECT *
FROM employees e
    JOIN departments d
    ON (e.department_id = d.department_id)
    JOIN locations l
    ON (d.location_id = l.location_id)
WHERE l.city IN ('Seattle', 'Toronto')
;
-- Scalar Query�� Main Query�� ���� ���谡 ������ ����� �� ����.
SELECT employee_id, first_name, department_id,
    (SELECT d.department_name FROM departments d
    WHERE d.department_id = e.department_id)    
FROM employees e
;

-- ������� ���, �̸�, �μ�ID, �μ���, ���ø��� ����Ͻÿ� : Scalar
SELECT e.employee_id, e.first_name, e.department_id,
    (SELECT d.department_name
        FROM departments d 
        WHERE d.department_id = e.department_id) as �μ���,
    (SELECT (SELECT l.city FROM locations l WHERE l.location_id = d.location_id) -- Main Table�� ���踦 �ξ�ߵǱ⶧����, �ߺ� �Ը���
        FROM departments d 
        WHERE d.department_id = e.department_id) as ���ø�
FROM employees e
;
-- ���� Ʃ��(SQL)�� ������ �غ��� ��ȹ�� ¥�ߵȴ�.

-- 4. 'Seattle', 'Toronto'���ÿ�  �ٹ��ϴ� 
-- ������� ���ø�,���, �̸�, �μ�ID, �μ��� �� ����Ͻÿ�. -> ��� ��Į�������� ���� �� �ֳ�?
SELECT e.employee_id, e.first_name, e.department_id,
    (SELECT d.department_name
        FROM departments d 
        WHERE d.department_id = e.department_id) as �μ���,
    (SELECT l.city as ���ø�
        FROM locations l 
        WHERE l.location_id= (SELECT l.location_id FROM departments d WHERE l.location_id = d.location_id)
        AND city IN ('Seattle', 'Toronto'))
FROM employees e
; -- ERROR �߻�

SELECT e.employee_id, e.first_name, e.department_id,
    (SELECT d.department_name
        FROM departments d 
        WHERE d.department_id = e.department_id) as �μ���,
    (SELECT (SELECT l.city FROM locations l WHERE l.location_id = d.location_id)
        FROM departments d 
        WHERE d.department_id = e.department_id) as ���ø�
FROM employees e
WHERE e.department_id IN (SELECT d.department_id
                        FROM departments d
                        WHERE d.location_id IN (SELECT l.location_id
                                                FROM locations l
                                                WHERE l.city IN ('Seattle', 'Toronto')
                                                )
                        )
;        
