package com.ejemplo.crud.demo.repository;

import com.ejemplo.crud.demo.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
