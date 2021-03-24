package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionInexistencia;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {
	private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";
	private static final String NO_HAY_PUESTOS_DISPONIBLES = "No exiten puestos disponibles para reservar";
	private static final String LA_FECHA_DEBE_SER_VALIDA = "Solo se permiten reservas de lunes a sabado";


    private final RepositorioReserva repositorioReserva;

	public ServicioCrearReserva(RepositorioReserva repositorioReserva) {
		this.repositorioReserva = repositorioReserva;
	}
    
	public Long ejecutar(Reserva reserva){
		validarExistenciaPrevia(reserva);
		 if(reserva.fechaValida()){
			 validarPuestosDisponibles(reserva);
			 reserva.descuentoPorFecha();
			 return this.repositorioReserva.crear(reserva);
		 }else{
			 throw new ExcepcionValorInvalido(LA_FECHA_DEBE_SER_VALIDA);
		 }	
		
	}


	private void validarExistenciaPrevia(Reserva reserva){
		 boolean existe = this.repositorioReserva.existe(reserva.getId());
		 if(existe) {
	            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
		 }
	}
	
	 private void validarPuestosDisponibles(Reserva reserva){
		 Long concurrencia = this.repositorioReserva.concurrencia(reserva.getFechaReserva());
		 if(concurrencia > 50) {
	            throw new ExcepcionInexistencia(NO_HAY_PUESTOS_DISPONIBLES);
	        }

	 }

}
