package com.equipo.crudequipo.casa;

import jakarta.persistence.*;

@Entity
@Table(name = "casas")
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_casa")
    private Long id;

    @Column(name = "ubicacion_casa", nullable = false)
    private String ubicacion;

    @Column(name = "precio_renta_casa", nullable = false)
    private Integer precioRenta;

    // --- Getters y setters sencillos ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public Integer getPrecioRenta() {
        return precioRenta;
    }

    public void setPrecioRenta(Integer precioRenta) { this.precioRenta = precioRenta; }
}
