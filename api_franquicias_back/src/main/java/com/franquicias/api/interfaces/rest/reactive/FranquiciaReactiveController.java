package com.franquicias.api.interfaces.rest.reactive;


import com.franquicias.api.domain.model.Franquicia;
import com.franquicias.api.infrastructure.reactive.FranquiciaReactiveAdapter;

import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/reactive/franquicias")
public class FranquiciaReactiveController {

    private final FranquiciaReactiveAdapter adapter;

    public FranquiciaReactiveController(FranquiciaReactiveAdapter adapter) {
        this.adapter = adapter;
    }

    @PostMapping
    public Mono<Franquicia> create(@RequestBody Map<String, String> body) {
        return adapter.save(new Franquicia(body.get("nombre")));
    }

    @GetMapping("/{id}")
    public Mono<Franquicia> getById(@PathVariable String id) {
        return adapter.findById(id);
    }

    @GetMapping
    public Flux<Franquicia> getAll() {
        return adapter.findAll();
    }
}