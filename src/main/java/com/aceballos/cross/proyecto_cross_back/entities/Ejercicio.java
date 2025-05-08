package com.aceballos.cross.proyecto_cross_back.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ejercicios")
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejercicio")
    private Long idEjercicio;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, unique = true)
    private String nombre;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 10, max = 500, message = "La descripción debe tener entre 10 y 500 caracteres")
    @Column(nullable = false)
    private String descripcion;

    @Column(name = "url_video")
    private String urlVideo;

    @ManyToMany
    @JoinTable(
        name = "ejercicio_grupo_muscular",
        joinColumns = @JoinColumn(name = "id_ejercicio"),
        inverseJoinColumns = @JoinColumn(name = "id_grupo_muscular"),
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id_ejercicio", "id_grupo_muscular"})})
    @JsonIgnoreProperties("ejercicios")
    private Set<GrupoMuscular> gruposMusculares;

    @ManyToMany
    @JoinTable(
        name = "ejercicio_categoria",
        joinColumns = @JoinColumn(name = "id_ejercicio"),
        inverseJoinColumns = @JoinColumn(name = "id_categoria"),
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id_ejercicio", "id_categoria"})})
    @JsonIgnoreProperties("ejercicios")
    private Set<CategoriaEjercicio> categorias;

    @ManyToMany
    @JoinTable(
        name = "ejercicio_nivel_dificultad",
        joinColumns = @JoinColumn(name = "id_ejercicio"),
        inverseJoinColumns = @JoinColumn(name = "id_nivel"),
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id_ejercicio", "id_nivel"})})
    @JsonIgnoreProperties("ejercicios")
    private Set<NivelDificultad> nivelesDificultad;

    @ManyToMany
    @JoinTable(
        name = "ejercicio_equipamiento",
        joinColumns = @JoinColumn(name = "id_ejercicio"),
        inverseJoinColumns = @JoinColumn(name = "id_equipamiento"),
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id_ejercicio", "id_equipamiento"})})
    @JsonIgnoreProperties("ejercicios")
    private Set<Equipamiento> equipamientos;
}
