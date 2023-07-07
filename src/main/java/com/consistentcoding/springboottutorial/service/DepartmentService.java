package com.consistentcoding.springboottutorial.service;

import com.consistentcoding.springboottutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchAllDepartments();

    public Department fetchDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department getDepartmentByName(String departmentName);
}
