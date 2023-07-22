SELECT
    Operator,
    COUNT(*) AS Total
FROM
    (SELECT
        CASE
            WHEN SUBSTR(PHONE_NUMBER, 1, 3) = '515' THEN '515'
            WHEN SUBSTR(PHONE_NUMBER, 1, 3) = '590' THEN '590'
            WHEN SUBSTR(PHONE_NUMBER, 1, 3) = '603' THEN '603'
            WHEN SUBSTR(PHONE_NUMBER, 1, 3) = '011' THEN '011'
            WHEN SUBSTR(PHONE_NUMBER, 1, 3) = '650' THEN '650'
        END AS Operator
    FROM
        EMPLOYEES
    ) t
GROUP BY
    Operator;

SELECT
    COUNT(CASE WHEN SUBSTR(phone_number, 1, 3) = '515' THEN 1 END) AS "515",
    COUNT(CASE WHEN SUBSTR(phone_number, 1, 3) = '590' THEN 1 END) AS "590", 
    COUNT(CASE WHEN SUBSTR(phone_number, 1, 3) = '603' THEN 1 END) AS "603",
    COUNT(CASE WHEN SUBSTR(phone_number, 1, 3) = '011' THEN 1 END) AS "011",
    COUNT(CASE WHEN SUBSTR(phone_number, 1, 3) = '650' THEN 1 END) AS "650"
FROM
    employees;


