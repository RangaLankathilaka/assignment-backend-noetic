package lk.noetic.assignment.controller;

import lk.noetic.assignment.dto.EmployeeDTO;
import lk.noetic.assignment.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * This is a REST API which exposes all the CRUD operations for Employee Entity
 * <p>
 *
 *
 * @author Ranga Lankathilaka
 */
@RestController
@CrossOrigin
@RequestMapping("api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    /**
     * This method returns all the employee in the database
     * <p>
     * You can invoke this method by sending HTTP get request to api/v1/employees
     *
     * @return List of Empoyees
     */
    @GetMapping
    public List<EmployeeDTO> findAllEmployees() {
        return employeeService.findAllEmployee();
    }


    /**
     * This method returns a employee for specified employee ID
     * <p>
     * You can invoke this method by sending HTTP get request to api/v1/employees/{and some form of ID}
     *
     * @param id employee ID
     * @return Employee
     */

    @GetMapping(value = "/{employeeID}")
    public EmployeeDTO findCustomer(@PathVariable("employeeID") String employeeID) {
        return employeeService.findEmployee(employeeID);
    }

    @PutMapping(value = "/{employeeID}")
    public void saveEmployee(@PathVariable("employeeID") String employeeID, @RequestBody EmployeeDTO employeeDTO) {


        employeeService.saveEmployee(employeeID, employeeDTO);
    }

    @PostMapping(value = "/{employeeID}")
    public boolean updateEmployee(@PathVariable("employeeID") String employeeID, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(employeeID, employeeDTO);
    }

    @DeleteMapping(value = "/{employeeID}")
    public boolean deleteEmployee(@PathVariable("employeeID") String employeeID) {
        return employeeService.deleteEmployee(employeeID);
    }



}
