SELECT
    EMPLOYEE_ID,
    JOB_ID,
    CASE JOB_ID
        WHEN 'AD_PRES' THEN 'A'
        WHEN 'ST_MAN' THEN 'B'
        WHEN 'IT_PROG' THEN 'C'
        WHEN 'SA_REP' THEN 'D'
        WHEN 'ST_CLERK' THEN 'E'
        ELSE NULL
    END AS "Grade"
FROM
    EMPLOYEES;




