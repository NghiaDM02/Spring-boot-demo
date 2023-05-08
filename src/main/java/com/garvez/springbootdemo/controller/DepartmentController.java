package com.garvez.springbootdemo.controller;

import com.garvez.springbootdemo.entity.Department;
import com.garvez.springbootdemo.error.DepartmentNotFoundException;
import com.garvez.springbootdemo.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return service.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return service.findDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department findDepartmentById(@PathVariable("id") long id) throws DepartmentNotFoundException {
        return service.findDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") long id) {
        service.deleteDepartmentById(id);
        return "Delete successfully!";
    }

    @PutMapping("/departments/{id}")
    public String updateDepartment(@PathVariable("id") long id,
                                   @RequestBody Department department) throws DepartmentNotFoundException {
        service.updateDepartment(id, department);
        return "Update department with id " + id + " successfully!";
    }

    @GetMapping("/departments/name/{name}")
    public Department findDepartmentByName(@PathVariable("name") String name) {
        return service.findDepartmentByName(name);
    }
}
