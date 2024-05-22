package com.UNACHOtify.demo.service;

import com.UNACHOtify.demo.entity.ArtistaEntity;
import com.UNACHOtify.demo.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {
    private final ArtistaRepository artistaRepository;

    @Autowired
    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public ArtistaEntity saveArtista(ArtistaEntity artista) {
        return artistaRepository.save(artista);
    }

    public List<ArtistaEntity> getAllArtistas() {
        return artistaRepository.findAll();
    }

    public ArtistaEntity getArtistaById(int id) {
        return artistaRepository.findById(id).orElse(null);
    }

    public void deleteArtista(int id) {
        artistaRepository.deleteById(id);
    }
}
