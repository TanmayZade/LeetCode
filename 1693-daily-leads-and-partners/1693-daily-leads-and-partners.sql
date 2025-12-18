# Write your MySQL query statement below
SELECT date_id, make_name, count(distinct lead_id) unique_leads, count(distinct partner_id) unique_partners
FROM DailySales
GROUP BY date_id, make_name