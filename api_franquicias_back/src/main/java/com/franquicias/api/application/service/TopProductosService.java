package com.franquicias.api.application.service;

import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.model.Producto;
import com.franquicias.api.domain.repository.FranquiciaRepository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopProductosService {

    private final FranquiciaRepository repository;

    public TopProductosService(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public List<Map<String, Object>> ejecutar(String fid) {

        Franquicia f = repository.findById(fid).orElseThrow();

        return f.getSucursales().stream()
                .map(s -> {
                    Producto top = s.getProductos().stream()
                            .max(Comparator.comparingInt(Producto::getStock))
                            .orElse(null);

                    Map<String, Object> result = new HashMap<>();
                    result.put("sucursal", s.getNombre());
                    result.put("producto", top != null ? top.getNombre() : null);
                    result.put("stock", top != null ? top.getStock() : 0);

                    return result;
                })
                .toList();
    }
}