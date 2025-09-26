package com.equipo.crudequipo.clientecasa;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ClienteCasaId implements Serializable {
    @Column(name = "id_cliente")
    private Long clienteId;

    @Column(name = "id_casa")
    private Long casaId;

    public ClienteCasaId() {}
    public ClienteCasaId(Long clienteId, Long casaId) {
        this.clienteId = clienteId; this.casaId = casaId;
    }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public Long getCasaId() { return casaId; }
    public void setCasaId(Long casaId) { this.casaId = casaId; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteCasaId)) return false;
        ClienteCasaId that = (ClienteCasaId) o;
        return java.util.Objects.equals(clienteId, that.clienteId)
                && java.util.Objects.equals(casaId, that.casaId);
    }
    @Override public int hashCode() {
        return java.util.Objects.hash(clienteId, casaId);
    }
}
