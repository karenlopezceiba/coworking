package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {
	private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";
	private static final String NO_HAY_PUESTOS_DISPONIBLES = "No exiten puestos disponibles para reservar";


    private final RepositorioReserva repositorioReserva;

	public ServicioCrearReserva(RepositorioReserva repositorioReserva) {
		this.repositorioReserva = repositorioReserva;
	}
    
	public Long ejecutar(Reserva reserva){
		validarExistenciaPrevia(reserva);
		validarPuestosDisponibles();
		Long id = this.repositorioReserva.crear(reserva);
		asignarSalaDisponible(id);
		return id;
	}
	
	 private void asignarSalaDisponible(Long id) {
		 try{
			 repositorioReserva.asignarSala(id);
		 	}catch (Exception e) {
			}
		 
	}

	private void validarExistenciaPrevia(Reserva reserva){
		 boolean existe = this.repositorioReserva.existe(reserva.getId());
		 if(existe) {
	            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
	        }

	 }
	 
	 private void validarPuestosDisponibles(){
		 boolean existe = this.repositorioReserva.existePuesto();
		 if(!existe) {
	            throw new ExcepcionDuplicidad(NO_HAY_PUESTOS_DISPONIBLES);
	        }

	 }

}
