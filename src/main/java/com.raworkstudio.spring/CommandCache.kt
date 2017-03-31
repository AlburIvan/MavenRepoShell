package com.raworkstudio.spring

import com.google.gson.Gson
import java.io.File

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
class CommandCache () {

    var fileCache: File


    // store file here
    /*

    {
        "artifact": "",
        "url": ""
        "preference": ""
    }
    ,
    {
        "artifact": "butterknife",
        "url": "https://mvnrepository.com/artifact/com.jakewharton/butterknife"
        "preference": "3"
    }
    ,
    {
        "artifact": "butterknife-annotations",
        "url": "https://mvnrepository.com/artifact/com.jakewharton/butterknife-annotations"
        "preference": "1"
    }


     */


    fun put(artifact: String) {

        // search for value
        //
        // if it doesn't exist insert it
        //
        // if exist return the highest value


    }


    fun exists(artifact: String):Boolean {
        return File("./cache/cmd.cache").exists()
    }


    fun delete(artifact: String) {

    }

    fun save() {
        fileCache.printWriter().use { out ->
            out.println("")
        }
    }

    init {
        fileCache = File("./cache/cmd.cache")

        var gson = Gson()

//        gson.fromJson(fileCache.readText())
//        File("./cache/cmd.cache").printWriter().use { out ->
//            out.println("File readed")
//        }

        //var fileCache = File
        println("javaClass = $javaClass")
    }


}