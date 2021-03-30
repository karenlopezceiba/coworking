package com.ceiba.persona.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;

@Repository
public class RepositorioPersonaPostgresql implements RepositorioPersona{
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="persona", value="crear")
    private static String sqlCrear;

	@SqlStatement(namespace="persona", value="existe")
	private static String sqlExiste;

	 public RepositorioPersonaPostgresql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public void crear(Persona persona) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", persona.getId());
        paramSource.addValue("nombre", persona.getNombre());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, paramSource);
	}

	@Override
	public boolean existe(Long identificacion) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", identificacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
	}

}
