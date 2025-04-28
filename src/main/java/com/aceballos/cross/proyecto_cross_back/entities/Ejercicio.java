package com.aceballos.cross.proyecto_cross_back.entities;

import java.util.Set;

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

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String descripcion;

    @Column(name = "url_video")
    private String urlVideo;

    @ManyToMany
    @JoinTable(
        name = "ejercicio_grupo_muscular",
        joinColumns = @JoinColumn(name = "id_ejercicio"),
        inverseJoinColumns = @JoinColumn(name = "id_grupo_muscular"),
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id_ejercicio", "id_grupo_muscular"})})
    private Set<GrupoMuscular> gruposMusculares;
}
