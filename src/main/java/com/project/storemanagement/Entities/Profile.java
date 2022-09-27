package com.project.storemanagement.Entities;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "email",  unique = true)
    private String email;

    @Column(name = "image")
    private String image;


    @Column(name = "authoId" ,  unique = true)
    private String authoId;


    @OneToOne
   @JoinColumn(name = "employee_id")
    private Employee employee;


    public Profile() {
    }

    public Profile(Long id, String password, boolean status) {
        this.id = id;
       // this.password = password;
     //   this.status = status;
    }

    public Profile(String name, String email, String image, String authoId) {
        this.name = name;
        this.email = email;
        this.image = image;
        this.authoId = authoId;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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


}
