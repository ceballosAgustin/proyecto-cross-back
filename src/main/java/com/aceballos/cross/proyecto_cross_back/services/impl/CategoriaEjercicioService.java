package com.aceballos.cross.proyecto_cross_back.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aceballos.cross.proyecto_cross_back.entities.CategoriaEjercicio;
import com.aceballos.cross.proyecto_cross_back.exceptions.NoEncontradoException;
import com.aceballos.cross.proyecto_cross_back.exceptions.YaExisteException;
import com.aceballos.cross.proyecto_cross_back.repositories.ICategoriaEjercicioRepository;
import com.aceballos.cross.proyecto_cross_back.services.ICategoriaEjercicioService;

@Service
public class CategoriaEjercicioService implements ICategoriaEjercicioService {

    @Autowired
    private ICategoriaEjercicioRepository categoriaRepository;

    @Override
    public List<CategoriaEjercicio> traerCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public CategoriaEjercicio traerCategoria(Long idCategoria) {
        Optional<CategoriaEjercicio> categoriaOptional = categoriaRepository.findById(idCategoria);

        if(categoriaOptional.isEmpty()) {
            throw new NoEncontradoException(idCategoria);
        }

        return categoriaOptional.get();
    }

    @Override
    @Transactional
    public CategoriaEjercicio crearCategoria(CategoriaEjercicio categoria) {
        categoria.setNombre(categoria.getNombre().trim());

        if(categoriaRepository.existsByNombre(categoria.getNombre())) {
            throw new YaExisteException(categoria.getNombre());
        }

        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public CategoriaEjercicio modificarCategoria(CategoriaEjercicio categoria) {
        Optional<CategoriaEjercicio> categoriaOptional = categoriaRepository.findById(categoria.getIdCategoria());

        if(!categoriaOptional.isPresent()) {
            throw new NoEncontradoException(categoria.getIdCategoria());
        }

        CategoriaEjercicio categoriaModificar = categoriaOptional.orElseThrow();
        categoriaModificar.setNombre(categoria.getNombre());
        categoriaModificar.setDescripcion(categoria.getDescripcion());

        return categoriaRepository.save(categoriaModificar);
    }

    @Override
    @Transactional
    public void borrarCategoria(Long idCategoria) {
        if(!categoriaRepository.existsById(idCategoria)) {
            throw new NoEncontradoException(idCategoria);
        }
        categoriaRepository.deleteById(idCategoria);
    }
} 