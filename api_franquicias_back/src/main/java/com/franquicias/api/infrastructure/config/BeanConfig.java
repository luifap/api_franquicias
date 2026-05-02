package com.franquicias.api.infrastructure.config;

import com.franquicias.api.application.service.*;
import com.franquicias.api.domain.repository.FranquiciaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateFranquiciaService createFranquiciaService(FranquiciaRepository r) {
        return new CreateFranquiciaService(r);
    }

    @Bean
    public AddSucursalService addSucursalService(FranquiciaRepository r) {
        return new AddSucursalService(r);
    }

    @Bean
    public AddProductoService addProductoService(FranquiciaRepository r) {
        return new AddProductoService(r);
    }

    @Bean
    public DeleteProductoService deleteProductoService(FranquiciaRepository r) {
        return new DeleteProductoService(r);
    }

    @Bean
    public UpdateStockService updateStockService(FranquiciaRepository r) {
        return new UpdateStockService(r);
    }

    @Bean
    public TopProductosService topProductosService(FranquiciaRepository r) {
        return new TopProductosService(r);
    }

    @Bean
    public UpdateFranquiciaService updateFranquiciaService(FranquiciaRepository r) {
        return new UpdateFranquiciaService(r);
    }

    @Bean
    public UpdateSucursalService updateSucursalService(FranquiciaRepository r) {
        return new UpdateSucursalService(r);
    }

    @Bean
    public UpdateProductoService updateProductoService(FranquiciaRepository r) {
        return new UpdateProductoService(r);
    }

    @Bean
    public GetFranquiciaService getFranquiciaService(FranquiciaRepository r) {
        return new GetFranquiciaService(r);
    }

    @Bean
    public ListFranquiciasService listFranquiciasService(FranquiciaRepository r) {
        return new ListFranquiciasService(r);
    }
}