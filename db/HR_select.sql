select * from tab;

select 
    first_name||' '||last_name as ����,
    salary as �޿�,
    12*(salary + salary*nvl(commission_pct,0))
from employees;

SELECT
    *
FROM employees;