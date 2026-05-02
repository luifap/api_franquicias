package com.franquicias.api.infrastructure.persistence.entity;

import com.franquicias.api.domain.model.Sucursal;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "franquicias")
@Data
public class FranquiciaEntity {

    @Id
    private String id;
    private String nombre;
    private List<Sucursal> sucursales;
}