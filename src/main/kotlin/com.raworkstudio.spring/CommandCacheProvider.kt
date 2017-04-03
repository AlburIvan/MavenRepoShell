package com.raworkstudio.spring

import com.google.gson.Gson
import com.raworkstudio.spring.commands.CommandHistory
import org.openqa.selenium.remote.Command
import java.io.File
import java.io.FileNotFoundException
import java.io.FileWriter
import com.google.gson.JsonElement
import com.raworkstudio.spring.commands.History
import org.openqa.selenium.firefox.FirefoxProfile.fromJson
import java.io.FileReader
import java.util.*
import org.openqa.selenium.firefox.FirefoxProfile.fromJson




@Suppress("RedundantVisibilityModifier")
/**
 * This class stores the previous commands already issued by the user and
 * use the result to give better suggestions based on previous choices
 *
 * process:
 *
 *      get command input
 *      search in the cache for the input
 *          if key found
 *              return the library chosen that time
 *          if key not found
 *              present normal options
 *              save the selection as  <input, library name, url>
 *
 *        Deserialization should happen as JSON
 *          - GSON
 */
class CommandCacheProvider() {

    companion object {
        val TAG: String = CommandCacheProvider::class.java.simpleName
    }

    /** File storage where a history of commands will be saved and read to*/
    private val CACHE_FILE_PATH: String = "./cache/cache.json"

    private var fileCache: File? = null

    private var gson: Gson = Gson()

    private var commandHistory: CommandHistory


    init {
        commandHistory = getFileAsObject()
    }


    public fun put(artifact: String) {

        var elementExists: Boolean = false
        var commandIndex: Int = 0

        // TODO: improvement: we should implement an algorithm to correct any typos and possible matches

        // search for value
        commandHistory.history
                .withIndex()
                .forEachIndexed { i, indexedValue ->
                    if (indexedValue.value.artifact.contains(artifact, true)) {
                        elementExists = true
                        commandIndex = indexedValue.index
                    }
                }

        if(elementExists) {
            var h = commandHistory.history[commandIndex].preference.plus(1)
        }
        else {
            commandHistory.history.add(History(artifact, "",0))
        }
    }


    /**
     * deletes an entry of the command history
     */
    public fun delete(artifact: String) {

        var elementExists: Boolean = false
        var commandIndex: Int = 0

        // search for value
        commandHistory.history
                .withIndex()
                .forEachIndexed { i, indexedValue ->
                    if (indexedValue.value.artifact.contains(artifact, true)) {
                        elementExists = true
                        commandIndex = indexedValue.index
                    }
                }

        if (elementExists) {
            commandHistory.history.removeAt(commandIndex)
        }
    }


    // TODO change performance of this function, we should only write to file whatever was modified instead of whole file
    public fun save() {
        if (exists()) {
            getFile().printWriter().use { out ->
                out.print(gson.toJson(commandHistory, FileWriter(CACHE_FILE_PATH)))
            }
        }
    }


    public fun exists(): Boolean {
        return getFile().exists()
    }

    /**
     * Returns the instance of the cache file
     */
    private fun getFile(): File {

        if (fileCache == null) {

            try {
                fileCache = File(CACHE_FILE_PATH)
            }
            catch (e: FileNotFoundException) {
                print(e.message)
            }
        }

        return fileCache as File
    }

    /**
     * Returns the instance of the cache file as a manipulable json object
     */
    private fun getFileAsObject(): CommandHistory {

        commandHistory.history = gson.fromJson(getFile().readText(), Array<History>::class.java)

        return commandHistory
    }

}