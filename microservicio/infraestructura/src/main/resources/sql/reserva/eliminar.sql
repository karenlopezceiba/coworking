UPDATE public.reserva
	SET estado = 'false'
	WHERE id = :id;