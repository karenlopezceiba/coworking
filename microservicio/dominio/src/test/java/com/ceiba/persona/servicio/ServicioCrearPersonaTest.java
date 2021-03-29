package com.ceiba.persona.servicio;

import org.junit.Assert;
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
        // act - assert
        Assert.assertTrue("Se intento crear un registro de Persona repetido", servicioCrearPersona.ejecutar(persona));
    }
	
	@Test
    public void validarPersonaSinExistenciaPreviaTest() {
        // arrange
        Persona persona = new PersonaTestDataBuilder().build();
        RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);
        Mockito.when(repositorioPersona.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioPersona.crear(Mockito.anyObject())).thenReturn(1L);
        ServicioCrearPersona servicioCrearPersona = new ServicioCrearPersona(repositorioPersona);
        // act - assert
        Assert.assertTrue("No se pudo crear la Persona", servicioCrearPersona.ejecutar(persona));
    }
}
