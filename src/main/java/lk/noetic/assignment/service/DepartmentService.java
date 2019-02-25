package lk.noetic.assignment.service;



import lk.noetic.assignment.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDTO> findAllDepartment();

    DepartmentDTO findDepartment(String departmentID);

    void saveDepartment(String departmentID, DepartmentDTO departmentDTO);

    boolean updateDepartment(String departmentID, DepartmentDTO departmentDTO);

    boolean deleteDepartment(String departmentID);
}
