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

import com.aceballos.cross.proyecto_cross_back.entities.Ejercicio;
import com.aceballos.cross.proyecto_cross_back.services.IEjercicioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EjercicioController {

    @Autowired
    private IEjercicioService ejercicioService;

    @GetMapping("/ejercicios")
    public ResponseEntity<List<Ejercicio>> traerEjercicios() {
        List<Ejercicio> lista = ejercicioService.traerEjercicios();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/ejercicios/{id}")
    public ResponseEntity<Ejercicio> traerEjercicio(@PathVariable Long id) {
        Ejercicio ejercicio = ejercicioService.traerEjercicio(id);
        return ResponseEntity.ok(ejercicio);
    }

    @PostMapping("/ejercicios")
    public ResponseEntity<Ejercicio> crearEjercicio(@RequestBody @Valid Ejercicio ejercicio) {
        Ejercicio ejercicioNuevo = ejercicioService.crearEjercicio(ejercicio);
        return new ResponseEntity<>(ejercicioNuevo, HttpStatus.CREATED);
    }

    @PutMapping("/ejercicios/{id}")
    public ResponseEntity<Ejercicio> modificarEjercicio(@PathVariable Long id, @RequestBody @Valid Ejercicio ejercicio) {
        ejercicio.setIdEjercicio(id);
        Ejercicio ejercicioModificado = ejercicioService.modificarEjercicio(ejercicio);
        return ResponseEntity.ok(ejercicioModificado);
    }

    @DeleteMapping("/ejercicios/{id}")
    public ResponseEntity<Void> borrarEjercicio(@PathVariable Long id) {
        ejercicioService.borrarEjercicio(id);
        return ResponseEntity.noContent().build();
    }
}
