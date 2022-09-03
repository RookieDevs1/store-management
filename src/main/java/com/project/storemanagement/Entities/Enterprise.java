package com.project.storemanagement.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "enterprise")
@JsonIgnoreProperties({"hibernateLazyInitializer","hanler"})
public class Enterprise {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 55)
    private String name;

    @Column(name = "document", nullable = false, unique = true, length = 20)
    private String document;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "direction", nullable = false, length = 60)
    private String direction;
    @JsonIgnore
    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Employee> employees;
    @JsonIgnore
    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transaction> transactions;


    @Column(name = "createdAt")
    private Date updatedAt;

    @Column(name = "updatedAt")
    private Date createdAt;


    //Constructor Vacio
    public Enterprise() {
    }
    //Constructor con todos los atributos

    public Enterprise(Long id, String name, String document, String phone, String direction, List<Employee> employees, List<Transaction> transaction, Date updatedAt, Date createdAt) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.direction = direction;
        this.employees = employees;
        this.transactions = transaction;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }


    // Setter y Getters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Transaction> getTransaction() {
        return transactions;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transactions = transaction;
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
