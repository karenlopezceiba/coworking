package com.ceiba.reserva.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static java.time.temporal.ChronoUnit.DAYS;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.ceiba.persona.modelo.entidad.Persona;

import lombok.Getter;

@Getter
public class Reserva {
	
	private static final String SE_DEBE_INGRESAR_INFORMACION_DE_PERSONA = "Se debe ingresar una identificacion y nombre sobre la cual hacer la reserva";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_RESERVA = "Se debe ingresar la fecha de la reserva";
	private static final String SE_DEBE_INGRESAR_UN_VALOR_DE_PAGO = "Se debe ingresar el valor de la reserva";
	private static final int DOMINGO = 7;
	private static final Long MINIMOS_DIAS_DE_ANTERIORIDAD_NECESARIOS_PARA_DESCUENTO = 7L;
	private static final BigDecimal PORCENTAJE_DE_DESCUENTO = BigDecimal.TEN;
    
	private Long id;
	private LocalDate fechaReserva;
	private String identificacionPersona;
	private boolean estado;
	private BigDecimal valorAPagar;
	private Persona persona;
	
	public Reserva(Long id, LocalDate fechaReserva, BigDecimal valorAPagar, boolean estado, String identificacionPersona, Persona persona) {
		validarObligatorio(persona, SE_DEBE_INGRESAR_INFORMACION_DE_PERSONA);
		validarObligatorio(fechaReserva, SE_DEBE_INGRESAR_LA_FECHA_DE_RESERVA);
		validarObligatorio(valorAPagar, SE_DEBE_INGRESAR_UN_VALOR_DE_PAGO);
		this.id = id;
		this.estado = estado;
		this.persona = persona;
		this.fechaReserva = fechaReserva;
		this.valorAPagar = valorAPagar;
		this.identificacionPersona = identificacionPersona;
	}
	
	public boolean fechaValida(){
		if(fechaReserva.getDayOfWeek().getValue() != DOMINGO){
			if(fechaReserva.isAfter(LocalDate.now())){
				return true;
			}
		}
		return false;
		
	}

	public void descuentoPorFecha() {
		if(DAYS.between( LocalDate.now(), fechaReserva) >= MINIMOS_DIAS_DE_ANTERIORIDAD_NECESARIOS_PARA_DESCUENTO){
			valorAPagar = valorAPagar.subtract(valorAPagar.divide(PORCENTAJE_DE_DESCUENTO));
		}
		
	}

}
