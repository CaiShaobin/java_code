package com.abin.pojo;

public class Department {
    private Integer depId;
    private String depName;

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                '}';
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Department(Integer depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    public Department() {
    }
}
