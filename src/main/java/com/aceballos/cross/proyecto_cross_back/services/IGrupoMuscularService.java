package com.aceballos.cross.proyecto_cross_back.services;

import java.util.List;

import com.aceballos.cross.proyecto_cross_back.entities.GrupoMuscular;

public interface IGrupoMuscularService {
    
    public List<GrupoMuscular> traerGruposMusculares();

    public GrupoMuscular traerGrupoMuscular(Long idGrupoMuscular);

    public GrupoMuscular crearGrupoMuscular(GrupoMuscular grupoMuscular);

    public GrupoMuscular modificarGrupoMuscular(GrupoMuscular grupoMuscular);

    public GrupoMuscular borrarGrupoMuscular(Long idGrupoMuscular);
}
