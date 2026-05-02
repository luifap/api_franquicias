package com.franquicias.api.application.dto;

import java.util.List;

public class FranquiciaResponseDTO {

    private String id;
    private String nombre;
    private List<SucursalResponseDTO> sucursales;

    public FranquiciaResponseDTO(String id, String nombre, List<SucursalResponseDTO> sucursales) {
        this.id = id;
        this.nombre = nombre;
        this.sucursales = sucursales;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<SucursalResponseDTO> getSucursales() { return sucursales; }
}