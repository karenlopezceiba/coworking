UPDATE public.reserva
	SET sala_id = (SELECT MIN(s.id) FROM sala s WHERE s.puestos_disponibles > 0)
	WHERE id = :id;