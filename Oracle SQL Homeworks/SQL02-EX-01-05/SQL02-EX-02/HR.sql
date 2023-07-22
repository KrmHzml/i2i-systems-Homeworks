SELECT
    EMPLOYEE_ID,
    JOB_ID,
    DECODE(JOB_ID, 'AD_PRES', 'A',
                    'ST_MAN', 'B',
                    'IT_PROG', 'C',
                    'SA_REP', 'D',
                    'ST_CLERK', 'E',
                    NULL) AS "Grade"
FROM
    EMPLOYEES;



