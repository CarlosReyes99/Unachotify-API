package com.UNACHOtify.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Mural")
@Data
public class MuralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mural_id;

    private String titulo;
    private int ano;
    private String dimensiones;
    private String materiales;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private ArtistaEntity artista;

    // Constructores, getters y setters
}
