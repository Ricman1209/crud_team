package com.equipo.crudequipo.reservacion;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.equipo.crudequipo.cliente.Cliente;
import com.equipo.crudequipo.casa.Casa;
import com.equipo.crudequipo.habitacion.Habitacion;
import java.time.LocalDate;

@Entity
@Table(name = "reservaciones")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Reservacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservacion")
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

    @Column(name = "fecha_reservacion", nullable = false)
    private LocalDate fechaReservacion;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Casa getCasa() { return casa; }
    public void setCasa(Casa casa) { this.casa = casa; }
    public Habitacion getHabitacion() { return habitacion; }
    public void setHabitacion(Habitacion habitacion) { this.habitacion = habitacion; }
    public LocalDate getFechaReservacion() { return fechaReservacion; }
    public void setFechaReservacion(LocalDate fechaReservacion) { this.fechaReservacion = fechaReservacion; }
}
