# Write your MySQL query statement below
SELECT product_id, "store1" store, store1 as price
FROM Products
where store1 IS NOT NULL
UNION ALL 
SELECT product_id, "store2" store, store2 as price
FROM Products
where store2 IS NOT NULL
UNION ALL 
SELECT product_id, "store3" store, store3 as price
FROM Products
where store3 IS NOT NULL

