package com.ceiba.reserva.adaptador.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;

@Component
public class DaoReservaPostgresql implements DaoReserva{
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="reserva", value="listar")
    private static String sqlListar;
  
	public DaoReservaPostgresql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}



	@Override
	public List<DtoReserva> listar(String identificacionPersona) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("idPersona", identificacionPersona);
		try {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, paramSource, new MapeoReserva());
		}catch (EmptyResultDataAccessException e) {
			throw new RuntimeException(e); 
        }
	}

}
