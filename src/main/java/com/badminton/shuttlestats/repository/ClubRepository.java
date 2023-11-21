package com.badminton.shuttlestats.repository;

import com.badminton.shuttlestats.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClubRepository extends JpaRepository<Club, UUID> {

    List<Club> findAll();
    Optional<Club> findById(UUID clubId);
    void deleteById(UUID uuid);
}
