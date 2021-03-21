package com.ceiba.sala.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.sala.modelo.entidad.Sala;
import com.ceiba.sala.puerto.repositorio.RepositorioSala;

public class ServicioActualizarSala {
	
	private static final String LA_SALA_NO_EXISTE_EN_EL_SISTEMA = "La sala no existe en el sistema";
	
	 private final RepositorioSala repositorioSala;

	public ServicioActualizarSala(RepositorioSala repositorioSala) {
		this.repositorioSala = repositorioSala;
	}
	
	public void ejecutar(Sala sala){	 
		validarExistenciaPrevia(sala);
        this.repositorioSala.actualizar(sala);
	}

	private void validarExistenciaPrevia(Sala sala) {
		 boolean existe = this.repositorioSala.existe(sala.getId());
	        if(!existe) {
	            throw new ExcepcionDuplicidad(LA_SALA_NO_EXISTE_EN_EL_SISTEMA);
	        }
	}
	 
}
