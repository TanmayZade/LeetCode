# Write your MySQL query st
select *, if((x+y > z) and (z+x>y) and (y+z>x) ,"Yes","No")as triangle from Triangle
