SELECT
    e.employee_id AS "Employee ID",
    m.employee_id AS "Manager ID"
FROM
    EMPLOYEES e
LEFT JOIN
    EMPLOYEES m ON e.manager_id = m.employee_id
WHERE 
    m.employee_id IS NOT NULL
ORDER BY 
    e.employee_id;


