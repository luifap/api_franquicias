package com.franquicias.api.application.mapper;

import com.franquicias.api.application.dto.*;
import com.franquicias.api.domain.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class FranquiciaMapper {

    public static FranquiciaResponseDTO toDTO(Franquicia f) {

        List<SucursalResponseDTO> sucursales = f.getSucursales()
                .stream()
                .map(FranquiciaMapper::toSucursalDTO)
                .collect(Collectors.toList());

        return new FranquiciaResponseDTO(
                f.getId(),
                f.getNombre(),
                sucursales
        );
    }

    private static SucursalResponseDTO toSucursalDTO(Sucursal s) {

        List<ProductoResponseDTO> productos = s.getProductos()
                .stream()
                .map(p -> new ProductoResponseDTO(
                        p.getId(),
                        p.getNombre(),
                        p.getStock()
                ))
                .toList();

        return new SucursalResponseDTO(
                s.getId(),
                s.getNombre(),
                productos
        );
    }
}