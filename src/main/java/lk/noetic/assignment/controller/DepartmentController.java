package lk.noetic.assignment.controller;


import lk.noetic.assignment.dto.DepartmentDTO;
import lk.noetic.assignment.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is a REST API which exposes all the CRUD operations for Department Entity
 * <p>
 *
 *
 * @author Ranga Lankathilaka
 */

@RestController
@CrossOrigin
@RequestMapping("api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;


    /**
     * This method returns all the department in the database
     * <p>
     * You can invoke this method by sending HTTP get request to api/v1/departments
     *
     * @return List of departments
     */
    @GetMapping
    public List<DepartmentDTO> findAllDepartments() {
        return departmentService.findAllDepartment();
    }


    /**
     * This method returns a department for specified department ID
     * <p>
     * You can invoke this method by sending HTTP get request to api/v1/departments/{and some form of ID}
     *
     * @param id department ID
     * @return Department
     */
    @GetMapping(value = "/{departmentID}")
    public DepartmentDTO findDepartment(@PathVariable("departmentID") String departmentID) {
        return departmentService.findDepartment(departmentID);
    }

    @PutMapping(value = "/{departmentID}")
    public void saveDepartment(@PathVariable("departmentID") String departmentID, @RequestBody DepartmentDTO departmentDTO) {


        departmentService.saveDepartment(departmentID, departmentDTO);
    }

    @PostMapping(value = "/{departmentID}")
    public boolean updateDepartment(@PathVariable("departmentID") String departmentID, @RequestBody DepartmentDTO departmentDTO) {
        return departmentService.updateDepartment(departmentID, departmentDTO);
    }

    @DeleteMapping(value = "/{departmentID}")
    public boolean deleteDepartment(@PathVariable("departmentID") String departmentID) {
        return departmentService.deleteDepartment(departmentID);
    }
}
