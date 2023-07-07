package com.consistentcoding.springboottutorial.controller;

import com.consistentcoding.springboottutorial.entity.Department;
import com.consistentcoding.springboottutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
     public Department saveDepartment(@RequestBody Department department){
        LOGGER.info("Inside saveDepartment methode");
            return  departmentService.saveDepartment(department);
     }

     @GetMapping("/departments")
     public List<Department> fetchAllDepartments(){
         LOGGER.info("Inside fetchAllDepartments methode");
        return departmentService.fetchAllDepartments();
     }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Successfully deleted!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){

        return departmentService.getDepartmentByName(departmentName);
    }
}
