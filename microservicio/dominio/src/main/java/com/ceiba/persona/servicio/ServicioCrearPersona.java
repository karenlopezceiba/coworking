package com.ceiba.persona.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;

public class ServicioCrearPersona {
	
	private static final String LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";
	
	private final RepositorioPersona repositorioPersona;

	public ServicioCrearPersona(RepositorioPersona repositorioPersona) {
		this.repositorioPersona = repositorioPersona;
	}
	
	public Long ejecutar(Persona persona){
		validarExistenciaPrevia(persona);
		return repositorioPersona.crear(persona);
	}
	
	private void validarExistenciaPrevia(Persona persona){
		 boolean existe = this.repositorioPersona.existe(persona.getIdentificacion());
		 if(existe) {
	            throw new ExcepcionDuplicidad(LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA);
		 }
	}
	

}
