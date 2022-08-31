package com.project.storemanagement.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    private String nombre;

    @Column(name = "documento", nullable = false, unique = true, length = 50)
    private String documento;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @OneToMany
    @JsonManagedReference
    private List<Empleado> empleados = new ArrayList<>();

    @OneToMany
    @JsonManagedReference
    private List<Movimiento> movimientos = new ArrayList<>();

    @Column(name = "createdAt")
    private Date updatedAt;

    @Column(name = "updatedAt")
    private Date createdAt;


    //Constructor Vacio
    public Empresa() {
    }
    //Constructor con todos los atributos

    public Empresa(long id, String nombre, String documento, String telefono, String direccion, List<Empleado> empleados, List<Movimiento> movimientos, Date updatedAt, Date createdAt) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.empleados = empleados;
        this.movimientos = movimientos;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }


    // Setter y Getters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
