package com.aceballos.cross.proyecto_cross_back.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aceballos.cross.proyecto_cross_back.entities.Ejercicio;
import com.aceballos.cross.proyecto_cross_back.exceptions.NoEncontradoException;
import com.aceballos.cross.proyecto_cross_back.exceptions.YaExisteException;
import com.aceballos.cross.proyecto_cross_back.repositories.IEjercicioRepository;
import com.aceballos.cross.proyecto_cross_back.services.IEjercicioService;

@Service
public class EjercicioService implements IEjercicioService {

    @Autowired
    private IEjercicioRepository ejercicioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Ejercicio> traerEjercicios() {
        return ejercicioRepository.findAll(); 
    }

    @Override
    @Transactional(readOnly = true)
    public Ejercicio traerEjercicio(Long idEjercicio) {
        Optional<Ejercicio> ejercicioOptional = ejercicioRepository.findById(idEjercicio);

        if(ejercicioOptional.isEmpty()) {
            throw new NoEncontradoException(idEjercicio);
        }

        return ejercicioOptional.get();
    }

    @Override
    @Transactional
    public Ejercicio crearEjercicio(Ejercicio ejercicio) {
        ejercicio.setNombre(ejercicio.getNombre().trim());

        if(ejercicioRepository.existsByNombre(ejercicio.getNombre())) {
            throw new YaExisteException(ejercicio.getNombre());
        }

        return ejercicioRepository.save(ejercicio);
    }

    @Override
    @Transactional
    public Ejercicio modificarEjercicio(Ejercicio ejercicio) {
        Optional<Ejercicio> ejercicioOptional = ejercicioRepository.findById(ejercicio.getIdEjercicio());

        if(!ejercicioOptional.isPresent()) {
            throw new NoEncontradoException(ejercicio.getIdEjercicio());
        }
        
        Ejercicio ejercicioModificar = ejercicioOptional.orElseThrow();
        ejercicioModificar.setNombre(ejercicio.getNombre().trim());
        ejercicioModificar.setDescripcion(ejercicio.getDescripcion());
        ejercicioModificar.setUrlVideo(ejercicio.getUrlVideo());
        ejercicioModificar.setGruposMusculares(ejercicio.getGruposMusculares());
        ejercicioModificar.setCategorias(ejercicio.getCategorias());
        ejercicioModificar.setNivelesDificultad(ejercicio.getNivelesDificultad());
        ejercicioModificar.setEquipamientos(ejercicio.getEquipamientos());
        
        return ejercicioRepository.save(ejercicioModificar);
    }

    @Override
    @Transactional
    public void borrarEjercicio(Long idEjercicio) {
        if(!ejercicioRepository.existsById(idEjercicio)) {
            throw new NoEncontradoException(idEjercicio);
        }
        
        ejercicioRepository.deleteById(idEjercicio);
    }

}
