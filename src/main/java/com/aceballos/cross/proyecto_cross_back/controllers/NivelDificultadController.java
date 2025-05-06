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

import com.aceballos.cross.proyecto_cross_back.entities.NivelDificultad;
import com.aceballos.cross.proyecto_cross_back.services.INivelDificultadService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class NivelDificultadController {

    @Autowired
    private INivelDificultadService nivelService;

    @GetMapping("/niveles")
    public ResponseEntity<List<NivelDificultad>> traerNiveles() {
        List<NivelDificultad> lista = nivelService.traerNiveles();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/niveles/{id}")
    public ResponseEntity<NivelDificultad> traerNivel(@PathVariable Long id) {
        NivelDificultad nivel = nivelService.traerNivel(id);
        return ResponseEntity.ok(nivel);
    }

    @PostMapping("/niveles")
    public ResponseEntity<NivelDificultad> crearNivel(@RequestBody @Valid NivelDificultad nivel) {
        NivelDificultad nivelNuevo = nivelService.crearNivel(nivel);
        return new ResponseEntity<>(nivelNuevo, HttpStatus.CREATED);
    }

    @PutMapping("/niveles/{id}")
    public ResponseEntity<NivelDificultad> modificarNivel(@PathVariable Long id, @RequestBody @Valid NivelDificultad nivel) {
        nivel.setIdNivel(id);
        NivelDificultad nivelModificado = nivelService.modificarNivel(nivel);
        return ResponseEntity.ok(nivelModificado);
    }

    @DeleteMapping("/niveles/{id}")
    public ResponseEntity<Void> borrarNivel(@PathVariable Long id) {
        nivelService.borrarNivel(id);
        return ResponseEntity.noContent().build();
    }
} 