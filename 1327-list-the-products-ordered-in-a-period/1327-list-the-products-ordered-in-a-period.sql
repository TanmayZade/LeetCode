# Write your MySQL query statement below
SELECT p.product_name product_name, SUM(o.unit) unit
FROM Products p
JOIN  Orders o using(product_id)
WHERE YEAR(o.order_date ) = '2020' AND MONTH(o.order_date) = '02'
GROUP BY p.product_id
HAVING SUM(o.unit) >= 100