package com.chaika.spring.ripper.components;

import com.chaika.spring.ripper.interfaces.Quoter;

/**
 * Created by echaika on 04.02.2019
 */
public class TerminatorQuoter implements Quoter {

    private String message;

    @Override
    public void sayQuote() {
        System.out.println("message = " + message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
