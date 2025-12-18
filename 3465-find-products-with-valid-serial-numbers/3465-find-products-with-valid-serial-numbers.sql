# Write your MySQL query statement below
SELECT *
FROM Products
WHERE REGEXP_LIKE(description,'(^|[^A-Za-z0-9])SN[0-9]{4}-[0-9]{4}([^0-9]|$)','c')
ORDER BY Product_id