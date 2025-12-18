# Write your MySQL query statement below
select unique_id, name
FROM Employees e
LEFT JOIN EmployeeUNI eu USING(id)