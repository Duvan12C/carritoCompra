package com.proyecto.carritoCompra.service;

import com.proyecto.carritoCompra.entities.*;
import com.proyecto.carritoCompra.exception.AuthenticationFailedException;
import com.proyecto.carritoCompra.exception.UserAlreadyExistsException;
import com.proyecto.carritoCompra.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class UserService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void createUserAndCustomer(String username, String password, String name, String secondName, String lastName, String secondLastName, String numberPhone, String email, String address, Long countryId, Long stateId) {
        // Verificar si el usuario ya existe
        if (userRepository.findByUserName(username).isPresent()) {
            throw new UserAlreadyExistsException("El usuario ya existe");
        }


        // Crear un nuevo cliente
        Customer customer = new Customer();
        customer.setName(name);
        customer.setSecondName(secondName);
        customer.setLastName(lastName);
        customer.setSecondLastName(secondLastName);
        customer.setNumberPhone(numberPhone);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setCountryId(countryId);
        customer.setStateId(stateId);

        // Guardar el nuevo cliente
        Customer savedCustomer = customerRepository.save(customer);

        // Crear un nuevo usuario y asociarlo con el cliente guardado
        User user = new User();
        user.setUserName(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setCustomer(savedCustomer);
        user.setCreatedAt(Timestamp.from(Instant.now())); // Establecer la fecha actual

        // Guardar el nuevo usuario
        userRepository.save(user);
    }


    public void authenticateUser(String username, String password) {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new AuthenticationFailedException("Usuario o contraseña incorrectos"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new AuthenticationFailedException("Usuario o contraseña incorrectos");
        }
}
}
