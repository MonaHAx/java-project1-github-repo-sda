package com.example.SportMS.controller.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDTO {
    @NotEmpty(message = "name can not be empty")
    private String name;



    public String getName() {
        return name;
    }

}
