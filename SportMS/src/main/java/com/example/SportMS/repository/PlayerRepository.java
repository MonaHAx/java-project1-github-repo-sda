package com.example.SportMS.repository;

import com.example.SportMS.model.Manager;
import com.example.SportMS.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findAllById(long id);

    List<Player> getBySportSpecialization(String sportSpecialization);

}
