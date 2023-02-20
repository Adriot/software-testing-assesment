with orders_per_employee as (
	SELECT employees.employee_id, count(orders.order_id) as order_count
	FROM employees
	inner join orders
	on employees.employee_id = orders.employee_id
	group by employees.employee_id
)
select avg(order_count) repors_avarage
from orders_per_employee;

with orders_per_employeetwo as (
	SELECT employees.employee_id, count(orders.order_id) as order_count
	FROM employees
	inner join orders
	on employees.employee_id = orders.employee_id
	group by employees.employee_id
)
select count(employee_id) employees_with_reports_more_than_avarage
from orders_per_employeetwo
where order_count > (
	with orders_per_employee as (
		SELECT employees.employee_id, count(orders.order_id) as order_count
		FROM employees
		inner join orders
		on employees.employee_id = orders.employee_id
		group by employees.employee_id
	)
	select avg(order_count) order_avarage
	from orders_per_employee
);
