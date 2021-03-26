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

	@SqlStatement(namespace="reserva", value="existe")
	private static String sqlExiste;

	 public RepositorioPersonaPostgresql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Persona persona) {
		return this.customNamedParameterJdbcTemplate.crear(persona, sqlCrear);
	}

	@Override
	public boolean existe(String identificacion) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", identificacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
	}

}
