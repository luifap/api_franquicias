package com.franquicias.api.infrastructure.persistence.repository;

import com.franquicias.api.infrastructure.persistence.entity.FranquiciaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MongoFranquiciaRepository
        extends MongoRepository<FranquiciaEntity, String> {

    Page<FranquiciaEntity> findAll(Pageable pageable);
}