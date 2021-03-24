package com.ceiba.reserva.modelo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoReserva {
	private Long id;
	private String identificacionPersona;
	private LocalDateTime fechaReserva;
	private boolean estado;
	private BigDecimal valorAPagar;
	
}
