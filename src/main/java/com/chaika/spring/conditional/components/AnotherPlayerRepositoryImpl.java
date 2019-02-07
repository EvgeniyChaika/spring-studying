package com.chaika.spring.conditional.components;

import com.chaika.spring.conditional.annotations.GodMode;
import org.springframework.stereotype.Component;

/**
 * Created by echaika on 07.02.2019
 */
@Component
@GodMode(true)
public class AnotherPlayerRepositoryImpl implements PlayerRepository {

    @Override
    public Player getPlayer() {
        Player player = new Player();
        player.setStamina(1000);
        return player;
    }
}
