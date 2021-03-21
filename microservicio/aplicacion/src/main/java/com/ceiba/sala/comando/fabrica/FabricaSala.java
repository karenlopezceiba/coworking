package com.ceiba.sala.comando.fabrica;

import org.springframework.stereotype.Component;
import com.ceiba.sala.comando.ComandoSala;
import com.ceiba.sala.modelo.entidad.Sala;

@Component
public class FabricaSala {
	
	public Sala crear(ComandoSala comandoSala){
		return new Sala(
				comandoSala.getId(),
				comandoSala.getTotalPuestosTrabajo(),
				comandoSala.getPuestosDisponibles()
				);
	}

}
