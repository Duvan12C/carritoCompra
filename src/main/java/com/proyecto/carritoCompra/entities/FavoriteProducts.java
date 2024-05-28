package com.proyecto.carritoCompra.entities;

import java.sql.Timestamp;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "favorite_products")
public class FavoriteProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favoriteProductsId")
    private Long favoriteProductsId;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private User user;
    @Column(name = "productId")
    private Long productId;
    @Column(name = "createdAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Column(name = "updatedAt",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp updatedAt;
    @Column(name = "deletedAt",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp deletedAt;
}
