package com.ceiba.sala.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.sala.modelo.dto.DtoSala;
import com.ceiba.sala.puerto.dao.DaoSala;


@Component
public class ManejadorListarSalas {
	
	private final DaoSala daoSala;

    public ManejadorListarSalas(DaoSala daoSala){
        this.daoSala = daoSala;
    }

    public List<DtoSala> ejecutar(){ return this.daoSala.listar(); }

}
