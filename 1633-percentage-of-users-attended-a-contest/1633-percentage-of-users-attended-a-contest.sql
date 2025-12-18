# Write your MySQL query statement below
SELECT contest_id,  ROUND(
    COUNT(DISTINCT r.user_id) * 100 /(Select COUNT(*) From users),2) percentage
FROM Users u
JOIN Register r USING(user_id)
GROUP BY contest_id
ORDER BY percentage DESC, contest_id