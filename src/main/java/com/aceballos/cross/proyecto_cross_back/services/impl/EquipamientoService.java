package com.aceballos.cross.proyecto_cross_back.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aceballos.cross.proyecto_cross_back.entities.Equipamiento;
import com.aceballos.cross.proyecto_cross_back.exceptions.NoEncontradoException;
import com.aceballos.cross.proyecto_cross_back.exceptions.YaExisteException;
import com.aceballos.cross.proyecto_cross_back.repositories.IEquipamientoRepository;
import com.aceballos.cross.proyecto_cross_back.services.IEquipamientoService;

@Service
public class EquipamientoService implements IEquipamientoService {

    @Autowired
    private IEquipamientoRepository equipamientoRepository;

    @Override
    public List<Equipamiento> traerEquipamientos() {
        return equipamientoRepository.findAll();
    }

    @Override
    public Equipamiento traerEquipamiento(Long idEquipamiento) {
        Optional<Equipamiento> equipamientoOptional = equipamientoRepository.findById(idEquipamiento);

        if(equipamientoOptional.isEmpty()) {
            throw new NoEncontradoException(idEquipamiento);
        }

        return equipamientoOptional.get();
    }

    @Override
    public Equipamiento crearEquipamiento(Equipamiento equipamiento) {
        equipamiento.setNombre(equipamiento.getNombre().trim());

        if(equipamientoRepository.existsByNombre(equipamiento.getNombre())) {
            throw new YaExisteException(equipamiento.getNombre());
        }

        return equipamientoRepository.save(equipamiento);
    }

    @Override
    public Equipamiento modificarEquipamiento(Equipamiento equipamiento) {
        Optional<Equipamiento> equipamientoOptional = equipamientoRepository.findById(equipamiento.getIdEquipamiento());

        if(!equipamientoOptional.isPresent()) {
            throw new NoEncontradoException(equipamiento.getIdEquipamiento());
        }
        
        Equipamiento equipamientoModificar = equipamientoOptional.orElseThrow();
        equipamientoModificar.setNombre(equipamiento.getNombre());
        equipamientoModificar.setDescripcion(equipamiento.getDescripcion());

        return equipamientoRepository.save(equipamientoModificar);
    }

    @Override
    public void borrarEquipamiento(Long idEquipamiento) {
        if(!equipamientoRepository.existsById(idEquipamiento)) {
            throw new NoEncontradoException(idEquipamiento);
        }

        equipamientoRepository.deleteById(idEquipamiento);
    }

}
