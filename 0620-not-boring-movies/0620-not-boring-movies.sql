# Write your MySQL query statement below
SELECT * 
FROM CINEMA
where id  % 2 = 1 AND description != 'boring'
ORDER BY rating desc