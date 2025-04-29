package com.aceballos.cross.proyecto_cross_back.services;

import java.util.List;

import com.aceballos.cross.proyecto_cross_back.entities.Ejercicio;

public interface IEjercicioService {

    public List<Ejercicio> traerEjercicios();

    public Ejercicio traerEjercicio(Long idEjercicio);

    public Ejercicio crearEjercicio(Ejercicio ejercicio);

    public Ejercicio modificarEjercicio(Ejercicio ejercicio);

    public Ejercicio borrarEjercicio(Long idEjercicio);
}
