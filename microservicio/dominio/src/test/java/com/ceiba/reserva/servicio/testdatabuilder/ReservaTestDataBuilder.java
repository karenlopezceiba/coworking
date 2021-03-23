package com.ceiba.reserva.servicio.testdatabuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ceiba.reserva.modelo.entidad.Reserva;

public class ReservaTestDataBuilder {
	
	private Long id;
	private String identificacionPersona;
	private LocalDateTime fechaReserva;
	private BigDecimal valorAPagar;
	private boolean estado;
	private Long salaId;	
	
	public ReservaTestDataBuilder() {
		identificacionPersona = "12345";
		fechaReserva = LocalDateTime.now();
		valorAPagar = new BigDecimal("10000");
		estado = true;
	}
	
	public ReservaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }
	
	public Reserva build(){
		return new Reserva(id, identificacionPersona, fechaReserva, valorAPagar, estado, salaId);
	}

}
