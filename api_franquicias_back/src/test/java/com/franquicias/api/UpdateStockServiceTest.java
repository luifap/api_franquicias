package com.franquicias.api;

import com.franquicias.api.application.service.UpdateStockService;
import com.franquicias.api.domain.model.*;
import com.franquicias.api.domain.repository.FranquiciaRepository;

import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UpdateStockServiceTest {

    @Test
    void shouldUpdateStock() {

        FranquiciaRepository repository = mock(FranquiciaRepository.class);
        UpdateStockService service = new UpdateStockService(repository);

        Producto producto = new Producto("Producto Test", 5);

        Sucursal sucursal = new Sucursal("Sucursal 1");
        sucursal.getProductos().add(producto);

        Franquicia franquicia = new Franquicia("Franquicia Test");
        franquicia.getSucursales().add(sucursal);

        when(repository.findById(any())).thenReturn(Optional.of(franquicia));
        when(repository.save(any())).thenAnswer(i -> i.getArgument(0));

        Franquicia result = service.ejecutar("f1", sucursal.getId(), producto.getId(), 20);

        assertEquals(20,
                result.getSucursales().get(0).getProductos().get(0).getStock());
    }
}