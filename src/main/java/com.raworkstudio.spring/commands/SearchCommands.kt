package com.raworkstudio.spring.commands

import com.raworkstudio.spring.CommandCache
import org.springframework.shell.core.CommandMarker
import org.springframework.shell.core.annotation.CliAvailabilityIndicator
import org.springframework.shell.core.annotation.CliCommand
import org.springframework.shell.core.annotation.CliOption
import org.springframework.stereotype.Component

/**
 * Created by Ivan Alburquerque on 3/27/2017
 */
@Component
open class SearchCommands : CommandMarker {

    companion object {
        val TAG: String = SearchCommands::class.java.simpleName
    }


    val isCommandAvailable: Boolean
        @CliAvailabilityIndicator("hello")
        get() = true


    @CliCommand(value = "mvnhello", help = "Prints a simple hello world message")
    fun commandHelloWorld(): String {
        return "Hello World from class " + TAG
    }

    @CliCommand(value = "mvnsh")
    fun commandSearch(
            @CliOption(key = arrayOf("", "a", "artifact"), mandatory = true, help = "The name of the artifact you're searching for!") name: String) {

        // here we have to
        var commandCache = CommandCache()
        commandCache.put(name)
//        println(commandCache.fileCache?.absolutePath)


    }



}
