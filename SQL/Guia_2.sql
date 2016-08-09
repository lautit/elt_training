/* Ejercicio 1 */
select distinct countrycode from world.city;
/* Ejercicio 2 */
select * from world.city where countrycode = 'ARG';
/* Ejercicio 3 */
select * from world.city where countrycode = 'ARG' order by name desc;
/* Ejercicio 4 */
select * from world.city where countrycode = 'ARG' or countrycode = 'USA' or countrycode = 'RUS' order by name;
/* Ejercicio 5 */
select name,district from world.city where population between 3000000 and 4000000;
/* Ejercicio 6 */
select name,district from world.city where population > 2000000;
/* Ejercicio 7 */
select count(id) as cities from world.city;
/* Ejercicio 8 */
select countrycode,count(id) as cities from world.city where countrycode = 'USA';
/* Ejercicio 9 */
select countrycode,sum(population) as population from world.city where countrycode = 'USA';
/* Ejercicio 10 */
select countrycode,sum(population) as population from world.city group by countrycode;
/* Ejercicio 11 */
select countrycode,avg(population) as avg_population from world.city where countrycode = 'RUS';