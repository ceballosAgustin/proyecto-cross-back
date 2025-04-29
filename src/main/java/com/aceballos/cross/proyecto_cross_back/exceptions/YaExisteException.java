package com.aceballos.cross.proyecto_cross_back.exceptions;

public class YaExisteException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public YaExisteException(Long id) {
        super("El recurso con id " + id + " ya existe.");
    }

    public YaExisteException(String nombre) {
        super("El recurso con nombre " + nombre + " ya existe.");
    }
}
