package com.franquicias.api.application.dto;

import jakarta.validation.constraints.Min;

public class UpdateStockRequest {

    @Min(value = 0, message = "El stock no puede ser negativo")
    private int stock;

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}