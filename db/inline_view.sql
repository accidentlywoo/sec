-- INLINE VIEW

-- rownum : ���ȣ�� �˷��ִ� �ǻ��÷�
SELECT ROWNUM, employee_id, salary
FROM employees
WHERE salary > 10000
ORDER BY salary DESC
; -- ROWNUM �߱� ������ SELECT ���� : ROWNUM�� ���� ����
-- ó�� ����
-- FROM -> WHERE -> GROUP BY -> HAVING -> ROWNUM :: SELECT -> ORDER BY

-- �޿��� ���� ������� ����Ͻÿ�. �� ���ȣ�� ���� ����Ѵ�.
SELECT ROWNUM, a.*
FROM (SELECT employee_id, salary
        FROM employees
        WHERE salary > 10000
        ORDER BY salary DESC) a 
;
-- �޿��� ���� ������� ����Ͻÿ�. �� ���ȣ�� ���� ����Ѵ�.
-- 1~5������� ����Ѵ�. [TOP END Query]
SELECT ROWNUM, a.*
FROM (SELECT employee_id, salary
        FROM employees
        WHERE salary > 10000
        ORDER BY salary DESC) a 
WHERE ROWNUM <= 5      
;

-- �޿��� ���� ������� ����Ͻÿ�. �� ���ȣ�� ���� ����Ѵ�.
-- 5~10������� ����Ѵ�. [TOP END Query]
SELECT *
FROM (SELECT ROWNUM list, a.* -- Alias �������� ������ �ٱ����� ����ϱ� ��ƴ�.
        FROM (SELECT employee_id, salary
                FROM employees
                WHERE salary > 10000
                ORDER BY salary DESC) a 
        ) b
WHERE b.list BETWEEN 6 AND 10
;