package com.equipo.crudequipo.clientecasa;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.equipo.crudequipo.cliente.Cliente;
import com.equipo.crudequipo.casa.Casa;

@Entity
@Table(name = "clientes_casas")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ClienteCasa {

    public enum Rol { propietario, arrendatario }

    @EmbeddedId
    private ClienteCasaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("clienteId")
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("casaId")
    @JoinColumn(name = "id_casa")
    private Casa casa;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol", length = 20)
    private Rol rol;

    // getters/setters
    public ClienteCasaId getId() { return id; }
    public void setId(ClienteCasaId id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Casa getCasa() { return casa; }
    public void setCasa(Casa casa) { this.casa = casa; }
    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }
}
