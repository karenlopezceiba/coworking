package com.ceiba.Reserva.servicio.testdatabuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.reserva.comando.ComandoReserva;

public class ComandoReservaTestBuilder {
	
	private Long id;
	private Long identificacionPersona;
	private LocalDate fechaReserva;
	private BigDecimal valorAPagar;
	private boolean estado;
	private ComandoPersona persona;
	
	public ComandoReservaTestBuilder() {
		persona = new ComandoPersona(123451L, "karen lopez");
		fechaReserva = LocalDate.now().plusDays(2L);
		valorAPagar = new BigDecimal("10000");
		estado = true;
		identificacionPersona = 123451L;
	}
	
	public ComandoReservaTestBuilder conId(Long id) {
        this.id = id;
        return this;
    }
	
	public ComandoReservaTestBuilder conIdentificacionPersona(Long identificacionPersona) {
        this.identificacionPersona = identificacionPersona;
        return this;
    }
	
	public ComandoReservaTestBuilder conFecha(LocalDate fecha) {
        this.fechaReserva = fecha;
        return this;
    }
	
	public ComandoReservaTestBuilder conValorPago(BigDecimal valorAPagar) {
        this.valorAPagar = valorAPagar;
        return this;
    }
	
	public ComandoReservaTestBuilder conIsEstado(boolean estado) {
        this.estado = estado;
        return this;
    }
	
	public ComandoReserva build(){
		return new ComandoReserva(id, identificacionPersona,fechaReserva, estado, valorAPagar, persona);
	}
	
	public static ComandoReservaTestBuilder unaReservaBuilder(){
		return new ComandoReservaTestBuilder();
	}

}


