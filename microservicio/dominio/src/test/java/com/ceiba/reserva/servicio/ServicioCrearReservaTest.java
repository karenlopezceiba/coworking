package com.ceiba.reserva.servicio;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionInexistencia;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;

public class ServicioCrearReservaTest {
	
	private static final Long MAX_VALUE_CONCURRENCIA =  1000000000L;
	
	@Test
    public void validarReservaExistenciaPreviaTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class,"La reserva ya existe en el sistema");
    }
	
	@Test
    public void validarReservaSinExistenciaPreviaTest() {
        // arrange
        LocalDate fecha = LocalDate.now().plusWeeks(1L);
        Reserva reserva = new ReservaTestDataBuilder().conFecha(fecha).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioReserva.crear(Mockito.anyObject())).thenReturn(1L);
        Mockito.when(repositorioReserva.concurrencia(Mockito.anyObject())).thenReturn(1L);
        Mockito.when(repositorioReserva.aforo()).thenReturn(2L);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        // act - assert
        Assert.assertNotNull("La reserva no ha podido ser creada", servicioCrearReserva.ejecutar(reserva));
    }
	
	@Test(expected = ExcepcionValorInvalido.class)
    public void validarNoHacerReservaDomingosTest() {
        // arrange
		LocalDate fecha = LocalDate.now().plusDays(7 - LocalDate.now().getDayOfWeek().getValue()); 
        Reserva reserva = new ReservaTestDataBuilder().conFecha(fecha).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
         // act - assert
        Assert.assertNotNull("No se deben permitir reservas los Domingos", servicioCrearReserva.ejecutar(reserva));
        
	}
	
	@Test(expected = ExcepcionValorInvalido.class)
    public void validarNoHacerReservasFechasAnterioresTest() {
        // arrange
		LocalDate fecha = LocalDate.now().minusMonths(1L); 
        Reserva reserva = new ReservaTestDataBuilder().conFecha(fecha).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        // act - assert
        Assert.assertNotNull("No se deben permitir reservas para fechas pasadas", servicioCrearReserva.ejecutar(reserva));
	}
	
	@Test(expected = ExcepcionInexistencia.class)
    public void validarMaximaConcurrencia() {
        // arrange
		LocalDate fecha = LocalDate.now().plusWeeks(1L);
        Reserva reserva = new ReservaTestDataBuilder().conFecha(fecha).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.concurrencia(fecha)).thenReturn(MAX_VALUE_CONCURRENCIA);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
     // act - assert
        Assert.assertNotNull("Concurrencia dentro del limite", servicioCrearReserva.ejecutar(reserva));
	}
	
	@Test
    public void validarConcurrencia() {
        // arrange
		LocalDate fecha = LocalDate.now().plusWeeks(1L);
        Reserva reserva = new ReservaTestDataBuilder().conFecha(fecha).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.concurrencia(fecha)).thenReturn(1L);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioReserva.aforo()).thenReturn(2L);
        Mockito.when(repositorioReserva.crear(Mockito.anyObject())).thenReturn(1L);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        //act - assert
        Assert.assertNotNull("Concurrencia mas alla del limite", servicioCrearReserva.ejecutar(reserva));
	}
	
}
