SELECT MAX(SALARY)SecondHighestSalary 
FROM Employee
WHERE salary < (select MAX(SALARY) FROM EMPLOYEE)