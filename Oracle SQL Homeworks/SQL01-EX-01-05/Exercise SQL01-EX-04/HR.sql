CREATE TABLE EMP AS
SELECT * FROM EMPLOYEES;

INSERT INTO HR.EMP (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID)
VALUES (250, 'Erman', 'Ibrisim', 'erman@ibrisim', '5556783245', '09-10-2013', 'IT_PROG', 10000, NULL, NULL, NULL);

SELECT *
FROM
    EMP e
WHERE e.employee_id=250;

UPDATE EMP e
SET e.phone_number = '5328976541', e.salary = 15000
WHERE e.employee_id = 250;

SELECT *
FROM
    EMP e
WHERE e.employee_id=250;

DELETE FROM EMP e
WHERE e.employee_id = 250;

SELECT * FROM EMP;

DROP TABLE EMP;







