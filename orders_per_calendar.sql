select date_part('YEAR', order_date) as year, count(order_id) as num_orders
from orders
where order_date >= '1996-01-01'
group by year;