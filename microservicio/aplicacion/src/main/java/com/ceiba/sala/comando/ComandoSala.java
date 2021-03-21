package com.ceiba.sala.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSala {
	private Long id;
	private Integer totalPuestosTrabajo; 
	private Integer puestosDisponibles;
}
