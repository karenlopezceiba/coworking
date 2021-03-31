package com.ceiba.reserva.servicio;

import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionInexistencia;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioEliminarReservaTest {
	
	@Test
    public void validarEliminarReservaSinExistenciaPreviaTest() {
        // arrange
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarReserva servicioEliminarReserva = new ServicioEliminarReserva(repositorioReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarReserva.ejecutar(1L), ExcepcionInexistencia.class,"La reserva no existe en el sistema");
    }
	
	@Test
    public void validarEliminarReserva() {
        // arrange
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarReserva servicioEliminarReserva = new ServicioEliminarReserva(repositorioReserva);
        servicioEliminarReserva.ejecutar(Mockito.anyLong());
        // act - assert
        Mockito.verify(repositorioReserva, Mockito.times(1)).eliminar(Mockito.anyLong());
    }

}
