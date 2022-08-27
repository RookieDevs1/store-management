package com.project.storemanagement.Models;


import javax.persistence.*;
import java.util.Date;

@Table
@Entity
public class Empleado {
    // Declarar Variables

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;

    @Column(name = "email", unique = true)
    private String email;


    private Profile profile;
    private Enum_RoleName role;

    @ManyToOne
    private Empresa empresa;
    private Movimiento movimiento;
    private Date updatedAt;
    private Date createdAt;

    //Constructor vacio
    public Empleado() {
    }

    public Empleado(long id, String nombre, String email, Date updatedAt, Date createdAt, Profile profile, Enum_RoleName role, Empresa empresa, Movimiento movimiento) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.profile = profile;
        this.role = role;
        this.empresa = empresa;
        this.movimiento = movimiento;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Enum_RoleName getRole() {
        return role;
    }

    public void setRole(Enum_RoleName role) {
        this.role = role;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '}';
    }
}
