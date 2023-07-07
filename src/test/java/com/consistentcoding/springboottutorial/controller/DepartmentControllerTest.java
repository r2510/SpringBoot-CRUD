package com.consistentcoding.springboottutorial.controller;

import com.consistentcoding.springboottutorial.entity.Department;
import com.consistentcoding.springboottutorial.repository.DepartmentRepository;
import com.consistentcoding.springboottutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;




    @BeforeEach
    void setUp() {
        department =
                Department.builder()
                        .departmentName("ME")
                        .departmentCode("DE-02")
                        .departmentAddress("Vapi")
                        .departmentId(1l)
                        .build();

    }

    @Test
    void saveDepartment() throws Exception {
       Department inputdepartment =
                Department.builder()
                        .departmentName("ME")
                        .departmentCode("DE-02")
                        .departmentAddress("Vapi")
                        .build();

        Mockito.when(departmentService.saveDepartment(inputdepartment))
                .thenReturn(department);

        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"ME\",\n" +
                        "    \"departmentAddress\":\"Vapi\",\n" +
                        "    \"departmentCode\":\"DE-02\"\n" +
                        "}"))
                .andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentById() throws Exception {
            Mockito.when(departmentService.fetchDepartmentById(1l))
                    .thenReturn(department);


            mockMvc.perform(get("/departments")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
            //ok result and the department i am getting should match with Json department name




    }
}