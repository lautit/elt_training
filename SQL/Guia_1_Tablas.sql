create table Club
(
    Club_Id int not null,
    Nombre varchar(15),
    Socios int,
    constraint PK_Club primary key(Club_Id)
);

insert into Club (Club_Id,Nombre,Socios) values (1,'Boca Juniors',40000);
insert into Club (Club_Id,Nombre,Socios) values (2,'River Plate',30000);
insert into Club (Club_Id,Nombre,Socios) values (3,'Racing Club',50000);
insert into Club (Club_Id,Nombre,Socios) values (4,'San Lorenzo',20000);
insert into Club (Club_Id,Nombre,Socios) values (5,'Independiente',15000);

create table Jugador
(
    Jugador_Id int not null,
    Nombre varchar(30),
    Edad int,
    Camiseta int,
    Puesto varchar(10),
    Club_Id int,
    constraint PK_Jugador primary key(Jugador_Id),
    constraint FK_Club foreign key(Club_Id) references Club(Club_Id)
);

insert into Jugador (Jugador_Id,Nombre,Edad,Camiseta,Puesto,Club_Id) values (1,'Juan Román Riquelme',28,18,'Volante',1);
insert into Jugador (Jugador_Id,Nombre,Edad,Camiseta,Puesto,Club_Id) values (2,'Hugo Ibarra',24,3,'Defensor',1);
insert into Jugador (Jugador_Id,Nombre,Edad,Camiseta,Puesto,Club_Id) values (3,'Agustin Orion',20,1,'Arquero',4);
insert into Jugador (Jugador_Id,Nombre,Edad,Camiseta,Puesto,Club_Id) values (4,'Pablo Caballero',22,10,'Delantero',3);
insert into Jugador (Jugador_Id,Nombre,Edad,Camiseta,Puesto,Club_Id) values (5,'Rodrigo Palacio',24,16,'Delantero',1);
insert into Jugador (Jugador_Id,Nombre,Edad,Camiseta,Puesto,Club_Id) values (6,'Juan Pablo Carrizo',22,17,'Arquero',2);
insert into Jugador (Jugador_Id,Nombre,Edad,Camiseta,Puesto,Club_Id) values (7,'Diego Cardoso',25,8,'Volante',2);
insert into Jugador (Jugador_Id,Nombre,Edad,Camiseta,Puesto,Club_Id) values (8,'Mauricio Caranta',34,1,'Arquero',1);
insert into Jugador (Jugador_Id,Nombre,Edad,Camiseta,Puesto,Club_Id) values (9,'Omar Merlo',24,13,'Defensor',2);
insert into Jugador (Jugador_Id,Nombre,Edad,Camiseta,Puesto,Club_Id) values (10,'Mauro Boselli',23,8,'Delantero',1);
insert into Jugador (Jugador_Id,Nombre,Edad,Camiseta,Puesto,Club_Id) values (11,'Diego Placente',28,4,'Defensor',4);
insert into Jugador (Jugador_Id,Nombre,Edad,Camiseta,Puesto,Club_Id) values (12,'Aureliano Torres',22,11,'Volante',4);
insert into Jugador (Jugador_Id,Nombre,Edad,Camiseta,Puesto,Club_Id) values (13,'Ariel Ortega',31,10,'Delantero',2);