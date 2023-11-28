package com.badminton.shuttlestats.controller;

import com.badminton.shuttlestats.model.Player;
import com.badminton.shuttlestats.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    public PlayerController() {}

    @GetMapping("/")
    public ResponseEntity<List<Player>> getAllPlayers() {
        return new ResponseEntity<>(playerService.findAllPlayers(), HttpStatus.OK);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<Player> getPlayer(@PathVariable String playerId)
    {
        Optional<Player> playerOptional = playerService.getPlayerById(playerId);

        return playerOptional.map(player -> new ResponseEntity<>(player, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        try {
            Player savedPlayer = playerService.savePlayer(player);
            return new ResponseEntity<>(savedPlayer, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        try {
            Player updatedPlayer = playerService.updatePlayer(player.getPlayerId(), player);
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete={playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable String playerId) {
        try {
            playerService.deletePlayer(playerId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
