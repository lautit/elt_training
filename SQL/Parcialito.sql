/************************************************************************************************
REALIZAR LAS SIGUIENTES CONSULTAS
1.       EMPLEADOS CON LA DIRECCION Y EL PAIS EN DONDE TRABAJAN
2.       EMPLEADOS CON LA DIRECCION Y EL NOMBRE DEL CLIENTE RELACIONADO
3.       EMPLEADOS CON EL NOMBRE DE SU SUPERVISOR
4.       EMPLEADOS CON LA CANTIDAD DE CLIENTES QUE CUENTA CADA UNO
5.       EL EMPLEADO QUE + CLIENTES TIENE
6.       LOS 3 PRODUCTOS + BARATOS
7.       EL MONTO TOTAL DE DINERO PAGADO POR CADA CLIENTE
8.       EL MONTO TOTAL DE DINERO PAGADO POR CADA CLIENTE CON EL NOMBRE DEL EMPLEADO RELACIONADO
9.       ACTUALIZAR EL PRECIO DE TODOS LOS PRODUCTOS EN UN 15%
10.      BORRAR TODAS LOS PAGOS DE LOS CLIENTES QUE SE ENCUENTRAN EN “NY” STATE

OPCIONALES
1.       LISTAR TODOS LOS CLIENTES QUE NUNCA REALIZARON UN PAGO
2.       LISTAR EL DETALLE DE UNA ORDEN CON EL PRODUCTO, CANTIDAD, PRECIO UNITARIO Y SUBTOTAL
3.       CREAR 3 CONSULTAS SQL LIBREMENTE UTILIZANDO LAS TABLAS
4.       CREAR UNA SP LIBREMENTE
************************************************************************************************/

# EJERCICIO 1
select		concat(employees.lastName, ', ', employees.firstName)		as Employee,
			offices.addressLine1										as Address,
            offices.country												as Country
from		employees
inner join	offices
on			employees.officeCode = offices.officeCode
order by	Employee;

# EJERCICIO 2
select		concat(employees.lastName, ', ', employees.firstName)		as Employee,
			offices.addressLine1										as Address,
            customers.customerName										as Customer
from		employees
inner join	offices
on			employees.officeCode = offices.officeCode
inner join	customers
on			employees.employeeNumber = customers.salesRepEmployeeNumber
order by	Employee;

# EJERCICIO 3
select		concat(employees.lastName, ', ', employees.firstName)		as Employee,
			concat(supervisors.lastName, ', ', supervisors.firstName)	as Supervisor
from		employees
inner join	employees													as supervisors
on			employees.reportsTo = supervisors.employeeNumber
order by	Supervisor;

# EJERCICIO 4
select		concat(employees.lastName, ', ', employees.firstName)		as Employee,
            count(customers.customerNumber)								as Customers
from		employees
left join	customers
on			employees.employeeNumber = customers.salesRepEmployeeNumber
group by	employees.employeeNumber
order by	Employee;

# EJERCICIO 5
select		concat(employees.lastName, ', ', employees.firstName)		as Employee,
            count(customers.customerNumber)								as Customers
from		employees
left join	customers
on			employees.employeeNumber = customers.salesRepEmployeeNumber
group by	employees.employeeNumber
order by	Customers													desc
limit		1;

# EJERCICIO 6
select		products.productName										as Product,
			products.buyPrice											as Price
from		products
order by	Price
limit		3;

# EJERCICIO 7
create view	order_subtotal
as
	select		(orderdetails.quantityOrdered * orderdetails.priceEach)	as subtotal,
				orderdetails.orderNumber								as orderNumber,
                orderdetails.productCode								as productCode
	from	orderdetails;

create view	order_total
as
	select		sum(order_subtotal.subtotal)							as total,
				order_subtotal.orderNumber								as orderNumber
	from		order_subtotal
	group by	orderNumber;

select		customers.customerName										as Customer,
			sum(order_total.total)										as Total
from		orders
inner join	customers
on			customers.customerNumber = orders.customerNumber
inner join	order_total
on			order_total.orderNumber = orders.orderNumber
group by	Customer
order by	Customer;

# EJERCICIO 8
select		customers.customerName										as Customer,
			sum(order_total.total)										as Total,
            concat(employees.lastName, ', ', employees.firstName)		as Employee
from		orders
inner join	customers
on			customers.customerNumber = orders.customerNumber
inner join	order_total
on			order_total.orderNumber = orders.orderNumber
inner join	employees
on			customers.salesRepEmployeeNumber = employees.employeeNumber
group by	Customer
order by	Customer;

# EJERCICIO 9
update		products
set			products.buyPrice = products.buyPrice * 1.15;

# EJERCICIO 10
delete from	payments
where		payments.customerNumber
in			(
	select		customers.customerNumber								as customerNumber
	from		customers
	where		customers.state = 'NY'
			);

select		*
from		payments
where		payments.customerNumber
in			(131,151,181,319,424,456); # NY Customers

# OPCIONAL 1
select		customers.customerName										as Customer
from		customers
where		customerNumber
not in		(
	select		payments.customerNumber									as customerNumber
	from		payments
	inner join	customers
	on			payments.customerNumber = customers.customerNumber
			);

# OPCIONAL 2
select		products.productName										as Product,
			orderdetails.quantityOrdered								as Quantity,
			orderdetails.priceEach										as UnitPrice,
			(orderdetails.quantityOrdered * orderdetails.priceEach)		as Subtotal
from		orderdetails
inner join	products
on			orderdetails.productCode = products.productCode
where		orderdetails.orderNumber = 10175
group by	Product
order by	orderdetails.orderLineNumber								asc;

# OPCIONAL 3
