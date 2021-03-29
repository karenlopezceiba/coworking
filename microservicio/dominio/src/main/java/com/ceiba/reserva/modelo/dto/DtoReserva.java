package com.ceiba.reserva.modelo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ceiba.persona.modelo.dto.DtoPersona;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoReserva {
	private Long id;
	private Long identificacionPersona;
	private LocalDate fechaReserva;
	private boolean estado;
	private BigDecimal valorAPagar;
	private DtoPersona persona;
	
}
