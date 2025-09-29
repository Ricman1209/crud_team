package com.ejemplo.crud.demo.controller;

import com.ejemplo.crud.demo.model.Persona;
import com.ejemplo.crud.demo.repository.PersonaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaRepository personaRepository;

    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @PostMapping
    public Persona crear(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @GetMapping
    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Persona obtener(@PathVariable Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Persona actualizar(@PathVariable Long id, @RequestBody Persona detalles) {
        return personaRepository.findById(id)
                .map(p -> {
                    p.setNombre(detalles.getNombre());
                    p.setCorreo(detalles.getCorreo());
                    return personaRepository.save(p);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        personaRepository.deleteById(id);
        return "Eliminado id " + id;
    }
}
