package com.example.tennisplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    @GetMapping("/players")
    public List<Player> getAllPlayer() {
        System.out.println("Get all players...");
        return playerService.getAllPlayer();
    }

    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable int id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping("/players")
    public int addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }
    @PutMapping("/players/{id}")
    public int updatePlayer(@PathVariable int id, @RequestBody Player player) {
        return playerService.updatePlayer(id, player);
    }

    @PatchMapping("/players/{id}")
    public int updatePartialsTitles(@PathVariable int id, @RequestBody Map<String, Object> player) {
        // log
        System.out.println("Update partials titles...");
        return playerService.updatePartialsTitles(id, player);
    }
    @PatchMapping("/players/{id}/titles")
    public int updateTitles(@PathVariable int id, @RequestBody int titles) {
        return  playerService.updateTitles(id, titles);
    }

}
