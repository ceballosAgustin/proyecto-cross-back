package com.aceballos.cross.proyecto_cross_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceballos.cross.proyecto_cross_back.entities.Equipamiento;

public interface IEquipamientoRepository extends JpaRepository<Equipamiento, Long>{

    public boolean existsByNombre(String nombre);
}
