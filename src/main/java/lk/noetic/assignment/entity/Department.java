package lk.noetic.assignment.entity;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    private String departmentID;
    private String departmentName;
    @OneToOne(mappedBy = "department",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private  Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department() {
    }

    public Department(String departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID='" + departmentID + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
