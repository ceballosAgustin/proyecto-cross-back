package com.aceballos.cross.proyecto_cross_back.services;

import java.util.List;

import com.aceballos.cross.proyecto_cross_back.entities.NivelDificultad;

public interface INivelDificultadService {
    
    public List<NivelDificultad> traerNiveles();

    public NivelDificultad traerNivel(Long idNivel);

    public NivelDificultad crearNivel(NivelDificultad nivel);

    public NivelDificultad modificarNivel(NivelDificultad nivel);

    public void borrarNivel(Long idNivel);
} 