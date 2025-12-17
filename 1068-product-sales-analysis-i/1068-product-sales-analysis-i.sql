# Write your MySQL query statement below
select product_name, year, price
FROM Sales s
JOIN Product p on s.product_id = p.product_id
