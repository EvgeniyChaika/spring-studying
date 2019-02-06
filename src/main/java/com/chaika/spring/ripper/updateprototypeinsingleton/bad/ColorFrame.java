package com.chaika.spring.ripper.updateprototypeinsingleton.bad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by echaika on 06.02.2019
 */
@Component
class ColorFrame extends JFrame {

    /**
     * Don't do like this! Bean depends on root context(Spring logic), but needs only changing Color.class(business logic)
     */
    private ApplicationContext applicationContext;

    @Autowired
    public ColorFrame(ApplicationContext applicationContext) throws HeadlessException {
      this.applicationContext = applicationContext;
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(700));
        getContentPane().setBackground(applicationContext.getBean(Color.class));
        repaint();
    }
}
