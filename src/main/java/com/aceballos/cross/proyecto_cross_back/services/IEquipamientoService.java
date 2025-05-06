package com.aceballos.cross.proyecto_cross_back.services;

import java.util.List;

import com.aceballos.cross.proyecto_cross_back.entities.Equipamiento;

public interface IEquipamientoService {

    public List<Equipamiento> traerEquipamientos();

    public Equipamiento traerEquipamiento(Long idEquipamiento);

    public Equipamiento crearEquipamiento(Equipamiento equipamiento);

    public Equipamiento modificarEquipamiento(Equipamiento equipamiento);

    public void borrarEquipamiento(Long idEquipamiento);

}
