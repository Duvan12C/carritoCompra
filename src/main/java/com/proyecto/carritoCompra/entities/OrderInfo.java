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
@Table(name = "orderInfo")
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderInfoId")
    private Long orderInfoId;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "stateOrderId", referencedColumnName = "stateOrderId", nullable = false)
    private StateOrder stateOrder;
    @Column(name = "createdAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Column(name = "updatedAt",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp updatedAt;
    @Column(name = "deletedAt",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp deletedAt;
}
