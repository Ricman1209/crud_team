package com.equipo.crudequipo.reservacion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/reservaciones")
public class ReservacionController {

    private final ReservacionRepository repo;

    public ReservacionController(ReservacionRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Reservacion> listar() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Reservacion obtener(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservación no encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion crear(@RequestBody Reservacion r) { return repo.save(r); }

    @PutMapping("/{id}")
    public Reservacion actualizar(@PathVariable Long id, @RequestBody Reservacion r) {
        Reservacion base = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservación no encontrada"));
        base.setCliente(r.getCliente());
        base.setCasa(r.getCasa());
        base.setHabitacion(r.getHabitacion());
        base.setFechaReservacion(r.getFechaReservacion());
        return repo.save(base);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) { repo.deleteById(id); }
}
