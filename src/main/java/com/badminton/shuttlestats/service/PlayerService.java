package com.badminton.shuttlestats.service;

import com.badminton.shuttlestats.model.Player;
import com.badminton.shuttlestats.model.enums.Gender;
import com.badminton.shuttlestats.model.enums.MainHand;
import com.badminton.shuttlestats.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(String uuid) {
        return playerRepository.findById(uuid);
    }

    public Player savePlayer(Player playerDetails) {
        validatePlayer(playerDetails);

        Player toSave = new Player(playerDetails.getFirstName(), playerDetails.getLastName(), playerDetails.getGender(), playerDetails.getMainHand());
        return playerRepository.save(toSave);
    }

    public Player updatePlayer(UUID playerId, Player playerDetails) {
        if(playerDetails == null) {
            throw new IllegalArgumentException("Player can not be null");
        }
        validatePlayer(playerDetails);

        Optional<Player> optionalPlayer = playerRepository.findById(playerId);

        if (optionalPlayer.isEmpty()) {
            throw new NoSuchElementException("Player not found with ID: " + playerId);
        }

        Player existingPlayer = optionalPlayer.get();

        existingPlayer.setFirstName(playerDetails.getFirstName());
        existingPlayer.setLastName(playerDetails.getLastName());
        existingPlayer.setGender(playerDetails.getGender());
        existingPlayer.setMainHand(playerDetails.getMainHand());

        return playerRepository.save(existingPlayer);
    }

    public void deletePlayer(String playerId) {
        Optional<Player> optionalPlayer = playerRepository.findById(UUID.fromString(playerId));
        if(optionalPlayer.isPresent()) {
            playerRepository.deleteById(playerId);
        }
        else {
            throw new NoSuchElementException("Player not found with ID: " + playerId);
        }
    }

    public void validatePlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException();
        }

        if(player.getFirstName().matches(".*[=()/\\\\{}\\[\\]&*:!?].*") ||
        player.getLastName().matches(".*[=()/\\\\{}\\[\\]&*:!?].*")) {
            throw new IllegalArgumentException("Illegal character found in name");
        }

        if(!(player.getGender().equals(Gender.MALE.toString())) && !(player.getGender().equals(Gender.FEMALE.toString()))) {
            throw new IllegalArgumentException("Invalid gender type");
        }

        if(!(player.getMainHand().equals(MainHand.RIGHT.toString())) && !(player.getMainHand().equals(MainHand.LEFT.toString()))) {
            throw new IllegalArgumentException("Invalid main hand");
        }
    }

}
