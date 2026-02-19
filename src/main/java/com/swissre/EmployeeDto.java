package com.swissre;

public class EmployeeDto {

    private int id;
    private String name;
    private String department;

    public EmployeeDto() {
    }

    public EmployeeDto(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDto)) return false;
        EmployeeDto that = (EmployeeDto) o;
        return id == that.id
                && java.util.Objects.equals(name, that.name)
                && java.util.Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, name, department);
    }

    @Override
    public String toString() {
        return "EmployeeDto{id=" + id + ", name='" + name + "', department='" + department + "'}";
    }
}
