select *
from reserva r  inner join persona p 
on r.identificacion_persona = p.id
where identificacion_persona = :idPersona and estado = 'true';
