package com.abin.pojo;

import java.util.List;

public class Role {

    private int id;
    private String role;
    private List<Permission> permission;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", permission=" + permission +
                '}';
    }

    public Role() {
    }

    public Role(int id, String role, List<Permission> permission) {
        this.id = id;
        this.role = role;
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Permission> getPermission() {
        return permission;
    }

    public void setPermission(List<Permission> permission) {
        this.permission = permission;
    }
}
