--
--Tabla en la cual se almacenaran las ciudades
--
CREATE TABLE ciudad (
	id int8 not null,
	codigo varchar(255),
	estado varchar(255),
	nombre varchar(255),
	primary key (id)
);
--
-- Secuencia para el Id de la tabla Ciudad
--
create sequence ciudad_seq start 1 increment 1;