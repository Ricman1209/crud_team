package com.ejemplo.crud.demo.controller;

import com.ejemplo.crud.demo.model.cliente;
import com.ejemplo.crud.demo.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // CREATE
    @PostMapping
    public cliente crear(@RequestBody cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // READ ALL
    @GetMapping
    public List<cliente> listar() {
        return clienteRepository.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public cliente obtener(@PathVariable Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public cliente actualizar(@PathVariable Long id, @RequestBody cliente detalles) {
        return clienteRepository.findById(id)
                .map(c -> {
                    c.setNombre(detalles.getNombre());
                    c.setEdad(detalles.getEdad());
                    c.setSexo(detalles.getSexo());
                    c.setTelefono(detalles.getTelefono());
                    c.setServicio(detalles.getServicio());
                    return clienteRepository.save(c);
                })
                .orElse(null);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return "Cliente eliminado con id " + id;
    }
}
