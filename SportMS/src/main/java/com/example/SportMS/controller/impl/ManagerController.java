package com.example.SportMS.controller.impl;

import com.example.SportMS.controller.dto.ManagerDTO;
import com.example.SportMS.model.Event;
import com.example.SportMS.model.Manager;
import com.example.SportMS.repository.ManagerRepository;
import com.example.SportMS.service.interfaces.IManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ManagerController  {

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    IManagerService managerService;


    //--------------------------GET-------------------
    @GetMapping("/manager")
    public List<Manager> findAll(){
        return managerRepository.findAll();
    }

    @GetMapping("/manager/{id}")
    public Manager getManagertById(@PathVariable(name = "id") Integer id ) {
        return managerService.getManagerById(id);
    }

//--------------------------POST-------------------
    @PostMapping("/manager")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveManager(@RequestBody  Manager manager){
        managerRepository.save(manager);
    }

//--------------------------PATCH-------------------
    @PatchMapping("/manager/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateManagerName(@RequestBody @Valid ManagerDTO managerDTO, @PathVariable Integer id){
        managerService.updateName(managerDTO.getName(),id);
    }



}
