select id, identificacion_persona, fecha_reserva, valor_pago, estado
from reserva
where identificacion_persona = :idPersona and estado = 'true';
