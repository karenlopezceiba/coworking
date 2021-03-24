package com.ceiba.sala.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.sala.modelo.entidad.Sala;
import com.ceiba.sala.puerto.repositorio.RepositorioSala;
import com.ceiba.sala.servicio.testdatabuilder.SalaTestDataBuilder;

public class ServicioActualizarSalaTest {
	
	
	@Test
    public void validarSalaExistenciaPreviaTest() {
        // arrange
        Sala sala = new SalaTestDataBuilder().build();
        RepositorioSala repositorioSala = Mockito.mock(RepositorioSala.class);
        Mockito.when(repositorioSala.existe(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarSala servicioActualizarSala = new ServicioActualizarSala(repositorioSala);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarSala.ejecutar(sala), ExcepcionDuplicidad.class,"La sala no existe en el sistema");

    }
	
}
