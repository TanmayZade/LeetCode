# Write your MySQL query statement below
select name, IFNULL(SUM(distance), 0)  travelled_distance
FROM Users u
LEFT JOIN Rides r ON r.user_id= u.id
GROUP BY r.user_id, u.name
ORDER BY travelled_distance DESC, u.name