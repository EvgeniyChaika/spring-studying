package com.chaika.spring.conditional.components;

import org.springframework.stereotype.Component;

/**
 * Created by echaika on 07.02.2019
 */
@Component
public class Player {

    private int stamina;

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
