package com.badminton.shuttlestats.controller;

import com.badminton.shuttlestats.model.Club;
import com.badminton.shuttlestats.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    public ClubController() {}

    @GetMapping("/")
    public ResponseEntity<List<Club>> getAllClubs() {
        return new ResponseEntity<List<Club>>(clubService.findAllClubs(), HttpStatus.OK );
    }

    @GetMapping("/{clubId}")
    public ResponseEntity<Club> getClub(@PathVariable UUID clubId) {
        Optional<Club> clubOptional = clubService.getClubById(clubId);

        return clubOptional.map(club -> new ResponseEntity<>(club, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/add")
    public ResponseEntity<Club> addClub(@RequestBody Club club) {
        try {
            Club savedClub = clubService.saveClub(club);
            return new ResponseEntity<>(savedClub, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
