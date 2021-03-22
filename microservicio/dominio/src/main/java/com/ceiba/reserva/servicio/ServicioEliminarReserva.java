package com.ceiba.reserva.servicio;

<<<<<<< HEAD
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
=======
>>>>>>> 6cfda8714dbfa5be46394c3fff81f49ee46578de
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioEliminarReserva {
	
	 private final RepositorioReserva repositorioReserva;
<<<<<<< HEAD
	 private static final String LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA = "La reserva no existe en el sistema";
=======
>>>>>>> 6cfda8714dbfa5be46394c3fff81f49ee46578de

	public ServicioEliminarReserva(RepositorioReserva repositorioReserva) {
		this.repositorioReserva = repositorioReserva;
	}
	 
	public void ejecutar(Long id) {
<<<<<<< HEAD
		validarExistenciaPrevia(id);
        this.repositorioReserva.eliminar(id);
    } 
	
	private void validarExistenciaPrevia(Long id){
		 boolean existe = this.repositorioReserva.existe(id);
		 if(!existe) {
	            throw new ExcepcionDuplicidad(LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA);
	        }

	 }
=======
        this.repositorioReserva.eliminar(id);
    } 
>>>>>>> 6cfda8714dbfa5be46394c3fff81f49ee46578de

}
