# Write your MySQL query st
SELECT *, IF((x+y > z) AND (y+z > x) AND (z+x > y),'Yes','No') triangle
FROM triangle;