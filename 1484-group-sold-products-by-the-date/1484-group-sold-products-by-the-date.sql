# Write your MySQL query statement below
SELECT sell_date, Count( Distinct PRODUCT) num_sold, GROUP_CONCAT(DISTINCT product ORDER BY product) products
FROM Activities
GROUP BY sell_date
