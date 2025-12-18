# Write your MySQL query statement below
SELECT b.book_id, title, author, genre, pages, MAX(session_rating)-MIN(session_rating) rating_spread,
    ROUND((SUM(
        (CASE 
        WHEN r.session_rating <= 2 OR r.session_rating >= 4
        THEN 1
        ELSE 0
        END
        )
    ) * 1.0 / COUNT(*) ), 2)AS polarization_score
FROM books b
JOIN reading_sessions r USING(book_id)
GROUP BY book_id,title, author, genre, pages
HAVING COUNT(*) >= 5 AND MAX(r.session_rating) >= 4 AND MIN(r.session_rating) <= 2
ORDER BY polarization_score DESC, TITLE DESC