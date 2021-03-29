package com.ceiba.reserva.adaptador.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.jdbc.core.RowMapper;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.persona.adaptador.dao.MapeoPersona;
import com.ceiba.persona.modelo.dto.DtoPersona;
import com.ceiba.reserva.modelo.dto.DtoReserva;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult{

	@Override
	public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Long id = resultSet.getLong("id");
		Long identificacionPersona =  resultSet.getLong("identificacion_persona");
		LocalDate fechaReserva = extraerLocalDate(resultSet, "fecha_reserva");
		boolean estado = resultSet.getBoolean("estado");
		BigDecimal valorAPagar = resultSet.getBigDecimal("valor_pago");
		DtoPersona dtoPersona = new MapeoPersona().mapRow(resultSet, rowNum);
		
		return new DtoReserva(id, identificacionPersona, fechaReserva, estado, valorAPagar, dtoPersona);
	}

}
