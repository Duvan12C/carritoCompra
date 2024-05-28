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
@Table(name = "stateOrder")
public class StateOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stateOrderId")
    private Long stateOrderId;
    @Column(name = "stateOrderName")
    private String stateOrderName;
    @Column(name = "createdAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
}
