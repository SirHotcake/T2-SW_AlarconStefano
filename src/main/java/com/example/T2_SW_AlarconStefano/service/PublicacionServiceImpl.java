package com.example.T2_SW_AlarconStefano.service;

import com.example.T2_SW_AlarconStefano.model.Publicacion;
import com.example.T2_SW_AlarconStefano.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionServiceImpl implements PublicacionService {
    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public List<Publicacion> getAllPublicaciones() {
        return publicacionRepository.findAll();
    }

    @Override
    public Optional<Publicacion> getPublicacionById(int id) {
        return publicacionRepository.findById(id);
    }

    @Override
    public Publicacion createPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @Override
    public Publicacion updatePublicacion(int id, Publicacion publicacion) {
        Optional<Publicacion> existingPublicacion = publicacionRepository.findById(id);
        if (existingPublicacion.isPresent()) {
            Publicacion updatedPublicacion = existingPublicacion.get();
            updatedPublicacion.setTitulo(publicacion.getTitulo());
            updatedPublicacion.setResumen(publicacion.getResumen());
            updatedPublicacion.setFechPublicacion(publicacion.getFechPublicacion());
            updatedPublicacion.setAutor(publicacion.getAutor());
            return publicacionRepository.save(updatedPublicacion);
        } else {
            return null;
        }
    }

    @Override
    public void deletePublicacion(int id) {
        publicacionRepository.deleteById(id);
    }
}


