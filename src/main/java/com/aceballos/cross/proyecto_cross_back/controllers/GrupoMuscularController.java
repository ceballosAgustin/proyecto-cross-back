package com.aceballos.cross.proyecto_cross_back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aceballos.cross.proyecto_cross_back.entities.GrupoMuscular;
import com.aceballos.cross.proyecto_cross_back.services.IGrupoMuscularService;

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
}
