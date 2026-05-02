package com.franquicias.api;

import com.franquicias.api.application.service.TopProductosService;
import com.franquicias.api.domain.model.*;
import com.franquicias.api.domain.repository.FranquiciaRepository;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TopProductosServiceTest {

    @Test
    void shouldReturnTopProductos() {

        FranquiciaRepository repository = mock(FranquiciaRepository.class);
        TopProductosService service = new TopProductosService(repository);

        Producto p1 = new Producto("A", 10);
        Producto p2 = new Producto("B", 50);

        Sucursal sucursal = new Sucursal("Sucursal 1");
        sucursal.getProductos().addAll(List.of(p1, p2));

        Franquicia franquicia = new Franquicia("Test");
        franquicia.getSucursales().add(sucursal);

        when(repository.findById("1")).thenReturn(Optional.of(franquicia));

        List<Map<String, Object>> result = service.ejecutar("1");

        assertFalse(result.isEmpty());
        assertEquals("B", result.get(0).get("nombre"));
    }
}