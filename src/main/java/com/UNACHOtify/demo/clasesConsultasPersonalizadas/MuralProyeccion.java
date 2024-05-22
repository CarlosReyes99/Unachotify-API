package com.UNACHOtify.demo.clasesConsultasPersonalizadas;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class MuralProyeccion {
    @Value("#{target.mural_id}")
    private int muralId;

    @Value("#{target.titulo}")
    private String titulo;

    @Value("#{target.ano}")
    private int ano;

    @Value("#{target.dimensiones}")
    private String dimensiones;

    @Value("#{target.materiales}")
    private String materiales;

    @Value("#{target.artista.nombre}")
    private String nombre;

    @Value("#{target.artista.apellidos}")
    private String apellidos;

    // Getters y setters
    // ...
}
