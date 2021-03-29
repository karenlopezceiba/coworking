package com.ceiba.persona.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.persona.modelo.dto.DtoPersona;

public class MapeoPersona implements RowMapper<DtoPersona>, MapperResult{

	@Override
	public DtoPersona mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Long id = resultSet.getLong("identificacion_persona");
		String nombre = resultSet.getString("nombre");
		
		return new DtoPersona(id, nombre);
	}

	
}
