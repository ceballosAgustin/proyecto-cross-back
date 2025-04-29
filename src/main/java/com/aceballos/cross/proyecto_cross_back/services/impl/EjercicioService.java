package com.aceballos.cross.proyecto_cross_back.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aceballos.cross.proyecto_cross_back.entities.Ejercicio;
import com.aceballos.cross.proyecto_cross_back.repositories.IEjercicioRepository;
import com.aceballos.cross.proyecto_cross_back.services.IEjercicioService;

@Service
public class EjercicioService implements IEjercicioService{

    @Autowired
    private IEjercicioRepository ejercicioRepository;

    @Override
    public List<Ejercicio> traerEjercicios() {
        return ejercicioRepository.findAll(); 
    }

    @Override
    public Ejercicio traerEjercicio(Long idEjercicio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'traerEjercicio'");
    }

    @Override
    public Ejercicio crearEjercicio(Ejercicio ejercicio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearEjercicio'");
    }

    @Override
    public Ejercicio modificarEjercicio(Ejercicio ejercicio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarEjercicio'");
    }

    @Override
    public Ejercicio borrarEjercicio(Long idEjercicio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarEjercicio'");
    }

}
