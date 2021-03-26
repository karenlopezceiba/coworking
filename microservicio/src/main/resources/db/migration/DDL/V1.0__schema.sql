CREATE TABLE sala
(	id serial,
    total_puestos bigint NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE persona
(	identificacion varchar(30),
    nombre varchar(100) NOT NULL,
    PRIMARY KEY (identificacion)
);
CREATE TABLE reserva (
	id serial,
	identificacion_persona varchar(30) not null,
	fecha_reserva date not null,
	valor_pago bigint not null,
	estado boolean,
	PRIMARY KEY (id),
	CONSTRAINT fk_persona
      FOREIGN KEY(identificacion_persona) 
	  REFERENCES persona(identificacion)
);


INSERT INTO sala(
	id, total_puestos)
	VALUES (1, 12), (2, 6);
	