package com.aceballos.cross.proyecto_cross_back.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aceballos.cross.proyecto_cross_back.entities.GrupoMuscular;
import com.aceballos.cross.proyecto_cross_back.exceptions.NoEncontradoException;
import com.aceballos.cross.proyecto_cross_back.exceptions.YaExisteException;
import com.aceballos.cross.proyecto_cross_back.repositories.IGrupoMuscularRepository;
import com.aceballos.cross.proyecto_cross_back.services.IGrupoMuscularService;

import jakarta.transaction.Transactional;

@Service
public class GrupoMuscularService implements IGrupoMuscularService{

    @Autowired
    private IGrupoMuscularRepository grupoMuscularRepository;

    @Override
    public List<GrupoMuscular> traerGruposMusculares() {
        return grupoMuscularRepository.findAll();
    }

    @Override
    public GrupoMuscular traerGrupoMuscular(Long idGrupoMuscular) {
        Optional<GrupoMuscular> grupoMuscularOptional = grupoMuscularRepository.findById(idGrupoMuscular);

        if(grupoMuscularOptional.isEmpty()) {
            throw new NoEncontradoException(idGrupoMuscular);
        }

        return grupoMuscularOptional.get();
    }

    @Override
    @Transactional
    public GrupoMuscular crearGrupoMuscular(GrupoMuscular grupoMuscular) {
        grupoMuscular.setNombre(grupoMuscular.getNombre().trim());

        if(grupoMuscularRepository.existsByNombre(grupoMuscular.getNombre())) {
            throw new YaExisteException(grupoMuscular.getNombre());
        }

        return grupoMuscularRepository.save(grupoMuscular);
    }

    @Override
    public GrupoMuscular modificarGrupoMuscular(GrupoMuscular grupoMuscular) {
        Optional<GrupoMuscular> grupoMuscularOptional = grupoMuscularRepository.findById(grupoMuscular.getIdGrupoMuscular());

        if(!grupoMuscularOptional.isPresent()) {
            throw new NoEncontradoException(grupoMuscular.getNombre());
        }

        GrupoMuscular grupoMuscularModificar = grupoMuscularOptional.orElseThrow();
        grupoMuscularModificar.setNombre(grupoMuscular.getNombre());

        return grupoMuscularRepository.save(grupoMuscularModificar);
    }

    @Override
    public GrupoMuscular borrarGrupoMuscular(Long idGrupoMuscular) {
        Optional<GrupoMuscular> grupoMuscularOptional = grupoMuscularRepository.findById(idGrupoMuscular);

        if(!grupoMuscularOptional.isPresent()) {
            throw new NoEncontradoException(idGrupoMuscular);
        }

        grupoMuscularRepository.deleteById(idGrupoMuscular);

        return grupoMuscularOptional.get();
    }

}
