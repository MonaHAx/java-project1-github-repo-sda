package com.example.SportMS.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
@Id
    private Long id;
    @NotEmpty(message = "name can not be empty")
    private String name;
    private String email;
    private int age;
    @NotEmpty(message = "sport specialization can not be empty")
    private String sportSpecialization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    @JsonIgnoreProperties(value = {"players"}, allowSetters = true)
    private Manager manager;


    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = {"player"}, allowSetters = true)
    private List<Event> events;

    public Long getId() {
        return id;}


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", sportSpecialization='" + sportSpecialization + '\'' +
                '}';
    }
}
