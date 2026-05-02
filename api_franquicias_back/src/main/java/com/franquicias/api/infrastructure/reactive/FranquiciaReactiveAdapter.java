package com.franquicias.api.infrastructure.reactive;

import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.domain.repository.FranquiciaRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class FranquiciaReactiveAdapter {

    private final FranquiciaRepository repository;

    public FranquiciaReactiveAdapter(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Mono<Franquicia> save(Franquicia franquicia) {
        return Mono.fromCallable(() -> repository.save(franquicia));
    }

    public Mono<Franquicia> findById(String id) {
        return Mono.fromCallable(() ->
                repository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"))
        );
    }

    public Flux<Franquicia> findAll() {
        return Mono.fromCallable(() ->
                repository.findAll(PageRequest.of(0, 20)).getContent()
        ).flatMapMany(Flux::fromIterable);
    }
}