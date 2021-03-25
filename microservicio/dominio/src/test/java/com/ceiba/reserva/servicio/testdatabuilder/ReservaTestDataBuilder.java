package com.ceiba.reserva.servicio.testdatabuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ceiba.reserva.modelo.entidad.Reserva;

public class ReservaTestDataBuilder {
	
	private Long id;
	private String identificacionPersona;
	private LocalDate fechaReserva;
	private BigDecimal valorAPagar;
	private boolean estado;
	
	public ReservaTestDataBuilder() {
		identificacionPersona = "12345";
		fechaReserva = LocalDate.now();
		valorAPagar = new BigDecimal("10000");
		estado = true;
	}
	
	public ReservaTestDataBuilder conFecha(LocalDate fecha) {
        this.fechaReserva = fecha;
        return this;
    }
	
	public ReservaTestDataBuilder conValorPago(BigDecimal valorAPagar) {
        this.valorAPagar = valorAPagar;
        return this;
    }
	
	public Reserva build(){
		return new Reserva(id, identificacionPersona, fechaReserva, valorAPagar, estado);
	}

}
