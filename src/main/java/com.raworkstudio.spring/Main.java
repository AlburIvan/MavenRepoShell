package com.raworkstudio.spring;

import org.springframework.shell.Bootstrap;

import java.io.IOException;

/**
 * Driver class to run the helloworld example.
 *
 * @author Mark Pollack
 *
 */
public class Main {

    /**
     * Main class that delegates to Spring Shell's Bootstrap class in order to simplify debugging inside an IDE
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Bootstrap.main(args);

    }

}