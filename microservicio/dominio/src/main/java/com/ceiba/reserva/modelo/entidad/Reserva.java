package com.ceiba.reserva.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Reserva {
	
	private static final String SE_DEBE_INGRESAR_IDENTIFICACION_DE_PERSONA = "Se debe ingresar una identificacion sobre la cual hacer la reserva";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_RESERVA = "Se debe ingresar la fecha de la reserva";
	private static final String SE_DEBE_INGRESAR_UN_VALOR_DE_PAGO = "Se debe ingresar el valor de la reserva";
    
	private Long id;
	private String identificacionPersona;
	private LocalDateTime fechaReserva;
	private boolean estado;
	private BigDecimal valorAPagar;
	private Long salaId;
	
	public Reserva(Long id, String identificacionPersona, LocalDateTime fechaReserva, BigDecimal valorAPagar, Long salaId) {
		validarObligatorio(identificacionPersona, SE_DEBE_INGRESAR_IDENTIFICACION_DE_PERSONA);
		validarObligatorio(fechaReserva, SE_DEBE_INGRESAR_LA_FECHA_DE_RESERVA);
		validarObligatorio(valorAPagar, SE_DEBE_INGRESAR_UN_VALOR_DE_PAGO);
		this.id = id;
		this.identificacionPersona = identificacionPersona;
		this.fechaReserva = fechaReserva;
		this.valorAPagar = valorAPagar;
		this.salaId = salaId;
	}
	
	

}
