package com.project.storemanagement.Entities;
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

    @Column(name = "image")
    private String image;

    @Column(name = "phone", length = 15)
    private String phone;

    @OneToOne
    @JoinColumn(name = "empleado_id")
    private Employee employee;

    @Column(name = "updatedAt")
    private Date updatedAt;

    @Column(name = "createdAt")
    private Date createdAt;
    public Profile() {
    }

    public Profile(Long id, String image, String phone, Employee employee, Date updatedAt, Date createdAt) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.employee = employee;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
