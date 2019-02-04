package com.chaika.spring.ripper.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by echaika on 04.02.2019
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {
    int min();

    int max();
}
