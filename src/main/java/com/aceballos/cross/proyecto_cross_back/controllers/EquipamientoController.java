package com.aceballos.cross.proyecto_cross_back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aceballos.cross.proyecto_cross_back.entities.Equipamiento;
import com.aceballos.cross.proyecto_cross_back.services.IEquipamientoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EquipamientoController {

    @Autowired
    private IEquipamientoService equipamientoService;

    @GetMapping("/equipamientos")
    public ResponseEntity<List<Equipamiento>> traerEquipamientos() {
        List<Equipamiento> lista = equipamientoService.traerEquipamientos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/equipamientos/{id}")
    public ResponseEntity<Equipamiento> traerEquipamiento(@PathVariable Long id) {
        Equipamiento equipamiento = equipamientoService.traerEquipamiento(id);
        return ResponseEntity.ok(equipamiento);
    }

    @PostMapping("/equipamientos")
    public ResponseEntity<Equipamiento> crearEquipamiento(@RequestBody @Valid Equipamiento equipamiento) {
        Equipamiento equipamientoNuevo = equipamientoService.crearEquipamiento(equipamiento);
        return new ResponseEntity<>(equipamientoNuevo, HttpStatus.CREATED);
    }

    @PutMapping("/equipamientos/{id}")
    public ResponseEntity<Equipamiento> modificarEquipamiento(@PathVariable Long id, @RequestBody @Valid Equipamiento equipamiento) {
        equipamiento.setIdEquipamiento(id);
        Equipamiento equipamientoModificado = equipamientoService.modificarEquipamiento(equipamiento);
        return ResponseEntity.ok(equipamientoModificado);
    }

    @DeleteMapping("/equipamientos/{id}")
    public ResponseEntity<Void> borrarEquipamiento(@PathVariable Long id) {
        equipamientoService.borrarEquipamiento(id);
        return ResponseEntity.noContent().build();
    }
}
