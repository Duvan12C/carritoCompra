package com.proyecto.carritoCompra.entities;
import jakarta.persistence.*;
import lombok.*;


import java.sql.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "countryId")
    private Long countryId;
    @Column(name = "nameCounty")
    private String nameCounty;
    @Column(name = "abbreviatedName")
    private String abbreviatedName;
    @Column(name = "createdAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Column(name = "updatedAt",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp updatedAt;
    @Column(name = "deletedAt",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp deletedAt;
}
