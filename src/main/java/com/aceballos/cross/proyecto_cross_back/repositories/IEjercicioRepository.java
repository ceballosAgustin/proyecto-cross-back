package com.aceballos.cross.proyecto_cross_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceballos.cross.proyecto_cross_back.entities.Ejercicio;

public interface IEjercicioRepository extends JpaRepository<Ejercicio, Long> {

    public boolean existsByNombre(String nombre);
}
