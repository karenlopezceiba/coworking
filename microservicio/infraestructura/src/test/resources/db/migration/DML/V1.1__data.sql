INSERT INTO sala(
	total_puestos)
	VALUES (12);
INSERT INTO persona(
	identificacion, nombre)
	VALUES ('1234', 'karen'), ('12345', 'persona de prueba');
INSERT INTO reserva(
	id, identificacion_persona, fecha_reserva, valor_pago, estado)
	VALUES ('1', '1234', now(), '10000', true);
INSERT INTO reserva(
	id, identificacion_persona, fecha_reserva, valor_pago, estado)
	VALUES ('2', '12345', now(), '10000', true);