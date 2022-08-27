package com.project.storemanagement.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Empresa {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;

    @Column(name = "documento", unique = true)
    private String documento;
    private int telefono;
    private String direccion;

    @OneToMany
    private Empleado empleado;
    private Movimiento movimiento;
    private Date updatedAt;
    private Date createdAt;

    //Constructor Vacio
    public Empresa() {
    }
    //Constructor con todos los atributos

    public Empresa(long id, String nombre, String documento, int telefono, String direccion, Empleado empleado, Movimiento movimiento, Date updatedAt, Date createdAt) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.empleado = empleado;
        this.movimiento = movimiento;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
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
