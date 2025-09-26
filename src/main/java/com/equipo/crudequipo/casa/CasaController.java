package com.equipo.crudequipo.casa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/casas")
public class CasaController {

    private final CasaRepository repo;

    public CasaController(CasaRepository repo) {
        this.repo = repo;
    }

    // LISTAR
    @GetMapping
    public List<Casa> listar() {
        return repo.findAll();
    }

    // OBTENER POR ID
    @GetMapping("/{id}")
    public Casa obtener(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Casa no encontrada"));
    }

    // CREAR
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Casa crear(@RequestBody Casa casa) {
        // sin validaciones avanzadas: directa al repo
        return repo.save(casa);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Casa actualizar(@PathVariable Long id, @RequestBody Casa cambios) {
        Casa actual = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Casa no encontrada"));
        // actualizamos campos simples
        actual.setUbicacion(cambios.getUbicacion());
        actual.setPrecioRenta(cambios.getPrecioRenta());
        return repo.save(actual);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Casa no encontrada");
        }
        repo.deleteById(id);
    }
}
