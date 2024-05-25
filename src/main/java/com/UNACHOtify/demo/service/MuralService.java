package com.UNACHOtify.demo.service;

import com.UNACHOtify.demo.projection.MuralDTO;
import com.UNACHOtify.demo.entity.MuralEntity;
import com.UNACHOtify.demo.projection.interfacebased.closed.MuralClosedView;
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
    public List<MuralDTO> obtenerMuralesConArtista() {
        return muralRepository.obtenerMuralesConArtistas();
    }

    public List<MuralDTO> muralesPorAño(int startYear, int endYear) {
        return muralRepository.muralesPorRangoAno(startYear, endYear);
    }



    public MuralEntity obtenerMuralPorId(int id) {
        return muralRepository.findById(id).orElse(null);
    }

    public void eliminarMural(int id) {
        muralRepository.deleteById(id);
    }


}
