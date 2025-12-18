# Write your MySQL query statement below
SELECT * 
FROM Users
WHERE CAST(mail as BINARY) REGEXP BINARY '^[A-Za-z]+[A-Za-z0-9._-]*@leetcode\\.com$'