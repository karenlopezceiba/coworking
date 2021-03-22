create table usuario (
 id serial,
 nombre varchar(100),
 clave varchar(45),
 fecha_creacion timestamp null,
 PRIMARY KEY (id)
);

CREATE TABLE sala
(
    id serial,
    total_puestos bigint NOT NULL,
    puestos_disponibles bigint NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE reserva (
	id serial,
	sala_id int,
	identificacion_persona varchar(30) not null,
	fecha_reserva timestamp not null,
	valor_pago bigint not null,
	estado boolean,
	PRIMARY KEY (id),
	CONSTRAINT fk_sala
      FOREIGN KEY(sala_id) 
	  REFERENCES sala(id)
);

INSERT INTO public.sala(
	id, total_puestos, puestos_disponibles)
	VALUES (1, 24, 24);

INSERT INTO public.sala(
	id, total_puestos, puestos_disponibles)
	VALUES (2, 14, 4);
	