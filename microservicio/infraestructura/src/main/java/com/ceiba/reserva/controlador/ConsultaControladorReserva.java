package com.ceiba.reserva.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.reserva.consulta.ManejadorListarReservas;
import com.ceiba.reserva.modelo.dto.DtoReserva;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/reservas")
@Api(tags={"Controlador consulta reserva"})
public class ConsultaControladorReserva {
	
	private final ManejadorListarReservas manejadorListarReservas;
	
	public ConsultaControladorReserva(ManejadorListarReservas manejadorListarReservas) {
		this.manejadorListarReservas = manejadorListarReservas;
	}
	
	@GetMapping(value="/{idPersona}")
    @ApiOperation("Listar reservas")
    public List<DtoReserva> listar(@PathVariable String idPersona) {
        return this.manejadorListarReservas.ejecutar(idPersona);
    }
	
}
