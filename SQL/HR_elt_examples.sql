/************************
 * SIMULACRO DE PARCIAL *
 ************************/
# 01) Implementar el HR Oracle Demo Schema, sin la parte de EMPLOYEES, JOBS y JOB_HISTORY
# HINT: Usar autoincremental

# 02) Insertar datos en las distintas tablas (OPCIONAL: integridad referencial)

# 03) Realizar los listados entrecruzados de todos los datos

# 04) Contar los departamentos por país

select		countries.COUNTRY_NAME		as Country,
			count(departments.DEPARTMENT_ID)
										as Departments
					
from		departments
right join	locations
on			locations.LOCATION_ID		= departments.LOCATION_ID
left join	countries
on			countries.COUNTRY_ID		= locations.COUNTRY_ID
group by	countries.COUNTRY_ID
order by	Country;

# 05) Hacer una vista con la consulta del punto 4

create view	departments_per_country
as
	select		countries.COUNTRY_NAME		as Country,
				count(departments.DEPARTMENT_ID)
											as Departments
					
	from		departments
	right join	locations
	on			locations.LOCATION_ID		= departments.LOCATION_ID
	left join	countries
	on			countries.COUNTRY_ID		= locations.COUNTRY_ID
	group by	countries.COUNTRY_ID
	order by	Country;

select		*
from		departments_per_country;

# 06) Hacer un procedimiento de almacenado que de el alta de una región

create procedure
			hr_elt.sp_new_region(
											in p_region_name varchar(25)
			)
begin
	insert into	regions						(REGION_NAME)
    values		(p_region_name);
end;

call		sp_new_region('Antartica');

# 07) Incrementar el procedimiento del 6 así da el alta de un país
# HINT: Investigar como recuperar el último ID autoincremental creado

create procedure
			hr_elt.sp_new_country_and_region(
											in p_region_name	varchar(25),
											in p_country_name	varchar(40)
			)
begin
	insert into	regions						(REGION_NAME)
    values		(p_region_name);
    insert into	countries					(COUNTRY_NAME, REGION_ID)
    values		(p_country_name,(
									select	last_insert_id()
								)
	);
end;

# 08) Recuperar los 3 primeros países que mas localidades tiene



# 09) Recuperar todos los departamentos que están en alguna calle que contiene 'Street'
# HINT: '%Street%'

# 10) Investigar qué es una función y como se programa en MySQL

# 11) Investigar qué es una transacción y qué es un trigger

# 12) Investigar sobre cursores