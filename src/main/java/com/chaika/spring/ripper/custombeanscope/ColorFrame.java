package com.chaika.spring.ripper.custombeanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by echaika on 06.02.2019
 */
@Component
abstract class ColorFrame extends JFrame {

    @Autowired
    public ColorFrame() throws HeadlessException {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(700));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor();
}
