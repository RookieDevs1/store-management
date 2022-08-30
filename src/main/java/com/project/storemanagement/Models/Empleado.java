package com.project.storemanagement.Models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "empleado")
public class Empleado {
    // Declarar Variables

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    private String nombre;


    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Enum_RoleName role;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Movimiento> Movimientos = new ArrayList<>();

    @Column(name = "updatedAt")
    private Date updatedAt;
    @Column(name = "createdAt")
    private Date createdAt;


    //Constructor vacio
    public Empleado() {
    }
  //constuctor


    public Empleado(long id, String nombre, String email, Profile profile, Enum_RoleName role, Empresa empresa, List<Movimiento> movimientos, Date updatedAt, Date createdAt) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.profile = profile;
        this.role = role;
        this.empresa = empresa;
        Movimientos = movimientos;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
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

    public List<Movimiento> getMovimientos() {
        return Movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        Movimientos = movimientos;
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

 /*   @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '}';

        }
  */

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", profile=" + profile +
                ", role=" + role +
                ", empresa=" + empresa +
                ", Movimientos=" + Movimientos +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
