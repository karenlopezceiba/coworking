package com.ceiba.sala.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.sala.consulta.ManejadorListarSalas;
import com.ceiba.sala.modelo.dto.DtoSala;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/salas")
@Api(tags={"Controlador consulta sala"})
public class ConsultaControladorSala {
	
	 private final ManejadorListarSalas  manejadorListarSalas;

	public ConsultaControladorSala(ManejadorListarSalas manejadorListarSalas) {
		this.manejadorListarSalas = manejadorListarSalas;
	}
	 
	
	@GetMapping
    @ApiOperation("Listar salas")
    public List<DtoSala> listar() {
        return this.manejadorListarSalas.ejecutar();
    }
}
