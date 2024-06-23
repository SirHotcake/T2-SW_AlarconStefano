package com.example.T2_SW_AlarconStefano.service;

import com.example.T2_SW_AlarconStefano.model.Autor;

import java.util.List;
import java.util.Optional;

public interface AutorService {
    List<Autor> getAllAutores();
    Optional<Autor> getAutorById(int id);
    Autor createAutor(Autor autor);
    Autor updateAutor(int id, Autor autor);
    void deleteAutor(int id);
}

