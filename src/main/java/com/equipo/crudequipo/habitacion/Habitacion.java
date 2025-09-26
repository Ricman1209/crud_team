package com.equipo.crudequipo.habitacion;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.equipo.crudequipo.casa.Casa;

@Entity
@Table(name = "habitaciones")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_casa", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Casa casa;

    @Column(name = "numero_habitacion", nullable = false)
    private Integer numeroHabitacion;

    @Column(name = "precio_renta_habitacion", nullable = false)
    private Integer precioRentaHabitacion;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Casa getCasa() { return casa; }
    public void setCasa(Casa casa) { this.casa = casa; }
    public Integer getNumeroHabitacion() { return numeroHabitacion; }
    public void setNumeroHabitacion(Integer numeroHabitacion) { this.numeroHabitacion = numeroHabitacion; }
    public Integer getPrecioRentaHabitacion() { return precioRentaHabitacion; }
    public void setPrecioRentaHabitacion(Integer precioRentaHabitacion) { this.precioRentaHabitacion = precioRentaHabitacion; }
}
