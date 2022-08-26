package com.project.storemanagement.Controladores;

public class Empresa {
    //Atributos
    private String nombre;
    private String direccion;
    private int telefono;
    private long nit;

    //Constructor Vacio
    public Empresa() {
    }
    //Constructor con todos los atributos
    public Empresa(String nombre, String direccion, int telefono, long nit) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
    }
    // Setter y Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    //To String
    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", nit=" + nit +
                '}';
    }
}
