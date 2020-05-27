package com.dil.calories.model;

import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

public class User extends AbstractNamedEntity {

    private String email;

    private String password;

    private int caloriesPerDate;

    private boolean enabled;

    private Date registered = new Date();

    private Set<Role> roles;

    public User(Integer id, String name, String email, String password, Role role, Role... roles) {
        this(id, name, email, password, 2000, true,  EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String email, String password, int caloriesPerDate, boolean enabled, Set<Role> roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.caloriesPerDate = caloriesPerDate;
        this.enabled = enabled;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCaloriesPerDate() {
        return caloriesPerDate;
    }

    public void setCaloriesPerDate(int caloriesPerDate) {
        this.caloriesPerDate = caloriesPerDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", caloriesPerDate=" + caloriesPerDate +
                ", enabled=" + enabled +
                ", registered=" + registered +
                ", roles=" + roles +
                '}';
    }
}