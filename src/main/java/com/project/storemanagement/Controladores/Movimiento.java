package com.project.storemanagement.Controladores;
public class Movimiento {
    private long monto;
    private String concepto;
    private String User;

    public Movimiento() {
    }

    public Movimiento(long monto, String concepto, String user) {
        this.monto = monto;
        this.concepto = concepto;
        User = user;
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

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

}
