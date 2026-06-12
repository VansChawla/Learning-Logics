SELECT 
    m.employee_id, 
    m.name, 
    COUNT(e.employee_id) AS reports_count, 
    ROUND(AVG(e.age)) AS average_age
FROM EMPLOYEES E
JOIN EMPLOYEES M
ON e.reports_to = m.employee_id
GROUP BY M.EMPLOYEE_ID, M.NAME
ORDER BY m.employee_id;