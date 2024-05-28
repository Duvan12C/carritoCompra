package com.proyecto.carritoCompra.repository;

import com.proyecto.carritoCompra.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
