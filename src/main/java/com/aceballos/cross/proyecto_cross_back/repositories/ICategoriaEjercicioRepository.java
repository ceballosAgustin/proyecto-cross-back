package com.aceballos.cross.proyecto_cross_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceballos.cross.proyecto_cross_back.entities.CategoriaEjercicio;

public interface ICategoriaEjercicioRepository extends JpaRepository<CategoriaEjercicio, Long> {
    
    public boolean existsByNombre(String nombre);
} 