package com.franquicias.api;

import com.franquicias.api.application.service.AddProductoService;
import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.model.Sucursal;
import com.franquicias.api.domain.repository.FranquiciaRepository;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddProductoServiceTest {

    @Test
    void shouldAddProducto() {

        FranquiciaRepository repository = mock(FranquiciaRepository.class);
        AddProductoService service = new AddProductoService(repository);

        Sucursal sucursal = new Sucursal("Sucursal Test");

        Franquicia franquicia = new Franquicia("Franquicia Test");
        franquicia.setSucursales(new ArrayList<>());
        franquicia.getSucursales().add(sucursal);

        String fid = franquicia.getId();
        String sid = sucursal.getId();

        when(repository.findById(fid)).thenReturn(Optional.of(franquicia));
        when(repository.save(any())).thenAnswer(i -> i.getArgument(0));

        Franquicia result = service.ejecutar(fid, sid, "Producto Test", 10);

        assertEquals(1,
                result.getSucursales().get(0).getProductos().size());

        assertEquals("Producto Test",
                result.getSucursales().get(0)
                        .getProductos()
                        .get(0)
                        .getNombre());
    }
}