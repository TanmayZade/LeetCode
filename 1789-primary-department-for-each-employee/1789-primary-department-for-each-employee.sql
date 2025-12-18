# Write your MySQL query statement below
select employee_id, department_id
FROM employee 
WHERE primary_flag = 'Y' OR employee_id IN (SELECT employee_id from employee e1 group by e1.employee_id having count(e1.department_id) = 1)