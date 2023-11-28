package com.badminton.shuttlestats.repository;

import com.badminton.shuttlestats.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, String> {

    List<Player> findAll();
    Optional<Player> findById(UUID uuid);

    List<Player> findByGender(String Gender);

    void deleteById(UUID uuid);
}
