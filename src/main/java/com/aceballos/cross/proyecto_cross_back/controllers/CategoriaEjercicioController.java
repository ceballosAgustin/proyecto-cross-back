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

import com.aceballos.cross.proyecto_cross_back.entities.CategoriaEjercicio;
import com.aceballos.cross.proyecto_cross_back.services.ICategoriaEjercicioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CategoriaEjercicioController {

    @Autowired
    private ICategoriaEjercicioService categoriaService;

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaEjercicio>> traerCategorias() {
        List<CategoriaEjercicio> lista = categoriaService.traerCategorias();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<CategoriaEjercicio> traerCategoria(@PathVariable Long id) {
        CategoriaEjercicio categoria = categoriaService.traerCategoria(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping("/categorias")
    public ResponseEntity<CategoriaEjercicio> crearCategoria(@RequestBody @Valid CategoriaEjercicio categoria) {
        CategoriaEjercicio categoriaNueva = categoriaService.crearCategoria(categoria);
        return new ResponseEntity<>(categoriaNueva, HttpStatus.CREATED);
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<CategoriaEjercicio> modificarCategoria(@PathVariable Long id, @RequestBody @Valid CategoriaEjercicio categoria) {
        categoria.setIdCategoria(id);
        CategoriaEjercicio categoriaModificada = categoriaService.modificarCategoria(categoria);
        return ResponseEntity.ok(categoriaModificada);
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Void> borrarCategoria(@PathVariable Long id) {
        categoriaService.borrarCategoria(id);
        return ResponseEntity.noContent().build();
    }
} 