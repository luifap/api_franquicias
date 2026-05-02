package com.franquicias.api.application.service;

import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.model.Producto;
import com.franquicias.api.domain.repository.FranquiciaRepository;

public class AddProductoService {

    private final FranquiciaRepository repository;

    public AddProductoService(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Franquicia ejecutar(String fid, String sid, String nombre, int stock) {

        Franquicia f = repository.findById(fid)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        f.buscarSucursal(sid)
                .agregarProducto(new Producto(nombre, stock));

        return repository.save(f);
    }
}