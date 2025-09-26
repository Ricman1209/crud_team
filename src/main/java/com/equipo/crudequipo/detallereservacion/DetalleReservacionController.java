package com.equipo.crudequipo.detallereservacion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/detalle-reservaciones")
public class DetalleReservacionController {

    private final DetalleReservacionRepository repo;

    public DetalleReservacionController(DetalleReservacionRepository repo) { this.repo = repo; }

    @GetMapping
    public List<DetalleReservacion> listar() { return repo.findAll(); }

    @GetMapping("/{id}")
    public DetalleReservacion obtener(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Detalle no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleReservacion crear(@RequestBody DetalleReservacion d) { return repo.save(d); }

    @PutMapping("/{id}")
    public DetalleReservacion actualizar(@PathVariable Long id, @RequestBody DetalleReservacion d) {
        DetalleReservacion base = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Detalle no encontrado"));
        base.setReservacion(d.getReservacion());
        base.setFechaPrimerDia(d.getFechaPrimerDia());
        base.setFechaUltimoDia(d.getFechaUltimoDia());
        base.setStatusReservacion(d.getStatusReservacion());
        return repo.save(base);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) { repo.deleteById(id); }
}
