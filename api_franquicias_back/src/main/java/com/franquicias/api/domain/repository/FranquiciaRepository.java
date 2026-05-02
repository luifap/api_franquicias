package com.franquicias.api.domain.repository;

import com.franquicias.api.domain.model.Franquicia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface FranquiciaRepository {

    Franquicia save(Franquicia franquicia);

    Optional<Franquicia> findById(String id);

    Page<Franquicia> findAll(Pageable pageable);

}