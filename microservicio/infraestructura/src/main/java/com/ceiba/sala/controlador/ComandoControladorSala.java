package com.ceiba.sala.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.sala.comando.ComandoSala;
import com.ceiba.sala.comando.manejador.ManejadorActualizarSala;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/salas")
@Api(tags = { "Controlador comando sala"})
public class ComandoControladorSala {
	
	private final ManejadorActualizarSala manejadorActualizarSala;
	
	@Autowired
	public ComandoControladorSala(ManejadorActualizarSala manejadorActualizarSala) {
		this.manejadorActualizarSala = manejadorActualizarSala;
	}
	
	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Sala")
	public void actualizar(@RequestBody ComandoSala comandoSala,@PathVariable Long id) {
		comandoSala.setId(id);
		manejadorActualizarSala.ejecutar(comandoSala);
	}
}
