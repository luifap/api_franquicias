package com.franquicias.api.interfaces.rest;

import com.franquicias.api.application.dto.*;
import com.franquicias.api.application.mapper.FranquiciaMapper;
import com.franquicias.api.application.service.*;
import com.franquicias.api.domain.model.Franquicia;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/franquicias")
public class FranquiciaController {

    private final CreateFranquiciaService createFranquiciaService;
    private final AddSucursalService addSucursalService;
    private final AddProductoService addProductoService;
    private final DeleteProductoService deleteProductoService;
    private final UpdateStockService updateStockService;
    private final TopProductosService topProductosService;
    private final UpdateFranquiciaService updateFranquiciaService;
    private final UpdateSucursalService updateSucursalService;
    private final UpdateProductoService updateProductoService;
    private final GetFranquiciaService getFranquiciaService;
    private final ListFranquiciasService listFranquiciasService;

    public FranquiciaController(
            CreateFranquiciaService createFranquiciaService,
            AddSucursalService addSucursalService,
            AddProductoService addProductoService,
            DeleteProductoService deleteProductoService,
            UpdateStockService updateStockService,
            TopProductosService topProductosService,
            UpdateFranquiciaService updateFranquiciaService,
            UpdateSucursalService updateSucursalService,
            UpdateProductoService updateProductoService,
            GetFranquiciaService getFranquiciaService,
            ListFranquiciasService listFranquiciasService
    ) {
        this.createFranquiciaService = createFranquiciaService;
        this.addSucursalService = addSucursalService;
        this.addProductoService = addProductoService;
        this.deleteProductoService = deleteProductoService;
        this.updateStockService = updateStockService;
        this.topProductosService = topProductosService;
        this.updateFranquiciaService = updateFranquiciaService;
        this.updateSucursalService = updateSucursalService;
        this.updateProductoService = updateProductoService;
        this.getFranquiciaService = getFranquiciaService;
        this.listFranquiciasService = listFranquiciasService;
    }

    @GetMapping
    public Page<FranquiciaResponseDTO> listarFranquicias(Pageable pageable) {
        return listFranquiciasService.ejecutar(pageable)
                .map(FranquiciaMapper::toDTO);
    }

    @GetMapping("/{id}")
    public FranquiciaResponseDTO obtenerFranquicia(@PathVariable String id) {
        Franquicia f = getFranquiciaService.ejecutar(id);
        return FranquiciaMapper.toDTO(f);
    }


    @PostMapping
    public FranquiciaResponseDTO crear(@Valid @RequestBody CreateFranquiciaRequest request) {
        Franquicia f = createFranquiciaService.ejecutar(request.getNombre());
        return FranquiciaMapper.toDTO(f);
    }

    @PutMapping("/{id}")
    public FranquiciaResponseDTO actualizarFranquicia(
            @PathVariable String id,
            @Valid @RequestBody UpdateFranquiciaRequest request) {

        Franquicia f = updateFranquiciaService.ejecutar(id, request.getNombre());
        return FranquiciaMapper.toDTO(f);
    }


    @PostMapping("/{id}/sucursales")
    public FranquiciaResponseDTO agregarSucursal(
            @PathVariable String id,
            @Valid @RequestBody CreateSucursalRequest request) {

        Franquicia f = addSucursalService.ejecutar(id, request.getNombre());
        return FranquiciaMapper.toDTO(f);
    }


    @PutMapping("/{fid}/sucursales/{sid}")
    public FranquiciaResponseDTO actualizarSucursal(
            @PathVariable String fid,
            @PathVariable String sid,
            @Valid @RequestBody UpdateSucursalRequest request) {

        Franquicia f = updateSucursalService.ejecutar(fid, sid, request.getNombre());
        return FranquiciaMapper.toDTO(f);
    }


    @PostMapping("/{fid}/sucursales/{sid}/productos")
    public FranquiciaResponseDTO agregarProducto(
            @PathVariable String fid,
            @PathVariable String sid,
            @Valid @RequestBody CreateProductoRequest request) {

        Franquicia f = addProductoService.ejecutar(
                fid,
                sid,
                request.getNombre(),
                request.getStock()
        );

        return FranquiciaMapper.toDTO(f);
    }


    @DeleteMapping("/{fid}/sucursales/{sid}/productos/{pid}")
    public FranquiciaResponseDTO eliminarProducto(
            @PathVariable String fid,
            @PathVariable String sid,
            @PathVariable String pid) {

        Franquicia f = deleteProductoService.ejecutar(fid, sid, pid);
        return FranquiciaMapper.toDTO(f);
    }


    @PutMapping("/{fid}/sucursales/{sid}/productos/{pid}/stock")
    public FranquiciaResponseDTO actualizarStock(
            @PathVariable String fid,
            @PathVariable String sid,
            @PathVariable String pid,
            @Valid @RequestBody UpdateStockRequest request) {

        Franquicia f = updateStockService.ejecutar(fid, sid, pid, request.getStock());
        return FranquiciaMapper.toDTO(f);
    }

    @PutMapping("/{fid}/sucursales/{sid}/productos/{pid}")
    public FranquiciaResponseDTO actualizarProducto(
            @PathVariable String fid,
            @PathVariable String sid,
            @PathVariable String pid,
            @Valid @RequestBody UpdateProductoRequest request) {

        Franquicia f = updateProductoService.ejecutar(fid, sid, pid, request.getNombre());
        return FranquiciaMapper.toDTO(f);
    }


    @GetMapping("/{id}/top-productos")
    public List<Map<String, Object>> topProductos(@PathVariable String id) {
        return topProductosService.ejecutar(id);
    }
}