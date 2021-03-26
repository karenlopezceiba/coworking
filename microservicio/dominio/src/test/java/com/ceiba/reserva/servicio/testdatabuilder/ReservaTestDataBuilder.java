package com.ceiba.reserva.servicio.testdatabuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.reserva.modelo.entidad.Reserva;

public class ReservaTestDataBuilder {
	
	private Long id;
	private LocalDate fechaReserva;
	private BigDecimal valorAPagar;
	private boolean estado;
	private String identificacionPersona;
	private Persona persona;
	
	public ReservaTestDataBuilder() {
		persona = new Persona("12345", "karen lopez");
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
		return new Reserva(id, fechaReserva, valorAPagar, estado, identificacionPersona, persona);
	}

}
