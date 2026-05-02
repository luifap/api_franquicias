package com.franquicias.api.domain.model;

import com.franquicias.api.application.exception.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Franquicia {

    private String id;
    private String nombre;
    private List<Sucursal> sucursales;

    public Franquicia(String nombre) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.sucursales = new ArrayList<>();
    }

    public void agregarSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
    }

    public Sucursal buscarSucursal(String sucursalId) {
        return sucursales.stream()
                .filter(s -> s.getId().equals(sucursalId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Sucursal no encontrada"));
    }

    public void actualizarNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Sucursal> getSucursales() { return sucursales; }
}