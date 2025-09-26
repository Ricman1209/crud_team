package com.equipo.crudequipo.cliente;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository repo;

    public ClienteController(ClienteRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Cliente> listar() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Cliente obtener(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente crear(@RequestBody Cliente c) { return repo.save(c); }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente c) {
        Cliente base = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
        base.setNombre(c.getNombre());
        base.setEdad(c.getEdad());
        base.setSexo(c.getSexo());
        base.setTelefono(c.getTelefono());
        base.setServicio(c.getServicio());
        return repo.save(base);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) { repo.deleteById(id); }
}
