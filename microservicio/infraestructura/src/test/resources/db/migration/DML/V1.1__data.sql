INSERT INTO sala(
	id, total_puestos, puestos_disponibles)
	VALUES (1, 12, 12);
INSERT INTO reserva(
	id, sala_id, identificacion_persona, fecha_reserva, valor_pago, estado)
	VALUES ('1', '1', '1234', now(), '10000', true);