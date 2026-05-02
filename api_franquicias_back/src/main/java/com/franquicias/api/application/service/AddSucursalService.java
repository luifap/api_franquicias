package com.franquicias.api.application.service;


import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.model.Sucursal;
import com.franquicias.api.domain.repository.FranquiciaRepository;

public class AddSucursalService {

    private final FranquiciaRepository repository;

    public AddSucursalService(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Franquicia ejecutar(String franquiciaId, String nombre) {

        Franquicia f = repository.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        f.agregarSucursal(new Sucursal(nombre));

        return repository.save(f);
    }
}