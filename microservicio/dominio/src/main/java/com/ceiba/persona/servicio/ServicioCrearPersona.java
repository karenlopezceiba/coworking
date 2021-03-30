package com.ceiba.persona.servicio;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;

public class ServicioCrearPersona {
		
	private final RepositorioPersona repositorioPersona;

	public ServicioCrearPersona(RepositorioPersona repositorioPersona) {
		this.repositorioPersona = repositorioPersona;
	}
	
	public void ejecutar(Persona persona){
		if(!existenciaPrevia(persona)){
			repositorioPersona.crear(persona);
		}
	}
	

	private boolean existenciaPrevia(Persona persona){
		 return this.repositorioPersona.existe(persona.getId());		
	}
	

}
