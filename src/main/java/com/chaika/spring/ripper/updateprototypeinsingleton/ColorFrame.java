package com.chaika.spring.ripper.updateprototypeinsingleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by echaika on 06.02.2019
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ColorFrame extends JFrame {

    private Color color;

    @Autowired
    public ColorFrame(Color color) throws HeadlessException {
        this.color = color;
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(700));
        getContentPane().setBackground(color);
        repaint();
    }
}
