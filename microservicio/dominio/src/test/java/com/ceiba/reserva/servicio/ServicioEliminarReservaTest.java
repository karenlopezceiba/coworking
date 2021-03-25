package com.ceiba.reserva.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.dominio.excepcion.ExcepcionInexistencia;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioEliminarReservaTest {
	
	@Test(expected = ExcepcionInexistencia.class)
    public void validarReservaExistenciaPreviaTest() {
        // arrange
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarReserva servicioEliminarReserva = new ServicioEliminarReserva(repositorioReserva);
        servicioEliminarReserva.ejecutar(1L);
        // act - assert
        Assert.assertTrue("se estan eliminando reservas que no existen", false);
    }
	
	@Test
    public void validarEliminarReserva() {
        // arrange
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarReserva servicioEliminarReserva = new ServicioEliminarReserva(repositorioReserva);
        servicioEliminarReserva.ejecutar(Mockito.anyLong());
        // act - assert
        Assert.assertTrue("se estan eliminando reservas que no existen", true);
    }

}
