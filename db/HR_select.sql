select * from tab;

select 
    first_name||' '||last_name as 성명,
    salary as 급여,
    12*(salary + salary*nvl(commission_pct,0))
from employees;

SELECT
    *
FROM employees;