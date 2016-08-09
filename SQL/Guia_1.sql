/* Ejercicio 1 */
select * from Jugador;
/* Ejercicio 2 */
select Nombre,Puesto from Jugador;
/* Ejercicio 3 */
select Nombre from Club where Socios>30000;
/* Ejercicio 4 */
select Nombre from Club where Socios>=30000;
/* Ejercicio 5 */
select Nombre,Edad from Jugador where Camiseta=8;
/* Ejercicio 6 */
select Nombre,Puesto from Jugador where Puesto in ('Defensor','Arquero');
/* Ejercicio 7 */
select * from Jugador where Nombre like 'Juan%';
/* Ejercicio 8 */
select Nombre,Edad,Puesto from Jugador order by Edad asc, Camiseta desc;
/* Ejercicio 9 */
insert into Club (Club_Id,Nombre,Socios) values (6,'Rosario Central',25000);
/* Ejercicio 10 */
insert into Jugador (Jugador_Id,Nombre,Edad,Camiseta,Puesto,Club_Id) values (14,'Ramiro Fassi',26,2,'Defensor',6);
select * from Jugador where Nombre='Ramiro Fassi';
/* Ejercicio 11 */
insert into Jugador (Jugador_Id,Nombre,Edad,Camiseta,Puesto,Club_Id) values (15,'Martín Palermo',28,9,'Delantero',23);
/** ERROR: fallo el foreign key, no existe club_id 23! */
/* Ejercicio 12 */
update Jugador set Camiseta=10 where Nombre like '%Román%';
select Nombre,Camiseta from Jugador where Nombre like '%Román%';
/* Ejercicio 13 */
update Jugador set Camiseta=12 where Puesto='Arquero';
select Nombre,Camiseta,Puesto from Jugador where Puesto='Arquero';
/* Ejercicio 14 */
update Jugador set Edad=Edad+1;
/* Ejercicio 15 */
delete from Jugador where Puesto='Volante';