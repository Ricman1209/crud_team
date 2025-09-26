package com.equipo.crudequipo.pago;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoRepository repo;

    public PagoController(PagoRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Pago> listar() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Pago obtener(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pago no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pago crear(@RequestBody Pago p) { return repo.save(p); }

    @PutMapping("/{id}")
    public Pago actualizar(@PathVariable Long id, @RequestBody Pago p) {
        Pago base = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pago no encontrado"));
        base.setCliente(p.getCliente());
        base.setCasa(p.getCasa());
        base.setHabitacion(p.getHabitacion());
        base.setTotalPago(p.getTotalPago());
        base.setStatusPago(p.getStatusPago());
        return repo.save(base);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) { repo.deleteById(id); }
}
