package com.ceiba.reserva.puerto.repositorio;

import java.time.LocalDateTime;

import com.ceiba.reserva.modelo.entidad.Reserva;

public interface RepositorioReserva {
	
	/**
     * Permite crear una reserva
     * @param reserva
     * @return el id generado
     */
    Long crear(Reserva reserva);
    
    /**
     * Permite asignar una sala a una reserva
     * @param idReserva
     * @return el id de la sala asignada
     */
    void asignarSala(Long idReserva);
    
    /**
     * Permite eliminar una reserva
     * @param id
     */
    void eliminar(Long id);
    
    /**
     * Permite validar si existe una reserva 
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);
    
    /**
     * Permite validar si hay puestos disponibles para reservar
     * @return si existe o no
     */
    Long concurrencia(LocalDateTime fecha);


}
