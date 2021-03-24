package com.ceiba.Reserva.servicio.testdatabuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.ceiba.reserva.comando.ComandoReserva;

public class ComandoReservaTestBuilder {
	
	private Long id;
	private String identificacionPersona;
	private LocalDate fechaReserva;
	private BigDecimal valorAPagar;
	private boolean estado;
	private Long salaId;	
	
	public ComandoReservaTestBuilder() {
		identificacionPersona = "12345";
		fechaReserva = LocalDate.now();
		valorAPagar = new BigDecimal("10000");
		estado = true;
	}
	
	public ComandoReservaTestBuilder conId(Long id) {
        this.id = id;
        return this;
    }
	
	public ComandoReservaTestBuilder conIdentificacionPersona(String identificacionPersona) {
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
		return new ComandoReserva(id, identificacionPersona,LocalDateTime.parse(fechaReserva.toString() + "T00:00:00"), estado, valorAPagar, salaId);
	}
	
	public static ComandoReservaTestBuilder unaReservaBuilder(){
		return new ComandoReservaTestBuilder();
	}

}


