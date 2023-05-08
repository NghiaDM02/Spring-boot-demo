package com.garvez.springbootdemo.service;

import com.garvez.springbootdemo.entity.Department;
import com.garvez.springbootdemo.error.DepartmentNotFoundException;
import com.garvez.springbootdemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceIml implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> findDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartmentById(long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Available!");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void updateDepartment(long id, Department department) throws DepartmentNotFoundException {
        Department depDB = findDepartmentById(id);
        if (Objects.nonNull(department.getName()) && !department.getName().isBlank()) {
            depDB.setName(department.getName());
        }
        if (Objects.nonNull(department.getCode()) && !department.getCode().isBlank()){
         depDB.setCode(department.getCode());
        }
        if (Objects.nonNull(department.getAddress()) && !department.getAddress().isBlank()) {
            depDB.setAddress(department.getAddress());
        }

        departmentRepository.save(depDB);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }
}