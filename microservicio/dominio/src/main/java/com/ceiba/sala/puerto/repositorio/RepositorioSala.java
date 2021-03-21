package com.ceiba.sala.puerto.repositorio;

import com.ceiba.sala.modelo.entidad.Sala;

public interface RepositorioSala {
	
	/**
     * Permite actualizar una sala
     * @param sala
     */
    void actualizar(Sala sala);
    
    /**
     * Permite validar si existe una sala con un id
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);

}
