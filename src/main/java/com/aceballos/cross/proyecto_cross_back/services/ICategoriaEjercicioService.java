package com.aceballos.cross.proyecto_cross_back.services;

import java.util.List;

import com.aceballos.cross.proyecto_cross_back.entities.CategoriaEjercicio;

public interface ICategoriaEjercicioService {
    
    public List<CategoriaEjercicio> traerCategorias();

    public CategoriaEjercicio traerCategoria(Long idCategoria);

    public CategoriaEjercicio crearCategoria(CategoriaEjercicio categoria);

    public CategoriaEjercicio modificarCategoria(CategoriaEjercicio categoria);

    public void borrarCategoria(Long idCategoria);
} 