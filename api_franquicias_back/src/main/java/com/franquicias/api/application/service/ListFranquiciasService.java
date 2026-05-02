package com.franquicias.api.application.service;

import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.repository.FranquiciaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ListFranquiciasService {

    private final FranquiciaRepository repository;

    public ListFranquiciasService(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Page<Franquicia> ejecutar(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
