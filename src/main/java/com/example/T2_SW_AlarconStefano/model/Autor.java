package com.example.T2_SW_AlarconStefano.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAutor;

    @Column(nullable = false, length = 50)
    private String nomAutor;

    @Column(nullable = false, length = 50)
    private String apeAutor;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechNacAutor;

    // Getters y Setters
    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNomAutor() {
        return nomAutor;
    }

    public void setNomAutor(String nomAutor) {
        this.nomAutor = nomAutor;
    }

    public String getApeAutor() {
        return apeAutor;
    }

    public void setApeAutor(String apeAutor) {
        this.apeAutor = apeAutor;
    }

    public Date getFechNacAutor() {
        return fechNacAutor;
    }

    public void setFechNacAutor(Date fechNacAutor) {
        this.fechNacAutor = fechNacAutor;
    }
}


