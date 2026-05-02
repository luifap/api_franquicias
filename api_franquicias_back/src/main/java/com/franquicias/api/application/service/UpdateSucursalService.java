package com.franquicias.api.application.service;

import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.model.Sucursal;
import com.franquicias.api.domain.repository.FranquiciaRepository;

public class UpdateSucursalService {

    private final FranquiciaRepository repository;

    public UpdateSucursalService(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Franquicia ejecutar(String fid, String sid, String nombre) {

        Franquicia f = repository.findById(fid)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        Sucursal s = f.buscarSucursal(sid);
        s.actualizarNombre(nombre);

        return repository.save(f);
    }
}