package com.UNACHOtify.demo.controller;

import com.UNACHOtify.demo.entity.ArtistaEntity;
import com.UNACHOtify.demo.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/artistas")
public class ArtistaController {
    private final ArtistaService artistaService;

    @Autowired
    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    @PostMapping
    public ResponseEntity<ArtistaEntity> crearArtista(@RequestBody ArtistaEntity artista) {
        ArtistaEntity artistaGuardado = artistaService.saveArtista(artista);
        return new ResponseEntity<>(artistaGuardado, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<ArtistaEntity>> obtenerTodosLosArtistas() {
        List<ArtistaEntity> artistas = artistaService.getAllArtistas();
        return new ResponseEntity<>(artistas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistaEntity> obtenerArtistaPorId(@PathVariable int id) {
        ArtistaEntity artista = artistaService.getArtistaById(id);
        return artista != null ? new ResponseEntity<>(artista, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ArtistaEntity> actualizarArtista(@PathVariable int id, @RequestBody ArtistaEntity artistaActualizado) {
        ArtistaEntity artista = artistaService.getArtistaById(id);
        if (artista == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        artista.setNombre(artistaActualizado.getNombre());
        artista.setApellidos(artistaActualizado.getApellidos());
        artista.setPais(artistaActualizado.getPais());

        ArtistaEntity artistaActualizada = artistaService.saveArtista(artista);
        return new ResponseEntity<>(artistaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArtista(@PathVariable int id) {
        artistaService.deleteArtista(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
