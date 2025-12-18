# Write your MySQL query statement below
SELECT customer_id, COUNT(*) count_no_trans
FROM Visits v
lEFT JOIN Transactions t USING(visit_id)
where transaction_id IS NULL
group by customer_id
ORDER BY customer_id ASC