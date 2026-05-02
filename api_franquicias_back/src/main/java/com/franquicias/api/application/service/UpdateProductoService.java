package com.franquicias.api.application.service;

import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.model.Producto;
import com.franquicias.api.domain.repository.FranquiciaRepository;

public class UpdateProductoService {

    private final FranquiciaRepository repository;

    public UpdateProductoService(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Franquicia ejecutar(String fid, String sid, String pid, String nombre) {

        Franquicia f = repository.findById(fid)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        Producto p = f.buscarSucursal(sid)
                .buscarProducto(pid);

        p.actualizarNombre(nombre);

        return repository.save(f);
    }
}