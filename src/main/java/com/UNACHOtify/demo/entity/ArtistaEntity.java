package com.UNACHOtify.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "artista")
@Data

public class ArtistaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artista_id;

    private String nombre;
    private String apellidos;
    private String pais;
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MuralEntity> murales = new ArrayList<>();

}
