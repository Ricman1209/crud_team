package com.equipo.crudequipo.pago;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.equipo.crudequipo.cliente.Cliente;
import com.equipo.crudequipo.casa.Casa;
import com.equipo.crudequipo.habitacion.Habitacion;

@Entity
@Table(name = "pagos")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Pago {

    public enum StatusPago { Pagado, Abonado, Pendiente }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_casa", nullable = false)
    private Casa casa;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_habitacion", nullable = false)
    private Habitacion habitacion;

    @Column(name = "total_pago", nullable = false)
    private Integer totalPago;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_pago", nullable = false, length = 10)
    private StatusPago statusPago;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Casa getCasa() { return casa; }
    public void setCasa(Casa casa) { this.casa = casa; }
    public Habitacion getHabitacion() { return habitacion; }
    public void setHabitacion(Habitacion habitacion) { this.habitacion = habitacion; }
    public Integer getTotalPago() { return totalPago; }
    public void setTotalPago(Integer totalPago) { this.totalPago = totalPago; }
    public StatusPago getStatusPago() { return statusPago; }
    public void setStatusPago(StatusPago statusPago) { this.statusPago = statusPago; }
}
