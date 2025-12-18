# Write your MySQL query statement bS
SELECT name, SUM(amount) balance
FROM Users u
JOIN transactions t USING(account)
GROUP BY account
HAVING SUM(amount) > 10000