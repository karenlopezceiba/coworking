package com.ceiba.sala.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.sala.modelo.dto.DtoSala;


public class MapeoSala implements RowMapper<DtoSala>, MapperResult {

	@Override
	public DtoSala mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Long id = resultSet.getLong("id");
		Integer totalPuestosTrabajo = resultSet.getInt("total_puestos");		
		return new DtoSala(id, totalPuestosTrabajo);
	}

}
