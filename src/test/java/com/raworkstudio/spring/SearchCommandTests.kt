package com.raworkstudio.spring

import com.raworkstudio.spring.commands.SearchCommands
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.springframework.shell.core.CommandResult

/**
 * Created by Ivan Alburquerque on 3/30/2017
 */
class SearchCommandTests : AbstractShellIntegrationTest() {


    @Test fun `Expects output of Hello World Given an initial state`() {

        val commandResult = AbstractShellIntegrationTest.getShell().executeCommand("mvnhello")

        MatcherAssert
                .assertThat("Hello command expects 'hello'",
                        commandResult.result.toString() == "Hello World from class " + SearchCommands.TAG)
    }


    @Test fun `Given an artifact name, When the artifact equals 'x', Then a list of artifact names should be returned`() {

    }

    @Test fun expects_a_list_of_artifact_version() {

    }


}
