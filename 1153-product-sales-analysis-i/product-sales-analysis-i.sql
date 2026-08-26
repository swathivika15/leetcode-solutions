# Write your MySQL query statement below
select p.product_name , year , price from Product as p join sales as s on s.product_id=p.product_id;