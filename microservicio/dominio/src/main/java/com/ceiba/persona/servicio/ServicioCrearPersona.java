package com.ceiba.persona.servicio;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;

public class ServicioCrearPersona {
		
	private final RepositorioPersona repositorioPersona;

	public ServicioCrearPersona(RepositorioPersona repositorioPersona) {
		this.repositorioPersona = repositorioPersona;
	}
	
	public boolean ejecutar(Persona persona){
		if(!existenciaPrevia(persona)){
			repositorioPersona.crear(persona);
			if(!existenciaPrevia(persona)) return false;
		}
		return true;
	}
	

	private boolean existenciaPrevia(Persona persona){
		 return this.repositorioPersona.existe(persona.getId());		
	}
	

}
