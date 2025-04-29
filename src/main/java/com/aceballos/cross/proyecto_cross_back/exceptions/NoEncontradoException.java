package com.aceballos.cross.proyecto_cross_back.exceptions;

public class NoEncontradoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public NoEncontradoException(Long id) {
        super("El recurso con id " + id + " no fue encontrado.");
    }

    public NoEncontradoException(String nombre) {
        super("El recurso con nombre " + nombre + " no fue encontrado.");
    }
}
