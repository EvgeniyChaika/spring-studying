package com.chaika.spring.ripper.components;

import com.chaika.spring.ripper.annotations.InjectRandomInt;
import com.chaika.spring.ripper.interfaces.Quoter;

/**
 * Created by echaika on 04.02.2019
 */
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
