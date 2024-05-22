package com.UNACHOtify.demo.controller;



import com.UNACHOtify.demo.clasesConsultasPersonalizadas.MuralProyeccion;
import com.UNACHOtify.demo.clasesConsultasPersonalizadas.MuralProyeccionInterface;
import com.UNACHOtify.demo.entity.MuralEntity;
import com.UNACHOtify.demo.service.MuralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/murales")
public class MuralController {

    private final MuralService muralService;

    @Autowired
    public MuralController(MuralService muralService) {
        this.muralService = muralService;
    }

    
    @PostMapping
    public ResponseEntity<MuralEntity> crearMural(@RequestBody MuralEntity mural) {
        MuralEntity muralGuardado = muralService.guardarMural(mural);
        return new ResponseEntity<>(muralGuardado, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<MuralEntity>> obtenerTodosLosMurales() {
        List<MuralEntity> murales = muralService.obtenerTodosLosMurales();
        return new ResponseEntity<>(murales, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/artistas")
    public ResponseEntity<List<Object[]>> obtenerMuralesConArtistas() {
        List<Object[]> murales = muralService.obtenerMuralesConArtista();
        return new ResponseEntity<>(murales, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MuralEntity> obtenerMuralPorId(@PathVariable int id) {
        MuralEntity mural = muralService.obtenerMuralPorId(id);
        return mural != null ? new ResponseEntity<>(mural, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MuralEntity> actualizarMural(@PathVariable int id, @RequestBody MuralEntity muralActualizado) {
        MuralEntity mural = muralService.obtenerMuralPorId(id);
        if (mural == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        mural.setTitulo(muralActualizado.getTitulo());
        mural.setAno(muralActualizado.getAno());
        mural.setDimensiones(muralActualizado.getDimensiones());
        mural.setMateriales(muralActualizado.getMateriales());

        MuralEntity muralActualizada = muralService.guardarMural(mural);
        return new ResponseEntity<>(muralActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMural(@PathVariable int id) {
        muralService.eliminarMural(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}