package com.chaika.spring.ripper.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by echaika on 06.02.2019
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {

    Class newImpl();
}
