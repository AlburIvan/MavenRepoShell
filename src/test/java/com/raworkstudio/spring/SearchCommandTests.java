package com.raworkstudio.spring;

import com.raworkstudio.spring.commands.SearchCommands;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.springframework.shell.core.CommandResult;

/**
 * Created by Ivan Alburquerque on 3/30/2017.
 */
public class SearchCommandTests extends AbstractShellIntegrationTest {

    @Test
    public void expects_hello_world() {

        CommandResult commandResult = getShell().executeCommand("mvnsh hello");
        System.out.println( commandResult.getResult().toString());

        MatcherAssert
                .assertThat("Hello command expects 'hello'",
                        commandResult.getResult().toString().equals("Hello World from class " + SearchCommands.TAG));
    }


}
