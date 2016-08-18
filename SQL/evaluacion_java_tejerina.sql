CREATE DATABASE evaluacion_java_tejerina; 

CREATE TABLE productos 
  ( 
     codigoproducto INT UNSIGNED NOT NULL AUTO_INCREMENT, 
     nombreproducto VARCHAR(70) NOT NULL, 
     precio         DECIMAL(10, 2) NOT NULL, 
     PRIMARY KEY (codigoproducto) 
  ); 

CREATE TABLE pedidos 
  ( 
     numeropedido INT UNSIGNED NOT NULL AUTO_INCREMENT, 
     fechapedido  DATE NOT NULL, 
     estado       VARCHAR(15) NOT NULL, 
     PRIMARY KEY (numeropedido) 
  ); 

CREATE TABLE pedidoitems 
  ( 
     numeropedido   INT UNSIGNED NOT NULL, 
     codigoproducto INT UNSIGNED NOT NULL, 
     cantidad       INT(11) NOT NULL, 
     PRIMARY KEY (numeropedido, codigoproducto), 
     KEY codigoproducto (codigoproducto), 
     CONSTRAINT fk_pedidoitems_pedido FOREIGN KEY (numeropedido) REFERENCES 
     pedidos (numeropedido), 
     CONSTRAINT fk_pedidoitems_producto FOREIGN KEY (codigoproducto) REFERENCES 
     productos (codigoproducto) 
  );

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (1,'Extra Strength Pain Relief',62.45); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (2,'Levothyroxine sodium',66.27); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (3,'Quinapril Hydrochloride and Hydrochlorothiazide',83.07); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (4,'Deb PureBac Foam Wash',35.14); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (5,'Donepezil Hydrochloride',40.5); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (6,'Olanzapine',96.03); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (7,'Univasc',98.95); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (8,'Oregano',23.75); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (9,'DIPYRIDAMOLE',18.13); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (10,'AIR COMPRESSED',0.39); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (11,'Retin-A MICRO',53.17); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (12,'BP Wash',44.46); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (13,'ibuprofen',38.67); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (14,'Sulfamethoxazole and Trimethoprim',28.34); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (15,'HAWAIIAN Tropic',57.96); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (16,'CELEBREX',1.36); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (17,'LEVOTHYROXINE SODIUM',55.28); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (18,'Candesartan Cilexetil and Hydrochlorothiazide',4.8); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (19,'Imipramine Hydrochloride',65.98); 

INSERT INTO productos 
            (codigoproducto,nombreproducto,precio) 
VALUES      (20,'INDIGESTION/GAS RELIEF',65.08); 