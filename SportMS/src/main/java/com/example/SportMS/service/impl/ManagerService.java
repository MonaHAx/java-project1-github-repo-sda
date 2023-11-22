package com.example.SportMS.service.impl;

import com.example.SportMS.model.Manager;
import com.example.SportMS.model.Player;
import com.example.SportMS.repository.ManagerRepository;
import com.example.SportMS.service.interfaces.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService implements IManagerService {

@Autowired
    ManagerRepository managerRepository;


    @Override
    public void updateName(String managerDTO, Integer id) {
        Optional<Manager> managerOptional=managerRepository.findById(id);
        if (managerOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Manager " + id + " not found");
        Manager manager=managerOptional.get();
        manager.setName(managerDTO);
        managerRepository.save(manager);
    }

    @Override
    public Manager getManagerById(Integer id) {
        Optional<Manager> managerOptional = managerRepository.findById(id);
        if (managerOptional.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player " + id + " not found");
        return managerOptional.get();
    }
    }

