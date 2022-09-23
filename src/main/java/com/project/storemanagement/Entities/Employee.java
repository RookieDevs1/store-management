package com.project.storemanagement.Entities;


import com.project.storemanagement.Enum.Enum_RoleName;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@ToString
@Table(name = "employee")
public class Employee {
    // Declarar Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name",  unique = true, length = 55)
    private String name;


    @Column(name = "email", unique = true, length = 60)
    private String email;



    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Enum_RoleName role;

   @ManyToOne
   @JoinColumn(name = "enterprise_id")
   private Enterprise enterprise;

   @Transient
    Transaction transaction;

    @Column(name = "updatedAt")
    private Date updatedAt;

    @Column(name = "createdAt")
    private Date createdAt;



    public Employee() {
    }


  //constuctor


    public Employee(Long id, String name, String email, Enum_RoleName role, Enterprise enterprise, Transaction transaction, Date updatedAt, Date createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.enterprise = enterprise;
        this.transaction = transaction;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Enum_RoleName getRole() {
        return role;
    }

    public void setRole(Enum_RoleName role) {
        this.role = role;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
