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
@Table(name = "cardPayment")
public class CardPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardPaymentId")
    private Long cardPaymentId;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "orderInfoId", referencedColumnName = "orderInfoId", nullable = false)
    private OrderInfo orderInfo;
    @Column(name = "paymentMethod")
    private String paymentMethod;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "cardNumber")
    private String cardNumber;
    @Column(name = "cvv")
    private String cvv;
    @Column(name = "expirationDate")
    private String expirationDate;
    @Column(name = "createdAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Column(name = "updatedAt",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp updatedAt;
    @Column(name = "deletedAt",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp deletedAt;
}
