package com.ceiba.dominio.excepcion;

public class ExcepcionInexistencia extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionInexistencia(String mensaje) {
        super(mensaje);
    }
}