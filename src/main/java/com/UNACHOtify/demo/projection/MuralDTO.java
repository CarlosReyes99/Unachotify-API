package com.UNACHOtify.demo.projection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MuralDTO {
    private String nombre;
    private String apellidos;
    private int mural_id;
    private String titulo;
    private int ano;
    private String dimensiones;
    private String materiales;

    // Getters y setters
    // ...
}
