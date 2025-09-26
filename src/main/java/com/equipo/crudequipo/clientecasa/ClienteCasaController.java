package com.equipo.crudequipo.clientecasa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/clientes-casas")
public class ClienteCasaController {

    private final ClienteCasaRepository repo;

    public ClienteCasaController(ClienteCasaRepository repo) { this.repo = repo; }

    @GetMapping
    public List<ClienteCasa> listar() { return repo.findAll(); }

    @GetMapping("/cliente/{clienteId}/casa/{casaId}")
    public ClienteCasa obtener(@PathVariable Long clienteId, @PathVariable Long casaId) {
        ClienteCasaId id = new ClienteCasaId(clienteId, casaId);
        return repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Relación no encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteCasa crear(@RequestBody ClienteCasa cc) { return repo.save(cc); }

    @PutMapping("/cliente/{clienteId}/casa/{casaId}")
    public ClienteCasa actualizar(@PathVariable Long clienteId, @PathVariable Long casaId, @RequestBody ClienteCasa cc) {
        ClienteCasaId id = new ClienteCasaId(clienteId, casaId);
        ClienteCasa base = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Relación no encontrada"));
        base.setRol(cc.getRol());
        // cliente y casa se mantienen; si llega distinto, puedes reasignar:
        if (cc.getCliente()!=null) base.setCliente(cc.getCliente());
        if (cc.getCasa()!=null) base.setCasa(cc.getCasa());
        return repo.save(base);
    }

    @DeleteMapping("/cliente/{clienteId}/casa/{casaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long clienteId, @PathVariable Long casaId) {
        repo.deleteById(new ClienteCasaId(clienteId, casaId));
    }
}
