package com.ceiba.persona.servicio.testdatabuilder;

import com.ceiba.persona.modelo.entidad.Persona;

public class PersonaTestDataBuilder {
	
	private String identificacion;
	private String nombre;
	
	public PersonaTestDataBuilder() {
		this.identificacion = "12345";
		this.nombre = "karen lopez";
	}
	
	public Persona build(){
		return new Persona(identificacion, nombre);
	}

}
