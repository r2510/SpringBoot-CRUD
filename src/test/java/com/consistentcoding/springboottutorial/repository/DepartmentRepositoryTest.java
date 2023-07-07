package com.consistentcoding.springboottutorial.repository;

import com.consistentcoding.springboottutorial.entity.Department;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    public EntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("ME")
                        .departmentCode("DE-02")
                        .departmentAddress("Vapi")
                        .build();

        entityManager.persist(department);

    }

    @Test
    public void testRepository()
    {
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "ME");
    }

}