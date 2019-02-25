package lk.noetic.assignment.dto;

public class EmployeeDTO {

    private String employeeID;
    private String firstname;
    private String lastname;
    private DepartmentDTO departmentDTO;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String employeeID, String firstname, String lastname, DepartmentDTO departmentDTO) {
        this.employeeID = employeeID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.departmentDTO = departmentDTO;
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

    public DepartmentDTO getDepartmentDTO() {
        return departmentDTO;
    }

    public void setDepartmentDTO(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeID='" + employeeID + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", departmentDTO=" + departmentDTO +
                '}';
    }
}
