package com.example.T2_SW_AlarconStefano.service;

import com.example.T2_SW_AlarconStefano.model.Autor;
import com.example.T2_SW_AlarconStefano.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService {
    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<Autor> getAutorById(int id) {
        return autorRepository.findById(id);
    }

    @Override
    public Autor createAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor updateAutor(int id, Autor autor) {
        Optional<Autor> existingAutor = autorRepository.findById(id);
        if (existingAutor.isPresent()) {
            Autor updatedAutor = existingAutor.get();
            updatedAutor.setNomAutor(autor.getNomAutor());
            updatedAutor.setApeAutor(autor.getApeAutor());
            updatedAutor.setFechNacAutor(autor.getFechNacAutor());
            return autorRepository.save(updatedAutor);
        } else {
            return null;
        }
    }

    @Override
    public void deleteAutor(int id) {
        autorRepository.deleteById(id);
    }
}


