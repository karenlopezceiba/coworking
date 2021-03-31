package com.ceiba.persona.servicio;

import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;

public class ServicioCrearPersonaTest {
	
	@Test
    public void validarPersonaExistenciaPreviaTest() {
        // arrange
        Persona persona = new PersonaTestDataBuilder().build();
        RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);
        Mockito.when(repositorioPersona.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearPersona servicioCrearPersona = new ServicioCrearPersona(repositorioPersona);
        servicioCrearPersona.ejecutar(persona);
        // act - assert
        Mockito.verify(repositorioPersona, Mockito.times(0)).crear(Mockito.anyObject());
    }
	
	@Test
    public void validarPersonaNoCreadaTest() {
        // arrange
        Persona persona = new PersonaTestDataBuilder().build();
        RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);
        Mockito.when(repositorioPersona.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCrearPersona servicioCrearPersona = new ServicioCrearPersona(repositorioPersona);
        servicioCrearPersona.ejecutar(persona);
        // act - assert
        Mockito.verify(repositorioPersona, Mockito.times(1)).crear(Mockito.anyObject());
    }
}
