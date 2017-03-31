package com.raworkstudio.spring;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.shell.Bootstrap;
import org.springframework.shell.core.JLineShellComponent;


/**
 * Created by Ivan Alburquerque on 3/30/2017.
 */
public class AbstractShellIntegrationTest  {

    private static JLineShellComponent shell;


    @BeforeClass
    public static void startUp() throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        shell = bootstrap.getJLineShellComponent();
    }

    @AfterClass
    public static void shutdown() {
        shell.stop();
    }


    protected static JLineShellComponent getShell() {
        return shell;
    }



}
