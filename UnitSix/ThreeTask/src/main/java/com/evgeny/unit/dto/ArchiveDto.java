package com.evgeny.unit.dto;

public class ArchiveDto {
    private Integer id;
    private String name;
    private String group;
    private String department;

    public ArchiveDto() {
    }

    public ArchiveDto(Integer id, String name, String group, String department) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "ArchiveDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}