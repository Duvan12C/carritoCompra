package com.proyecto.carritoCompra.controller;

import com.proyecto.carritoCompra.DTO.CategorieDTO;
import com.proyecto.carritoCompra.DTO.ProductoDTO;
import com.proyecto.carritoCompra.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/{id}")

    public ResponseEntity<ProductoDTO> obtenerProductoPorId(@PathVariable Long id) {
        ProductoDTO producto = productoService.obtenerProductoPorId(id);
        if (producto!= null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/productos-list")
    public ResponseEntity<List<ProductoDTO>> obtenerProductos() {
        List<ProductoDTO> productos = productoService.obtenerProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/categories")
    public ResponseEntity<CategorieDTO> obtenerCategorias() {
        CategorieDTO categoriasDto = productoService.obtenerCategorias();
        return ResponseEntity.ok(categoriasDto);
    }
}
