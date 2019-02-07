package com.chaika.spring.scheduling;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import static java.time.LocalDateTime.now;

/**
 * Created by echaika on 07.02.2019
 */
@Configuration
@EnableScheduling
public class Clock {

    @Scheduled(cron = "* * 12 * * ?")
    @Scheduled(cron = "0/3 * * * * *?")
    @Scheduled(cron = "0/10 * * * * ?")
    public void wakeUp() {
        System.out.println("Time - " + now().getSecond());
    }

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext("com.chaika.spring.scheduling");
    }
}
