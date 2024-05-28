package com.proyecto.carritoCompra.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Long id;
    private String title;
    private BigDecimal price;
    private String description;
    private String category;
    private String image;
    private Rating rating;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Rating {
        private Double rate;
        private Integer count;
    }
}
