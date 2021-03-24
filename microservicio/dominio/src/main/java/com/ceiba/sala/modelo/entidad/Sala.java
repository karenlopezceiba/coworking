package com.ceiba.sala.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.*;


import lombok.Getter;


@Getter
public class Sala {
	
    private static final String SE_DEBE_INGRESAR_EL_TOTAL_DE_PUESTOS = "Se debe ingresar el total de puestos de trabajo";
   
	private Long id;
	private Integer totalPuestosTrabajo; 
	
	public Sala(Long id, Integer totalPuestosTrabajo){
		 validarObligatorio(totalPuestosTrabajo, SE_DEBE_INGRESAR_EL_TOTAL_DE_PUESTOS);
		 this.id = id;
		 this.totalPuestosTrabajo = totalPuestosTrabajo;
	}
	
}
