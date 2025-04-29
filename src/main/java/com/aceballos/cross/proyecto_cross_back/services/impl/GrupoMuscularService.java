package com.aceballos.cross.proyecto_cross_back.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aceballos.cross.proyecto_cross_back.entities.GrupoMuscular;
import com.aceballos.cross.proyecto_cross_back.repositories.IGrupoMuscularRepository;
import com.aceballos.cross.proyecto_cross_back.services.IGrupoMuscularService;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'traerGrupoMuscular'");
    }

    @Override
    public GrupoMuscular crearGrupoMuscular(GrupoMuscular grupoMuscular) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearGrupoMuscular'");
    }

    @Override
    public GrupoMuscular modificarGrupoMuscular(GrupoMuscular grupoMuscular) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarGrupoMuscular'");
    }

    @Override
    public GrupoMuscular borrarGrupoMuscular(Long idGrupoMuscular) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarGrupoMuscular'");
    }

}
