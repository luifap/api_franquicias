package com.franquicias.api.application.service;

import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.repository.FranquiciaRepository;

public class UpdateFranquiciaService {

    private final FranquiciaRepository repository;

    public UpdateFranquiciaService(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Franquicia ejecutar(String id, String nombre) {

        Franquicia f = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        f.actualizarNombre(nombre);

        return repository.save(f);
    }
}