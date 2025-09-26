package com.equipo.crudequipo.habitacion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    private final HabitacionRepository repo;

    public HabitacionController(HabitacionRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Habitacion> listar() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Habitacion obtener(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Habitación no encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Habitacion crear(@RequestBody Habitacion h) { return repo.save(h); }

    @PutMapping("/{id}")
    public Habitacion actualizar(@PathVariable Long id, @RequestBody Habitacion h) {
        Habitacion base = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Habitación no encontrada"));
        base.setCasa(h.getCasa());
        base.setNumeroHabitacion(h.getNumeroHabitacion());
        base.setPrecioRentaHabitacion(h.getPrecioRentaHabitacion());
        return repo.save(base);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) { repo.deleteById(id); }
}
