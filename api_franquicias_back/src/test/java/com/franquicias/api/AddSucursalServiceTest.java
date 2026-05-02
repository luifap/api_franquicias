package com.franquicias.api;

import com.franquicias.api.application.service.AddSucursalService;
import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.repository.FranquiciaRepository;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddSucursalServiceTest {

    @Test
    void shouldAddSucursal() {

        FranquiciaRepository repository = mock(FranquiciaRepository.class);
        AddSucursalService service = new AddSucursalService(repository);

        Franquicia franquicia = new Franquicia("Test");

        when(repository.findById("1")).thenReturn(Optional.of(franquicia));
        when(repository.save(any())).thenAnswer(i -> i.getArgument(0));

        Franquicia result = service.ejecutar("1", "Sucursal Centro");

        assertEquals(1, result.getSucursales().size());
        assertEquals("Sucursal Centro", result.getSucursales().get(0).getNombre());
    }
}