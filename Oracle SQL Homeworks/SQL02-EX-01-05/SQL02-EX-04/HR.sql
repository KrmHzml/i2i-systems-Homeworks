SELECT
    LAST_NAME,
    DEPARTMENT_ID
FROM
    EMPLOYEES
WHERE
    DEPARTMENT_ID IN (
        SELECT DISTINCT DEPARTMENT_ID
        FROM EMPLOYEES
        WHERE INSTR(LAST_NAME, 'i') > 0
    );




