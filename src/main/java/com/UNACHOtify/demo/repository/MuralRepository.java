package com.UNACHOtify.demo.repository;

import com.UNACHOtify.demo.projection.MuralDTO;
import com.UNACHOtify.demo.entity.MuralEntity;
import com.UNACHOtify.demo.projection.interfacebased.closed.MuralClosedView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MuralRepository extends JpaRepository<MuralEntity, Integer> {
    @Query("SELECT new com.UNACHOtify.demo.projection.MuralDTO(a.nombre, a.apellidos, m.mural_id, m.titulo, m.ano, m.dimensiones, m.materiales) " +
            "FROM MuralEntity m " +
            "JOIN m.artista a")

    List<MuralDTO> obtenerMuralesConArtistas();

    @Query("SELECT new com.UNACHOtify.demo.projection.MuralDTO(a.nombre, a.apellidos, m.mural_id, m.titulo, m.ano, m.dimensiones, m.materiales) FROM MuralEntity m JOIN m.artista a WHERE m.ano BETWEEN :startYear AND :endYear" )
    List<MuralDTO> muralesPorRangoAno(@Param("startYear") int startYear, @Param("endYear") int endYear);



}
