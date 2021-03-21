package com.ceiba.sala.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.sala.comando.ComandoSala;
import com.ceiba.sala.comando.fabrica.FabricaSala;
import com.ceiba.sala.modelo.entidad.Sala;
import com.ceiba.sala.servicio.ServicioActualizarSala;


@Component
public class ManejadorActualizarSala implements ManejadorComando<ComandoSala> {
	
	 private final FabricaSala fabricaSala;
	 private final ServicioActualizarSala servicioActualizarSala;
	 
	 
	public ManejadorActualizarSala(FabricaSala fabricaSala, ServicioActualizarSala servicioActualizarSala) {
		this.fabricaSala = fabricaSala;
		this.servicioActualizarSala = servicioActualizarSala;
	}


	@Override
	public void ejecutar(ComandoSala comandoSala) {
		Sala sala = this.fabricaSala.crear(comandoSala);
		this.servicioActualizarSala.ejecutar(sala);
	}

}
