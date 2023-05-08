package com.garvez.springbootdemo.service;

import com.garvez.springbootdemo.entity.Department;
import com.garvez.springbootdemo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    List<Department> findDepartmentList();

    Department findDepartmentById(long id) throws DepartmentNotFoundException;

    void deleteDepartmentById(long id);

    void updateDepartment(long id, Department department) throws DepartmentNotFoundException;

    Department findDepartmentByName(String name);
}
