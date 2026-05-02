package com.franquicias.api.infrastructure.persistence.adapter;

import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.repository.FranquiciaRepository;
import com.franquicias.api.infrastructure.persistence.entity.FranquiciaEntity;
import com.franquicias.api.infrastructure.persistence.repository.MongoFranquiciaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FranquiciaRepositoryAdapter implements FranquiciaRepository {

    private final MongoFranquiciaRepository mongoRepository;

    public FranquiciaRepositoryAdapter(MongoFranquiciaRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public Franquicia save(Franquicia franquicia) {

        FranquiciaEntity entity = new FranquiciaEntity();
        entity.setId(franquicia.getId());
        entity.setNombre(franquicia.getNombre());
        entity.setSucursales(franquicia.getSucursales());

        entity = mongoRepository.save(entity);

        franquicia.setId(entity.getId());
        return franquicia;
    }

    @Override
    public Optional<Franquicia> findById(String id) {
        return mongoRepository.findById(id)
                .map(e -> {
                    Franquicia f = new Franquicia(e.getNombre());
                    f.setId(e.getId());
                    f.setSucursales(e.getSucursales());
                    return f;
                });
    }

    @Override
    public Page<Franquicia> findAll(Pageable pageable) {
        return mongoRepository.findAll(pageable)
                .map(e -> {
                    Franquicia f = new Franquicia(e.getNombre());
                    f.setId(e.getId());
                    f.setSucursales(e.getSucursales());
                    return f;
                });
    }
}