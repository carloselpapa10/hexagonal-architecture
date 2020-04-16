package com.example.librarydemo.web.driver_adapter;

import com.example.librarydemo.application.boundary.IReactToCommands;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SpringMvcDriver {

    private final IReactToCommands driverPort;

    public void reactTo(Object command) {
        driverPort.reactTo(command);
    }
}
