package com.example.tennisplayer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    List<Player> getAllPlayer(){
        System.out.println("Get all players");
        return playerRepository.findAll();
    }

    Player getPlayerById(int id){
        System.out.println("Get player by id");
        // optional
        Optional<Player> tempPlayer = playerRepository.findById(id);
        Player p = null;

        //if the Optional has a value, assign it to p
        if(tempPlayer.isPresent())
            p = tempPlayer.get();

        return p;
    }
    int addPlayer(Player player){
        System.out.println("Add player");
        playerRepository.save(player);
        return player.getId();
    }
    int updatePlayer(int id, Player p){
        System.out.println("Update player");
        Player updatedPlayer;
        Optional<Player> player = playerRepository.findById(id);
        // check exits

        if(player.isEmpty()) {
            throw new PlayerBadRequestException("Bad Request");
            // throw new PlayerNotFoundException("Player with id {"+ id +"} not found");
        }
        // update
        updatedPlayer = player.get();
        updatedPlayer.setName(p.getName());
        updatedPlayer.setNationality(p.getNationality());
        updatedPlayer.setBirthDate(p.getBirthDate());
        updatedPlayer.setTitles(p.getTitles());
        playerRepository.save(updatedPlayer);


        return updatedPlayer.getId();
    }
    int updatePartialsTitles(int id, Map<String, Object> p){
        System.out.println("Update partials titles");
        Player updatedPlayer;
        Optional<Player> player = playerRepository.findById(id);
        // check exits
        if(player.isEmpty()) {
            return -1;
        }
        // update with reflection
        p.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(Player.class, k);
            if(field != null) {
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, player.get(), v);
            }
        });


        return playerRepository.save(player.get()).getId();
    }

    //update a single field
    @Transactional
    public int updateTitles(int id, int titles) {
        Optional<Player> tempPlayer = playerRepository.findById(id);

        if(tempPlayer.isEmpty())
            throw new RuntimeException("Player with id {"+ id +"} not found");

        playerRepository.updateTitles(id, titles);
        return id;
    }


}
