package com.badminton.shuttlestats.service;

import com.badminton.shuttlestats.model.Club;
import com.badminton.shuttlestats.repository.ClubRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

    @Transactional
    public Club saveClub(Club clubDetails) {
        validateClub(clubDetails);

        Club toSave = new Club(clubDetails.getClubName(), clubDetails.getPublicVisibility(), clubDetails.getClubDescription());
        return clubRepository.save(toSave);
    }

    @Transactional
    public Club updateClub(Club clubDetails) {
        if (clubDetails == null) {
            throw new IllegalArgumentException("Club can not be null");
        }
        validateClub(clubDetails);

        Optional<Club> optionalClub = clubRepository.findById(clubDetails.getClubId());

        if (optionalClub.isEmpty()) {
            throw new NoSuchElementException("Club not found with ID: " + clubDetails.getClubId());
        }

        Club existingClub = optionalClub.get();

        existingClub.setClubName(clubDetails.getClubName());
        existingClub.setPublicVisibility(clubDetails.getPublicVisibility());
        existingClub.setClubDescription(clubDetails.getClubDescription());

        return clubRepository.save(existingClub);
    }

    @Transactional
    public void deleteClub(UUID clubId) {
        Optional<Club> optionalClub = clubRepository.findById(clubId);
        if(optionalClub.isPresent()) {
            clubRepository.deleteById(clubId);
        }
        else {
            throw new NoSuchElementException("Club not found with ID: " + clubId);
        }
    }

    public void validateClub(Club club) {
        if (club == null) {
            throw new IllegalArgumentException();
        }

        if(club.getClubName().matches(".*[=()/\\\\{}\\[\\]?].*")) {
            throw new IllegalArgumentException("Illegal character found in club name");
        }

//        if(club.getCreationDate().isBefore(LocalDate.of(2010, 1, 1))) {
//            throw new IllegalArgumentException("Date is prior to 2010-01-01");
//        }

        if(club.getClubDescription().matches(".*[=()/\\\\{}\\[\\]?].*")) {
            throw new IllegalArgumentException("Illegal character found in club description");
        }
    }


}
