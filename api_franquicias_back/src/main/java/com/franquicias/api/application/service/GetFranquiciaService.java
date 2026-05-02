package com.franquicias.api.application.service;

import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.repository.FranquiciaRepository;

public class GetFranquiciaService {

    private final FranquiciaRepository repository;

    public GetFranquiciaService(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Franquicia ejecutar(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
    }
}