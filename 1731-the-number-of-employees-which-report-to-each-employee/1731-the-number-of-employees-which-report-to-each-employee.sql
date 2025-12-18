SELECT mgr.employee_id, mgr.name, count(emp.employee_id) as reports_count, ROUND(AVG(emp.age)) average_age
FROM employees emp
JOIN employees mgr ON emp.reports_to = mgr.employee_id
GROUP BY mgr.employee_id
order by mgr.employee_id