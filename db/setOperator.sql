-- ป็ฟ๘ภว ป็น๘, ว๖ภ็ ม๗นซน๘ศฃ, ภฬภü ม๗นซน๘ศฃธฆ รโทยวฯฝรฟภ
-- ดÜ, ภฬภü ม๗นซฐก พ๘ดย ป็ฟ๘ตต รโทยวัดู.
SELECT 
      e.employee_id
    , e.job_id "ว๖ภ็ ม๗นซน๘ศฃ"
    , h.job_id "ภฬภü ม๗นซน๘ศฃ"
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
;-- มธณช ณํธฎภ๛ภธทฮ ภ฿ธ๘ตศ ฤ๕ธฎ

---------------------------------------------
-- วีมýวี : UNION ALL / UNION
-- UNION : ม฿บนมฆฐลฟอ Sorted
SELECT employee_id "ป็น๘1" , job_id "พ๗นซ1"
FROM employees
UNION
SELECT employee_id "ป็น๘2", job_id "พ๗นซ2"
FROM job_history
;-- Heading Column ฎcฎc!

-- UNION ALL : ม฿บนภฬฐว ธปฐว ฐม วีฤง, Sortingพศวิ
SELECT employee_id "ป็น๘1" , job_id "พ๗นซ1"
FROM employees
UNION ALL
SELECT employee_id "ป็น๘2", job_id "พ๗นซ2"
FROM job_history
;
-- ภฬภü พ๗นซฟอ ฐฐภบ ว๖ภ็ พ๗นซธฆ ดใด็วฯดย ป็ฟ๘ต้ภว ป็น๘, พ๗นซน๘ศฃธฆ รโทยวฯฝรฟภ.
SELECT employee_id "ป็น๘1" , job_id "พ๗นซ1"
FROM employees
INTERSECT
SELECT employee_id "ป็น๘2", job_id "พ๗นซ2"
FROM job_history
;
SELECT e.employee_id, e.job_id
FROM employees e
    LEFT OUTER JOIN job_history h
    ON (e.employee_id = h.employee_id)
WHERE e.job_id = h.job_id    
;
-- ว๖ภ็ พ๗นซฟอ ดูธฅ ภฬภü พ๗นซธฆ ดใด็ว฿ด๘ ป็ฟ๘ต้ภว ป็น๘, ภฬภü พ๗นซธฆ รโทยวฯฝรฟภ.
SELECT employee_id "ป็น๘2", job_id "พ๗นซ2"
FROM job_history
MINUS
SELECT employee_id "ป็น๘1" , job_id "พ๗นซ1"
FROM employees
;
-- ภฬภü พ๗นซฐๆทยภฬ ภึดย ป็ฟ๘ภว ป็น๘ภป รโทยวฯฝรฟภ.
SELECT employee_id
FROM job_history
;

-- ภฬภü พ๗นซฐๆทยภฬ ภึดย ป็ฟ๘ภว ป็น๘ภป รโทยวฯฝรฟภ.
-- ป็น๘ภบ ม฿บนวฯม๖ พสดยดู.
SELECT UNIQUE employee_id
FROM job_history
;

-- ภฬภü พ๗นซ ฐๆทยภฬ พ๘ดย ป็ฟ๘ภว ป็น๘ภป รโทยวฯฝรฟภ.
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