# Write your MySQL query statement below
SELECT MAX(num) num 
from
(SELECT num FROM MyNumbers group by num
having count(*) = 1) AS t