package com.UNACHOtify.demo.service;

import com.UNACHOtify.demo.clasesConsultasPersonalizadas.MuralProyeccion;
import com.UNACHOtify.demo.clasesConsultasPersonalizadas.MuralProyeccionInterface;
import com.UNACHOtify.demo.entity.MuralEntity;
import com.UNACHOtify.demo.repository.MuralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuralService {

    private final MuralRepository muralRepository;

    @Autowired
    public MuralService(MuralRepository muralRepository) {
        this.muralRepository = muralRepository;
    }

    public MuralEntity guardarMural(MuralEntity mural) {
        return muralRepository.save(mural);
    }

    public List<MuralEntity> obtenerTodosLosMurales() {
        return muralRepository.findAll();
    }
    public List<Object[]> obtenerMuralesConArtista() {
        return muralRepository.obtenerMuralesConArtistas();
    }

    public MuralEntity obtenerMuralPorId(int id) {
        return muralRepository.findById(id).orElse(null);
    }

    public void eliminarMural(int id) {
        muralRepository.deleteById(id);
    }


}
