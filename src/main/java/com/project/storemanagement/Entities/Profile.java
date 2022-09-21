package com.project.storemanagement.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "email",  unique = true)
    private String email;

    @Column(name = "image")
    private String image;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "authoId" ,  unique = true)
    private String authoId;


   @JoinColumn(name = "employee_id")
   @OneToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @Column(name = "createdAt")
    private Date createdAt;

    public Profile() {
    }

    public Profile(Long id, String email, String image, String phone, String authoId, Employee employee, Date createdAt) {
        this.id = id;
        this.email = email;
        this.image = image;
        this.phone = phone;
        this.authoId = authoId;
        this.employee = employee;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAuthoId() {
        return authoId;
    }

    public void setAuthoId(String authoId) {
        this.authoId = authoId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
