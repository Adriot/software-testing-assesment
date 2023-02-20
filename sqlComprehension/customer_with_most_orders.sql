with order_count as (
SELECT customers.contact_name, count(orders.order_id) as num_orders
FROM customers
inner join orders
on customers.customer_id = orders.customer_id
group by orders.customer_id, customers.contact_name
) 
select contact_name
from order_count
where num_orders = (
select max(num_orders) from order_count
);