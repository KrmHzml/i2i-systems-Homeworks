SELECT
    e.employee_id,
    e.first_name,
    d.department_name
FROM
    EMPLOYEES e
INNER JOIN
    DEPARTMENTS d ON e.department_id = d.department_id;
