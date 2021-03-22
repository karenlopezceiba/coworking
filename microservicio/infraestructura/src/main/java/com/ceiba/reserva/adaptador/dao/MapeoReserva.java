package com.ceiba.reserva.adaptador.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult{

	@Override
	public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Long id = resultSet.getLong("id");
		String identificacionPersona =  resultSet.getString("identificacion_persona");
		LocalDateTime fechaReserva = extraerLocalDateTime(resultSet, "fecha_reserva");
		boolean estado = resultSet.getBoolean("estado");
		BigDecimal valorAPagar = resultSet.getBigDecimal("valor_pago");
		Long salaId = resultSet.getLong("sala_id");
		return new DtoReserva(id, identificacionPersona, fechaReserva, estado, valorAPagar, salaId);
	}

}
