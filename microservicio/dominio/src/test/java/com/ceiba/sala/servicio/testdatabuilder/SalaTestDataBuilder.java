package com.ceiba.sala.servicio.testdatabuilder;

import com.ceiba.sala.modelo.entidad.Sala;

public class SalaTestDataBuilder {
	
	private Long id;
	private Integer totalPuestosTrabajo;
	
	public SalaTestDataBuilder() {
		this.id = 1L;
		this.totalPuestosTrabajo = 15;
	}
	
	public Sala build(){
		return new Sala(id, totalPuestosTrabajo);
	}

}
