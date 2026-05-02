package com.franquicias.api.application.service;

import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.repository.FranquiciaRepository;

public class DeleteProductoService {

    private final FranquiciaRepository repository;

    public DeleteProductoService(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Franquicia ejecutar(String fid, String sid, String pid) {

        Franquicia f = repository.findById(fid)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        f.buscarSucursal(sid)
                .eliminarProducto(pid);

        return repository.save(f);
    }
}