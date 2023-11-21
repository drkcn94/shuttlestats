package com.badminton.shuttlestats.service;

import com.badminton.shuttlestats.model.Club;
import com.badminton.shuttlestats.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public List<Club> findAllClubs() {
        return clubRepository.findAll();
    }

    public Optional<Club> getClubById(UUID clubId) {
        return clubRepository.findById(clubId);
    }

    public void deleteClub(UUID clubId) {
        Optional<Club> optionalClub = clubRepository.findById(clubId);
        if(optionalClub.isPresent()) {
            clubRepository.deleteById(clubId);
        }
        else {
            throw new NoSuchElementException("Club not found with ID: " + clubId);
        }
    }

}
