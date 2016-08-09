/* listar todos los films del año 2006 */
select * from sakila.film where release_year=2006;

/* listar todos los costos de reemplazo sin duplicados */
select distinct replacement_cost from sakila.film;

/* listar el valor maximo del costo de reemplazo */
select max(replacement_cost) from sakila.film;

/* nombre de las peliculas con el max costo de reemplazo */
select * from sakila.film where replacement_cost=29.99;
/* con subconsutla */
select * from sakila.film where replacement_cost = (select max(replacement_cost) from sakila.film);

/* 2 maneras de buscar las 3 peliculas con costo de reemplazo mas alto */
select * from sakila.film order by replacement_cost desc limit 3;

/* contar la cantidad de peliculas segun tipo de rating */
select rating,count(film_id) as amount from sakila.film group by rating;

/* todas las peliculas del 2015 */
select * from sakila.film where year(last_update) = 2015;

/* todas las peliculas cuya fecha de actualizacion sea igual o menor a la actual */
select * from sakila.film where date(last_update) <= curdate();

/* todas las peliculas cuya fecha de actualizacion estan entre hoy y 1200 dias atras */
select * from sakila.film where date(last_update) between date(now() - interval 1200 day) and curdate();