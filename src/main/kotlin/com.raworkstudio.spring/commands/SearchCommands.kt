package com.raworkstudio.spring.commands

import com.raworkstudio.spring.configurations.CommandCacheProvider
import com.raworkstudio.spring.models.History
import com.raworkstudio.spring.models.getPackageName
import com.raworkstudio.spring.parsers.JSoupParserImpl
import org.springframework.shell.core.CommandMarker
import org.springframework.shell.core.annotation.CliAvailabilityIndicator
import org.springframework.shell.core.annotation.CliCommand
import org.springframework.shell.core.annotation.CliOption
import org.springframework.stereotype.Component
import java.util.*



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

        var cache = CommandCacheProvider()

        // get input -> search on cache
        if (cache.existsOnCache(name)) {
            //  -> if exists -> return compile string
            println(cache.get(name))


//
//            if (cache.get(name) is List<*>) {
//
//            }

//            val clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard()
//            clpbrd.setContents("...", null)
        } else {
            // -> if doesn't exists -> search from mvnrepo -> return options

            val artifactMap: HashMap<String, History>

            val parser = JSoupParserImpl()

            artifactMap = parser.queryArtifacts(name)

            println("---------------------------------------------")
            artifactMap.forEach { s, history ->
                println("${history.artifact} |  ${history.getPackageName()}")
            }
            println("---------------------------------------------")


            //
            //
            //           -> select from options
            //                      -> save reference
        }


    }



}
