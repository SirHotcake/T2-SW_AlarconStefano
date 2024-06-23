package com.example.T2_SW_AlarconStefano.controller;

import com.example.T2_SW_AlarconStefano.model.Publicacion;
import com.example.T2_SW_AlarconStefano.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @GetMapping
    public List<Publicacion> getAllPublicaciones() {
        return publicacionService.getAllPublicaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> getPublicacionById(@PathVariable int id) {
        Optional<Publicacion> publicacion = publicacionService.getPublicacionById(id);
        return publicacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Publicacion createPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionService.createPublicacion(publicacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> updatePublicacion(@PathVariable int id, @RequestBody Publicacion publicacion) {
        Publicacion updatedPublicacion = publicacionService.updatePublicacion(id, publicacion);
        return updatedPublicacion != null ? ResponseEntity.ok(updatedPublicacion) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublicacion(@PathVariable int id) {
        publicacionService.deletePublicacion(id);
        return ResponseEntity.noContent().build();
    }
}


