package com.abin.pojo;

public class Permission {
    private int id;
    private String permission;

    public Permission(int id, String permission) {
        this.id = id;
        this.permission = permission;
    }

    public Permission() {
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
