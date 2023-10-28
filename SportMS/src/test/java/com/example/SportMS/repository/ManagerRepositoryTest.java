package com.example.SportMS.repository;

import com.example.SportMS.model.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ManagerRepositoryTest {

    @Autowired
    ManagerRepository managerRepository;


    @Test
    public void testFindAllById() {
        List<Manager> managers = managerRepository.findAllById(1);
        assertEquals(1, managers.size());
System.out.println(managers);

    }

/*
    @Test
    public void FindAll() {
        List<Manager> manager = managerRepository.findAll();
        System.out.println(manager);

    }*/

}