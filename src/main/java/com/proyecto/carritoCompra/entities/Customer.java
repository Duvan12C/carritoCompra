package com.proyecto.carritoCompra.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Long customerId;
    @Column(name = "name")
    private String name;
    @Column(name = "secondName")
    private String secondName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "secondLastName")
    private String secondLastName;
    @Column(name = "numberPhone")
    private String numberPhone;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    private Long countryId;
    private Long stateId;
}