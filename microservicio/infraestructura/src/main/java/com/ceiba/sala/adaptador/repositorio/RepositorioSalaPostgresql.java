package com.ceiba.sala.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.sala.modelo.entidad.Sala;
import com.ceiba.sala.puerto.repositorio.RepositorioSala;

@Repository
public class RepositorioSalaPostgresql implements RepositorioSala{
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="sala", value="actualizar")
    private static String sqlActualizar;
	
	@SqlStatement(namespace="sala", value="existe")
    private static String sqlExiste;
	
	public RepositorioSalaPostgresql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		super();
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public void actualizar(Sala sala) {
		this.customNamedParameterJdbcTemplate.actualizar(sala, sqlActualizar);
		
	}

	@Override
	public boolean existe(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
	}

}
