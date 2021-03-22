package com.ceiba.sala.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.*;


import lombok.Getter;


@Getter
public class Sala {
	
    private static final String SE_DEBE_INGRESAR_EL_TOTAL_DE_PUESTOS = "Se debe ingresar el total de puestos de trabajo";
    private static final String SE_DEBE_INGRESAR_EL_TOTAL_DE_PUESTOS_DISPONIBLES = "Se debe ingresar el total de puestos de trabajo disponibles";
	private static final String PUESTOS_DISPONIBLES_DEBE_SER_MENOR_AL_TOTAL_DE_PUESTOS = "El numero de puestos disponibles no puede ser mayor al total de puestos de trabajo";
    
	private Long id;
	private Integer totalPuestosTrabajo; 
	private Integer puestosDisponibles;
	
	public Sala(Long id, Integer totalPuestosTrabajo, Integer puestosDisponibles){
		 validarObligatorio(totalPuestosTrabajo, SE_DEBE_INGRESAR_EL_TOTAL_DE_PUESTOS);
		 validarObligatorio(puestosDisponibles, SE_DEBE_INGRESAR_EL_TOTAL_DE_PUESTOS_DISPONIBLES);
		 validarMenor(puestosDisponibles.longValue(),totalPuestosTrabajo.longValue(),PUESTOS_DISPONIBLES_DEBE_SER_MENOR_AL_TOTAL_DE_PUESTOS);
		 this.id = id;
		 this.puestosDisponibles = puestosDisponibles;
		 this.totalPuestosTrabajo = totalPuestosTrabajo;
	}
	
}
