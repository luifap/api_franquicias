package com.franquicias.api.application.service;

import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.model.Producto;
import com.franquicias.api.domain.repository.FranquiciaRepository;

public class UpdateStockService {

    private final FranquiciaRepository repository;

    public UpdateStockService(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Franquicia ejecutar(String fid, String sid, String pid, int stock) {

        Franquicia f = repository.findById(fid)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        f.buscarSucursal(sid)
                .buscarProducto(pid)
                .actualizarStock(stock);

        return repository.save(f);
    }
}