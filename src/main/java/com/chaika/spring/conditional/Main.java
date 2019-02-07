package com.chaika.spring.conditional;

import com.chaika.spring.conditional.components.PlayerRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * Created by echaika on 07.02.2019
 */
@Configuration
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.chaika.spring.conditional");
        System.out.println(context.getBean(PlayerRepository.class).getPlayer().getStamina());
    }
}
