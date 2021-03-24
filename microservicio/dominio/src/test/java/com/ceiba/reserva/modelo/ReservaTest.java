package com.ceiba.reserva.modelo;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;


public class ReservaTest {
	
	@Test
    public void validarFechaDomingo() {
        // arrange
		LocalDateTime fecha = LocalDateTime.now().plusDays(7 - LocalDateTime.now().getDayOfWeek().getValue());
		Reserva reserva = new ReservaTestDataBuilder().conFecha(fecha).build();
        // act 
		// assert
        Assert.assertFalse(reserva.fechaValida());
	}
	
	@Test
    public void validarFechaAnterior() {
        // arrange
		LocalDateTime fecha = LocalDateTime.now().minusMonths(1L);
		Reserva reserva = new ReservaTestDataBuilder().conFecha(fecha).build();
        // act 
		// assert
        Assert.assertFalse(reserva.fechaValida());
	}
	
	@Test
    public void validarFechaCorrecta() {
        // arrange
		LocalDateTime fecha = LocalDateTime.now().plusWeeks(1L);
		Reserva reserva = new ReservaTestDataBuilder().conFecha(fecha).build();
        // act 
		// assert
        Assert.assertTrue(reserva.fechaValida());
	}
	
	@Test
    public void validarDescuentoRealizado() {
        // arrange
		LocalDateTime fecha = LocalDateTime.now().plusWeeks(1L);
		BigDecimal valorAPagar = new BigDecimal("10000");
		Reserva reserva = new ReservaTestDataBuilder().conFecha(fecha).conValorPago(valorAPagar).build();
        // act 
		reserva.descuentoPorFecha();
		// assert
        Assert.assertEquals( new BigDecimal("9000"), reserva.getValorAPagar());
	}
	
	@Test
    public void validarDescuentoNoRealizado() {
        // arrange
		LocalDateTime fecha = LocalDateTime.now().plusDays(4L);
		BigDecimal valorAPagar = new BigDecimal("10000");
		Reserva reserva = new ReservaTestDataBuilder().conFecha(fecha).conValorPago(valorAPagar).build();
        // act 
		reserva.descuentoPorFecha();
		// assert
        Assert.assertEquals( new BigDecimal("10000"), reserva.getValorAPagar());
	}

}
