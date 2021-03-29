package com.ceiba.persona.servicio.testdatabuilder;

import com.ceiba.persona.modelo.entidad.Persona;

public class PersonaTestDataBuilder {
	
	private Long id;
	private String nombre;
	
	public PersonaTestDataBuilder() {
		this.id = 12345L;
		this.nombre = "karen lopez";
	}
	
	public Persona build(){
		return new Persona(id, nombre);
	}

}
