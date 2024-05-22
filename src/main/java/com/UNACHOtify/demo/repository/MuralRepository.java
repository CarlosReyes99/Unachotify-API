package com.UNACHOtify.demo.repository;

import com.UNACHOtify.demo.clasesConsultasPersonalizadas.MuralProyeccion;
import com.UNACHOtify.demo.clasesConsultasPersonalizadas.MuralProyeccionInterface;
import com.UNACHOtify.demo.entity.MuralEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MuralRepository extends JpaRepository<MuralEntity, Integer> {
    @Query("SELECT a.nombre, a.apellidos, m.mural_id, m.titulo, m.ano, m.dimensiones, m.materiales " +
            "FROM MuralEntity m " +
            "JOIN m.artista a")

    List<Object[]> obtenerMuralesConArtistas();
}
