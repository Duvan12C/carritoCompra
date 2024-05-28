package com.proyecto.carritoCompra.service;

import com.proyecto.carritoCompra.DTO.CategorieDTO;
import com.proyecto.carritoCompra.DTO.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductoService {

    private final RestTemplate restTemplate = new RestTemplate();

    public ProductoDTO obtenerProductoPorId(Long id) {
        String url = "https://fakestoreapi.com/products/" + id;
        try {
            return restTemplate.getForObject(url, ProductoDTO.class);
        } catch (RestClientException e) {
            // Log the exception or handle it appropriately
            System.err.println("Error fetching product: " + e.getMessage());
            return null;
        }
    }

    public List<ProductoDTO> obtenerProductos() {
        String url = "https://fakestoreapi.com/products";
        return restTemplate.getForObject(url, List.class);
    }

    public CategorieDTO obtenerCategorias() {
        String url = "https://fakestoreapi.com/products/categories";
        List<String> categorias = restTemplate.getForObject(url, List.class);
        return new CategorieDTO(categorias);
    }
}
