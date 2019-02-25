package lk.noetic.assignment.entity;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    private String employeeID;
    private String firstname;
    private String lastname;

    @OneToOne
    @JoinColumn(name = "departmentID",referencedColumnName = "departmentID")
    private Department department;

    public Employee() {
    }

    public Employee(String employeeID, String firstname, String lastname, Department department) {
        this.employeeID = employeeID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", department=" + department +
                '}';
    }
}
