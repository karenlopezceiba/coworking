select *, identificacion, nombre
from reserva r  inner join persona p 
on r.identificacion_persona = p.identificacion
where identificacion_persona = :idPersona and estado = 'true';
