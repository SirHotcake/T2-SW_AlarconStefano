package com.example.T2_SW_AlarconStefano.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/archivos")
public class SubirArchivoController {

    private final long TAMANIO_MAXIMO_ARCHIVO = 25 * 1024 * 1024; // 25MB
    private final String DIRECTORIO_SUBIDA = "D:/@/T2-SW_AlarconStefano/subidas/";

    @PostMapping("/subirMultiples")
    public ResponseEntity<List<String>> subirMultiplesArchivos(@RequestParam("archivos") MultipartFile[] archivos) {
        List<String> urlsDescarga = new ArrayList<>();

        if (archivos.length != 3) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        for (MultipartFile archivo : archivos) {
            String nombreArchivo = archivo.getOriginalFilename();
            if (nombreArchivo == null || (!nombreArchivo.endsWith(".pdf") && !nombreArchivo.endsWith(".png") && !nombreArchivo.endsWith(".docx"))) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            try {

                File directorio = new File(DIRECTORIO_SUBIDA);
                if (!directorio.exists()) {
                    directorio.mkdirs();
                }


                archivo.transferTo(new File(DIRECTORIO_SUBIDA + nombreArchivo));


                String urlDescarga = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/api/v1/archivos/descargar/")
                        .path(nombreArchivo)
                        .toUriString();
//
                urlsDescarga.add(urlDescarga);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }

        return ResponseEntity.ok(urlsDescarga);
    }

    @PostMapping("/subirUnico")
    public ResponseEntity<String> subirArchivoUnico(@RequestParam("archivo") MultipartFile archivo) {
        if (archivo.getSize() > TAMANIO_MAXIMO_ARCHIVO) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El archivo excede el tamaño máximo de 25MB.");
        }

        String nombreArchivo = archivo.getOriginalFilename();
        if (nombreArchivo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nombre de archivo no válido.");
        }

        try {

            File directorio = new File(DIRECTORIO_SUBIDA);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }


            archivo.transferTo(new File(DIRECTORIO_SUBIDA + nombreArchivo));


            String urlDescarga = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/v1/archivos/descargar/")
                    .path(nombreArchivo)
                    .toUriString();

            return ResponseEntity.ok(urlDescarga);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el archivo.");
        }
    }
}


