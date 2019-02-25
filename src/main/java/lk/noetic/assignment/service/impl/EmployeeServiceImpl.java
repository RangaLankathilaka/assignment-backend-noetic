package lk.noetic.assignment.service.impl;

import lk.noetic.assignment.dto.DepartmentDTO;
import lk.noetic.assignment.dto.EmployeeDTO;
import lk.noetic.assignment.entity.Department;
import lk.noetic.assignment.entity.Employee;
import lk.noetic.assignment.repository.EmployeeRepository;
import lk.noetic.assignment.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    @Override
    public List<EmployeeDTO> findAllEmployee() {

        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList=new ArrayList<>();

        employeeList.forEach(employee -> {
            EmployeeDTO employeeDTO=new EmployeeDTO();

            //department properties
            Department department = employee.getDepartment();
            DepartmentDTO departmentDTO=new DepartmentDTO();
            BeanUtils.copyProperties(department,departmentDTO);
            employeeDTO.setDepartmentDTO(departmentDTO);

            //common properties
            BeanUtils.copyProperties(employee,employeeDTO);
            employeeDTOList.add(employeeDTO);
        });



        return employeeDTOList;
    }

    @Transactional(readOnly = true)
    @Override
    public EmployeeDTO findEmployee(String employeeID) {
        Employee employee = employeeRepository.findById(employeeID).get();
        EmployeeDTO employeeDTO=new EmployeeDTO();

        //Department Properties
        Department department = employee.getDepartment();
        DepartmentDTO departmentDTO=new DepartmentDTO();
        BeanUtils.copyProperties(department,departmentDTO);

        employeeDTO.setDepartmentDTO(departmentDTO);


        //common properties
        BeanUtils.copyProperties(employee,employeeDTO);
        return employeeDTO;
    }

    @Override
    public void saveEmployee(String employeeID, EmployeeDTO employeeDTO) {

        if (!employeeID.equals(employeeDTO.getEmployeeID())){
            throw new RuntimeException("Employee IDs are mismatched");
        }

        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);

        //department
        DepartmentDTO departmentDTO = employeeDTO.getDepartmentDTO();
        Department department=new Department();
        BeanUtils.copyProperties(departmentDTO,department);

        employee.setDepartment(department);

        employeeRepository.save(employee);

    }

    @Override
    public boolean updateEmployee(String employeeID, EmployeeDTO employeeDTO) {
        if (employeeRepository.existsById(employeeID)) {
            saveEmployee(employeeID,employeeDTO);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(String employeeID) {
        employeeRepository.deleteById(employeeID);
        return true;
    }
}
