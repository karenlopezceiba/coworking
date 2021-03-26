package com.ceiba.persona.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
	public String crear(Persona persona) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacion", persona.getIdentificacion());
        paramSource.addValue("nombre", persona.getNombre());
        KeyHolder keyHolder = new GeneratedKeyHolder();
		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear,paramSource,keyHolder,new String[] { "identificacion" });
		return keyHolder.toString();
	}

	@Override
	public boolean existe(String identificacion) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", identificacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
	}

}
