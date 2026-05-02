package com.franquicias.api;

import com.franquicias.api.application.service.CreateFranquiciaService;
import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.repository.FranquiciaRepository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateFranquiciaServiceTest {

    @Test
    void shouldCreateFranquicia() {

        FranquiciaRepository repository = mock(FranquiciaRepository.class);
        CreateFranquiciaService service = new CreateFranquiciaService(repository);

        when(repository.save(any())).thenAnswer(i -> i.getArgument(0));

        Franquicia result = service.ejecutar("Franquicia Test");

        assertNotNull(result);
        assertEquals("Franquicia Test", result.getNombre());
        verify(repository, times(1)).save(any());
    }
}