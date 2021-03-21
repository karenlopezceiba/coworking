package com.ceiba.sala.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoSala {
	 private Long id;
	 private Integer totalPuestosTrabajo; 
	 private Integer puestosDisponibles;
}
