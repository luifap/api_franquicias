package com.franquicias.api.application.dto;

import java.util.List;

public class SucursalResponseDTO {

    private String id;
    private String nombre;
    private List<ProductoResponseDTO> productos;

    public SucursalResponseDTO(String id, String nombre, List<ProductoResponseDTO> productos) {
        this.id = id;
        this.nombre = nombre;
        this.productos = productos;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<ProductoResponseDTO> getProductos() { return productos; }
}