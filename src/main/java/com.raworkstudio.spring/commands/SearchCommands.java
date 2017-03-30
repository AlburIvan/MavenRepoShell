package com.raworkstudio.spring.commands;

import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.stereotype.Component;

/**
 * Created by Ivan Alburquerque on 3/27/2017
 */
@Component
public class SearchCommands implements CommandMarker {

    public static final String TAG = SearchCommands.class.getSimpleName();


    @CliAvailabilityIndicator({"hello"})
    public boolean isCommandAvailable() {
        return true;
    }

    @CliCommand(value = "mvnsh hello", help = "Prints a simple hello world message")
    public String commandHelloWorld() {
        return "Hello World from class " + TAG;
    }





}
