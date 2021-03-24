package com.ceiba.configuracion;

import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import com.ceiba.reserva.servicio.ServicioEliminarReserva;
import com.ceiba.sala.puerto.repositorio.RepositorioSala;
import com.ceiba.sala.servicio.ServicioActualizarSala;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioActualizarSala servicioActualizarSala(RepositorioSala repositorioSala) {
        return new ServicioActualizarSala(repositorioSala);
    }
    
    @Bean
    public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva) {
        return new ServicioCrearReserva(repositorioReserva);
    }

    @Bean
    public ServicioEliminarReserva servicioEliminarReserva(RepositorioReserva repositorioReserva) {
        return new ServicioEliminarReserva(repositorioReserva);
    }

}
