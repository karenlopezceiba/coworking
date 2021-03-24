CREATE TABLE sala
(
    id serial,
    total_puestos bigint NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE reserva (
	id serial,
	identificacion_persona varchar(30) not null,
	fecha_reserva timestamp not null,
	valor_pago bigint not null,
	estado boolean,
	PRIMARY KEY (id)
);

INSERT INTO sala(
	id, total_puestos)
	VALUES (1, 12);
	