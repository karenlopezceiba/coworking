package com.ceiba.Reserva.Controlador;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import com.ceiba.ApplicationMock;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.controlador.ComandoControladorReserva;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static com.ceiba.Reserva.servicio.testdatabuilder.ComandoReservaTestBuilder.unaReservaBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorReserva.class)
public class ComandoControladorReservaTest {
	
	@Autowired
    private MockMvc mocMvc;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@Test
    public void Crear() throws Exception{
    	// arrange
    	ComandoReserva reserva = unaReservaBuilder().conFecha(LocalDate.now().plusDays(1L))
    												.conIdentificacionPersona("1234")
    												.conIsEstado(true)
    												.conValorPago(new BigDecimal("10000")).build();
    	
    	// act - assert
    	mocMvc.perform(post("/reservas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }
	
	 	@Test
	    public void Eliminar() throws Exception{
	    	// arrange
	    	Long id = 1L;
	    	
	    	// act - assert
	    	mocMvc.perform(delete("/reservas/{id}",id)
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	    }
	
}
