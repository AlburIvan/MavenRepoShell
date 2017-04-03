package com.raworkstudio.spring.commands

import com.raworkstudio.spring.CommandCacheProvider
import com.raworkstudio.spring.parsers.SeleniumParserImpl
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

    // TODO implement cache
    @CliCommand(value = "mvnsh")
    fun commandSearch(
            @CliOption(key = arrayOf("", "a", "artifact"), mandatory = true, help = "The name of the artifact you're searching for!") name: String,
            @CliOption(key = arrayOf("f", "favorite"), mandatory = false, help = "....", specifiedDefaultValue = "true") favorite: String?) {



//        if(favorite == null)
//            println(favorite)


        println(name)

        var commandCache = CommandCacheProvider()

        if (commandCache.exists()) {
            println("file exists")
        }

        commandCache.put("butterknife")

        // get input -> search on cache
        //                      -> if exists -> return compile string
        //                      -> if doesn't exists -> search from mvnrepo -> return options
        //           -> select from options
        //                      -> save reference


//        var parser = SeleniumParserImpl()
//
//        parser.queryArtifacts(name)



    }



}
