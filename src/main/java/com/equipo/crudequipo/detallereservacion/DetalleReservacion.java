package com.equipo.crudequipo.detallereservacion;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.equipo.crudequipo.reservacion.Reservacion;
import java.time.LocalDate;

@Entity
@Table(name = "detalle_reservaciones")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class DetalleReservacion {

    @Id
    @Column(name = "id_reservacion")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "id_reservacion")
    private Reservacion reservacion;

    @Column(name = "fecha_primer_dia", nullable = false)
    private LocalDate fechaPrimerDia;

    @Column(name = "fecha_ultimo_dia", nullable = false)
    private LocalDate fechaUltimoDia;

    // 0 libre, 1 ocupado -> lo mapeamos como boolean
    @Column(name = "status_reservacion", nullable = false)
    private Boolean statusReservacion;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Reservacion getReservacion() { return reservacion; }
    public void setReservacion(Reservacion reservacion) { this.reservacion = reservacion; }
    public LocalDate getFechaPrimerDia() { return fechaPrimerDia; }
    public void setFechaPrimerDia(LocalDate fechaPrimerDia) { this.fechaPrimerDia = fechaPrimerDia; }
    public LocalDate getFechaUltimoDia() { return fechaUltimoDia; }
    public void setFechaUltimoDia(LocalDate fechaUltimoDia) { this.fechaUltimoDia = fechaUltimoDia; }
    public Boolean getStatusReservacion() { return statusReservacion; }
    public void setStatusReservacion(Boolean statusReservacion) { this.statusReservacion = statusReservacion; }
}
