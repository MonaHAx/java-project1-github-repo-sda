package com.example.SportMS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Event {
@Id
    private Long id;
@NotEmpty(message = "name can not be empty")
    private String name;
    @NotEmpty(message = "date can not be empty")
    private String date;
    @NotEmpty(message = "time can not be empty")
    private String time;
    @NotEmpty(message = "status can not be empty")
    private String status;
    @NotEmpty(message = "platform can not be empty")
    private String platform;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    @JsonIgnoreProperties(value = {"events", "players"}, allowSetters = true)
    private Manager manager;


    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonIgnoreProperties(value = {"events", "manager"}, allowSetters = true)
    private Player player;

}
