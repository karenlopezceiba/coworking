package com.ceiba.reserva.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.reserva.servicio.ServicioEliminarReserva;

@Component
public class ManejadorEliminarReserva implements ManejadorComando<Long>{
	
	private final ServicioEliminarReserva servicioEliminarReserva;
	
	public ManejadorEliminarReserva(ServicioEliminarReserva servicioEliminarReserva) {
		this.servicioEliminarReserva = servicioEliminarReserva;
	}

	@Override
	public void ejecutar(Long idReserva) {
		this.servicioEliminarReserva.ejecutar(idReserva);
	}

}
