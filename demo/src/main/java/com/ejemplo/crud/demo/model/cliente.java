package com.ejemplo.crud.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nombre_cliente", nullable = false, length = 50)
    private String nombre;

    @Column(name = "edad_cliente")
    private Integer edad;

    @Column(name = "sexo_cliente", length = 2)
    private String sexo;

    @Column(name = "telefono_cliente", length = 20)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(name = "servicio_cliente", nullable = false)
    private ServicioCliente servicio;

    // Enum para mapear el ENUM de MySQL
    public enum ServicioCliente {
        Comprador, Arrendador
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public ServicioCliente getServicio() { return servicio; }
    public void setServicio(ServicioCliente servicio) { this.servicio = servicio; }
}
