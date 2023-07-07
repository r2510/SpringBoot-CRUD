package com.consistentcoding.springboottutorial.service;

import com.consistentcoding.springboottutorial.entity.Department;
import com.consistentcoding.springboottutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    public DepartmentService departmentService;
    @MockBean
    public DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentId(1L)
                        .departmentCode("CERT^")
                        .departmentAddress("VFDG")
                        .departmentName("IT")
                        .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("fetched Department Name")
    @Disabled
    public void fetchWithValidDepartmentName(){
        String departmentName = "IT";
        Department department = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName, department.getDepartmentName());
    }
}