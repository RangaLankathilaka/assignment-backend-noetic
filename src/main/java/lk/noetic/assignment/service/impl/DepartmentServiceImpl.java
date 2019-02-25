package lk.noetic.assignment.service.impl;

import lk.noetic.assignment.dto.DepartmentDTO;
import lk.noetic.assignment.entity.Department;
import lk.noetic.assignment.repository.DepartmentRepository;
import lk.noetic.assignment.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    @Override
    public List<DepartmentDTO> findAllDepartment() {

        List<Department> departmentList = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOList=new ArrayList<>();

        departmentList.forEach(department -> {
            DepartmentDTO departmentDTO=new DepartmentDTO();
            BeanUtils.copyProperties(department,departmentDTO);
            departmentDTOList.add(departmentDTO);
        });


        return departmentDTOList;
    }
    @Transactional(readOnly = true)
    @Override
    public DepartmentDTO findDepartment(String departmentID) {

        Department department = departmentRepository.findById(departmentID).get();

        DepartmentDTO departmentDTO = new DepartmentDTO();

        BeanUtils.copyProperties(department,departmentDTO);


        return departmentDTO;
    }

    @Override
    public void saveDepartment(String departmentID, DepartmentDTO departmentDTO) {
        if (!departmentID.equals(departmentDTO.getDepartmentID())){
            throw new RuntimeException("Department IDs are mismatched");
        }

        Department department = new Department();
        BeanUtils.copyProperties(departmentDTO,department);
        departmentRepository.save(department);
    }

    @Override
    public boolean updateDepartment(String departmentID, DepartmentDTO departmentDTO) {
        if (departmentRepository.existsById(departmentID)) {
            saveDepartment(departmentID,departmentDTO);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteDepartment(String departmentID) {
        departmentRepository.deleteById(departmentID);
        return true;
    }
}
