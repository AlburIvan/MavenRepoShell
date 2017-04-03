package com.raworkstudio.spring.configurations

import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.raworkstudio.spring.models.CommandHistory
import com.raworkstudio.spring.models.History
import java.io.File
import java.io.FileNotFoundException
import java.util.*


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

    private var gson: Gson = GsonBuilder().setPrettyPrinting().create()

    private var commandHistory: CommandHistory


    init {
        commandHistory = getFileAsObject()
    }


    public fun put(artifact: String) {
        // TODO: improvement: we should implement an algorithm to correct any typos and possible matches

        val history = commandHistory.history.find { it.artifact.contains(artifact, true)}
        if (history != null) {
            history.preference.plus(1)
        } else {
            commandHistory.history.add(History(artifact, "", 0))
        }
    }


    /**
     * deletes an entry of the command history
     */
    public fun delete(artifact: String) {
        val history = commandHistory.history.find { it.artifact.contains(artifact, true)}
        if (history != null) {
            commandHistory.history.remove(history)
        }
    }


    // TODO change performance of this function, we should only write to file whatever was modified instead of whole file
    public fun save() {
        if (exists()) {
            getFile().printWriter().use { out ->
                out.print(gson.toJson(commandHistory.history, ArrayList<History>().javaClass))
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

        try {
            fileCache = File(CACHE_FILE_PATH)
        }
        catch (e: FileNotFoundException) {
            print(e.message)
        }

        return fileCache as File
    }

    /**
     * Returns the instance of the cache file as a manipulable json object
     */
    public fun getFileAsObject(): CommandHistory {
        commandHistory = CommandHistory()
        commandHistory.history = gson.fromJson<ArrayList<History>>(getFile().readText())

        return commandHistory
    }

}