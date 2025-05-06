package com.aceballos.cross.proyecto_cross_back.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aceballos.cross.proyecto_cross_back.entities.NivelDificultad;
import com.aceballos.cross.proyecto_cross_back.exceptions.NoEncontradoException;
import com.aceballos.cross.proyecto_cross_back.exceptions.YaExisteException;
import com.aceballos.cross.proyecto_cross_back.repositories.INivelDificultadRepository;
import com.aceballos.cross.proyecto_cross_back.services.INivelDificultadService;

@Service
public class NivelDificultadService implements INivelDificultadService {

    @Autowired
    private INivelDificultadRepository nivelRepository;

    @Override
    public List<NivelDificultad> traerNiveles() {
        return nivelRepository.findAll();
    }

    @Override
    public NivelDificultad traerNivel(Long idNivel) {
        Optional<NivelDificultad> nivelOptional = nivelRepository.findById(idNivel);

        if(nivelOptional.isEmpty()) {
            throw new NoEncontradoException(idNivel);
        }

        return nivelOptional.get();
    }

    @Override
    @Transactional
    public NivelDificultad crearNivel(NivelDificultad nivel) {
        nivel.setNombre(nivel.getNombre().trim());

        if(nivelRepository.existsByNombre(nivel.getNombre())) {
            throw new YaExisteException(nivel.getNombre());
        }

        if(nivelRepository.existsByNivel(nivel.getNivel())) {
            throw new YaExisteException("Ya existe un nivel con el valor " + nivel.getNivel());
        }

        return nivelRepository.save(nivel);
    }

    @Override
    @Transactional
    public NivelDificultad modificarNivel(NivelDificultad nivel) {
        Optional<NivelDificultad> nivelOptional = nivelRepository.findById(nivel.getIdNivel());

        if(!nivelOptional.isPresent()) {
            throw new NoEncontradoException(nivel.getIdNivel());
        }

        NivelDificultad nivelModificar = nivelOptional.orElseThrow();
        nivelModificar.setNombre(nivel.getNombre());
        nivelModificar.setNivel(nivel.getNivel());
        nivelModificar.setDescripcion(nivel.getDescripcion());

        return nivelRepository.save(nivelModificar);
    }

    @Override
    @Transactional
    public void borrarNivel(Long idNivel) {
        if(!nivelRepository.existsById(idNivel)) {
            throw new NoEncontradoException(idNivel);
        }
        nivelRepository.deleteById(idNivel);
    }
} 