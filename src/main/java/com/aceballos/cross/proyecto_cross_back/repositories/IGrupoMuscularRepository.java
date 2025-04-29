package com.aceballos.cross.proyecto_cross_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceballos.cross.proyecto_cross_back.entities.GrupoMuscular;

public interface IGrupoMuscularRepository extends JpaRepository<GrupoMuscular, Long> {
    
    public boolean existsByNombre(String nombre);
}
