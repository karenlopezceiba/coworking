package com.ceiba.persona.modelo.entidad;

import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Persona {
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PERSONA = "Se debe ingresar el nombre de la persona";
	private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_IDENTIFICACION = "Se debe ingresar numero de identifacion de la persona";
	
	private String identificacion;
	private String nombre;
	
	public Persona(String identificacion, String nombre) {
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PERSONA);
		validarObligatorio(identificacion, SE_DEBE_INGRESAR_EL_NUMERO_DE_IDENTIFICACION);
		this.nombre = nombre;
		this.identificacion = identificacion;
	}

}
