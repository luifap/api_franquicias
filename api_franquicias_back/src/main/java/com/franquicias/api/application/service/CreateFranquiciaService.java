package com.franquicias.api.application.service;

import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.repository.FranquiciaRepository;

public class CreateFranquiciaService {

    private final FranquiciaRepository repository;

    public CreateFranquiciaService(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Franquicia ejecutar(String nombre) {
        return repository.save(new Franquicia(nombre));
    }
}