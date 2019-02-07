package com.chaika.spring.conditional.components;


import com.chaika.spring.conditional.annotations.GodMode;
import org.springframework.stereotype.Component;

/**
 * Created by echaika on 07.02.2019
 */
@Component
@GodMode(false)
public class PlayerRepositoryImpl implements PlayerRepository {

    @Override
    public Player getPlayer() {
        Player player = new Player();
        player.setStamina(98);
        return player;
    }
}
