package com.MentalHealthProject.mentalHealth.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Document("users")
public class User implements UserDetails {
    private ObjectId _id;
    private String name;
    private Long number;
    @Indexed(unique = true)
    private String email;
    private String password;
    private EmergencyContact emergencyContact;
    private boolean enabled = true;

    public User() {

    }

    public User(ObjectId _id, String name, String email, Long number, String password, EmergencyContact emergencyContact, boolean enabled) {
        this._id = _id;
        this.name = name;
        this.number = number;
        this.email = email;
        this.password = password;
        this.emergencyContact = emergencyContact;
        this.enabled = enabled;
    }

    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return email;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Long getNumber() { return number; }

    public void setNumber(Long number) { this.number = number; }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
