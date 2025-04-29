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

import com.aceballos.cross.proyecto_cross_back.entities.GrupoMuscular;
import com.aceballos.cross.proyecto_cross_back.services.IGrupoMuscularService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class GrupoMuscularController {

    @Autowired
    private IGrupoMuscularService grupoMuscularService;

    @GetMapping("/grupos-musculares")
    public ResponseEntity<List<GrupoMuscular>> traerGruposMusculares() {
        List<GrupoMuscular> lista = grupoMuscularService.traerGruposMusculares();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/grupos-musculares/{id}")
    public ResponseEntity<GrupoMuscular> traerGrupoMuscular(@PathVariable Long id) {
        GrupoMuscular grupoMuscular = grupoMuscularService.traerGrupoMuscular(id);
        return ResponseEntity.ok(grupoMuscular);
    }

    @PostMapping("/grupos-musculares")
    public ResponseEntity<GrupoMuscular> crearGrupoMuscular(@RequestBody @Valid GrupoMuscular grupoMuscular) {
        GrupoMuscular grupoMuscularNuevo = grupoMuscularService.crearGrupoMuscular(grupoMuscular);
        return new ResponseEntity<>(grupoMuscularNuevo, HttpStatus.CREATED);
    }

    @PutMapping("/grupos-musculares/{id}")
    public ResponseEntity<GrupoMuscular> modificarGrupoMuscular(@PathVariable Long id, @RequestBody @Valid GrupoMuscular grupoMuscular) {
        grupoMuscular.setIdGrupoMuscular(id);
        GrupoMuscular grupoMuscularModificado = grupoMuscularService.modificarGrupoMuscular(grupoMuscular);
        return ResponseEntity.ok(grupoMuscularModificado);
    }

    @DeleteMapping("/grupos-musculares/{id}")
    public ResponseEntity<GrupoMuscular> borrarGrupoMuscular(@PathVariable Long id) {
        return ResponseEntity.ok(grupoMuscularService.borrarGrupoMuscular(id));
    }
}
