package com.ceiba.reserva.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

@Repository
public class RepositorioReservaPostgresql implements RepositorioReserva{
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="reserva", value="crear")
    private static String sqlCrear;
    
    @SqlStatement(namespace="reserva", value="eliminar")
    private static String sqlEliminar;
    
    @SqlStatement(namespace="reserva", value="asignarSala")
    private static String sqlAsignarSala;
    
    @SqlStatement(namespace="reserva", value="existe")
    private static String sqlExiste;
    
    @SqlStatement(namespace="reserva", value="existePuesto")
    private static String sqlExistePuesto;
    
	public RepositorioReservaPostgresql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Reserva reserva) {
		return this.customNamedParameterJdbcTemplate.crear(reserva, sqlCrear);
	}

	@Override
	public void asignarSala(Long idReserva) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idReserva);
        
		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlAsignarSala,paramSource, Long.class);
	}

	@Override
	public void eliminar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);

	}

	@Override
	public boolean existe(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
	}

	@Override
	public boolean existePuesto() {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePuesto,paramSource, Boolean.class);
	}

}
