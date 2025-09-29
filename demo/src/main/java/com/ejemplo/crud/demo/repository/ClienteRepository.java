package com.ejemplo.crud.demo.repository;

import com.ejemplo.crud.demo.model.cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<cliente, Long> {
}
