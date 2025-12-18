# Write your MySQL query statement below
select employee_id
FROM Employees
LEFT JOIN Salaries USING(employee_id)
WHERE salary IS NULL OR name IS NULL

UNION 

SELECT employee_id 
FROM Employees
RIGHT JOIN Salaries USING(employee_id)
WHERE salary IS NULL OR name IS NULL

ORDER BY employee_id