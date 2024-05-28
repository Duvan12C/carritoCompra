package com.proyecto.carritoCompra.DTO;

import lombok.Data;

@Data
public class SignUpRequestDTO {
    private String username;
    private String password;
    private String name;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private String numberPhone;
    private String email;
    private String address;
    private Long countryId;
    private Long stateId;
}
