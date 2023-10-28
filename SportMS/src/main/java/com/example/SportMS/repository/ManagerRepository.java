package com.example.SportMS.repository;

import com.example.SportMS.model.Event;
import com.example.SportMS.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    List<Manager> findAllById(int id);

}
