package com.proyecto.carritoCompra.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/api/test")
    public String testEndpoint() {
        return "¡Ruta de prueba accesible!";
    }
}
