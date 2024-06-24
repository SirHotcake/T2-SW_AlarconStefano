package com.example.T2_SW_AlarconStefano.service;

import com.example.T2_SW_AlarconStefano.model.Publicacion;

import java.util.List;
import java.util.Optional;

public interface PublicacionService {
    List<Publicacion> getAllPublicaciones();
    Optional<Publicacion> getPublicacionById(int id);
    Publicacion createPublicacion(Publicacion publicacion);
    Publicacion updatePublicacion(int id, Publicacion publicacion);
    void deletePublicacion(int id);
}
//
