package com.ceiba.reserva.comando;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ceiba.persona.comando.ComandoPersona;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva {
	
	private Long id;
	private String identificacionPersona;
	private LocalDate fechaReserva;
	private boolean estado;
	private BigDecimal valorAPagar;
	private ComandoPersona persona;
}
