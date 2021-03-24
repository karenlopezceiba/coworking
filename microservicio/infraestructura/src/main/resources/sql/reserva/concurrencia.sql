SELECT count(*) from reserva
where estado = 'true' and date(fecha_reserva) = :fecha