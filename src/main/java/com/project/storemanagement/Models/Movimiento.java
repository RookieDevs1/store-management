package com.project.storemanagement.Models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Movimiento {
    private long monto;
    private String concepto;

    @OneToOne
    private Empleado empleado;

    private Date updatedAt;
    private Date createdAt;

    public Movimiento() {
    }

    public Movimiento(long monto, String concepto, Empleado empleado, Date updatedAt, Date createdAt) {
        this.monto = monto;
        this.concepto = concepto;
        this.empleado = empleado;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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
