package com.ceiba.Reserva.Controlador;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.ceiba.ApplicationMock;
import org.springframework.http.MediaType;
import com.ceiba.reserva.controlador.ConsultaControladorReserva;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorReserva.class)
public class ConsultaControladorReservaTest {
	
	@Autowired
    private MockMvc mocMvc;
	
	@Test
    public void listar() throws Exception {
        // arrange
		String identificacionPersona = "12345";
        // act - assert
        mocMvc.perform(get("/reservas/{identificacionPersona}", identificacionPersona)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        		.andExpect(jsonPath("$[0].identificacionPersona", is(identificacionPersona)));
    }
	
}