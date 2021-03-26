package com.ceiba.reserva.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.persona.servicio.ServicioCrearPersona;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.fabrica.FabricaReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;


@Component
public class ManejadorCrearReserva implements ManejadorComandoRespuesta<ComandoReserva, ComandoRespuesta<Long>>{
	
	private final FabricaReserva fabricaReserva;
	private final ServicioCrearReserva servicioCrearReserva;
	private final ServicioCrearPersona servicioCrearPersona;
	
	public ManejadorCrearReserva(FabricaReserva fabricaReserva, ServicioCrearReserva servicioCrearReserva, ServicioCrearPersona servicioCrearPersona) {
		this.fabricaReserva = fabricaReserva;
		this.servicioCrearReserva = servicioCrearReserva;
		this.servicioCrearPersona = servicioCrearPersona;
	}

	@Override
	public ComandoRespuesta<Long> ejecutar(ComandoReserva comandoReserva) {
		Reserva reserva = this.fabricaReserva.crear(comandoReserva);
		if(servicioCrearPersona.ejecutar(reserva.getPersona())){
			return new ComandoRespuesta<>(this.servicioCrearReserva.ejecutar(reserva));
		}
		return new ComandoRespuesta<>(null);
	}
	
}
