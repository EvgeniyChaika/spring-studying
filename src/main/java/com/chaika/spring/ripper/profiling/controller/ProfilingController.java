package com.chaika.spring.ripper.profiling.controller;

import com.chaika.spring.ripper.profiling.interfaces.ProfilingControllerMBean;

/**
 * Created by echaika on 04.02.2019
 */
public class ProfilingController implements ProfilingControllerMBean {
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
