package com.falconworks.wbsedclapp.admin.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "mobile_no")
    private String mobile;

    @Column(name="email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="authorization", joinColumns=@JoinColumn(name="user_id"))
    @Column(name="authorization")
    private List<String> authorizations;

    @Column(name="enabled", columnDefinition = "TINYINT")
    private boolean isEnabled;

    public User() {

    }

    public User(String username, String password, String mobile, String email, Address address, boolean isEnabled) {
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.isEnabled = isEnabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(List<String> authorizations) {
        this.authorizations = authorizations;
    }

    public void addAuthorization(String authorization) {
        if (authorizations == null) {
            authorizations = new ArrayList<>();
        }
        this.authorizations.add(authorization);
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", authorizations=" + authorizations +
                '}';
    }
}
