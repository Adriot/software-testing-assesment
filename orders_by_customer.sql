select count(orders.order_id) as num_orders
from customers
inner join orders
on customers.customer_id = orders.customer_id
inner join shippers
on orders.ship_via = shippers.shipper_id
where customers.company_name = 'Simons bistro' or customers.contact_name = 'Simons bistro'
and shippers.company_name = 'United Package';