package lk.noetic.assignment.service;

import lk.noetic.assignment.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAllEmployee();

    EmployeeDTO findEmployee(String employeeID);

    void saveEmployee(String employeeID, EmployeeDTO employeeDTO);

    boolean updateEmployee(String employeeID, EmployeeDTO employeeDTO);

    boolean deleteEmployee(String employeeID);
}
