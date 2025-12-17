# Write your MySQL query statement below
select activity_date day        , count(distinct user_id) active_users
FROM activity
where activity_date > "2019-06-27" AND activity_date <= "2019-07-27"
GROUP BY activity_date
