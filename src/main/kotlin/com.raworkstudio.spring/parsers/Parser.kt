package com.raworkstudio.spring.parsers

import com.raworkstudio.spring.configurations.BuildSystemEnum
import com.raworkstudio.spring.models.History
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.util.*

/**
 * Created by Ivan on 3/30/2017.
 */
interface Parser {

    //https://mvnrepository.com/search?q=butterknife
    public fun queryArtifacts(query: String): HashMap<String, History>

    //https://mvnrepository.com/artifact/com.jakewharton/butterknife
    public fun queryArtifactVersions(query: String): HashMap<String, String>

    public fun getArtifact(version: String, buildSystem: BuildSystemEnum): String


    public fun getWebPageDocument(query: String): Document {
       return Jsoup.connect("https://mvnrepository.com/search?q=$query").get()
    }

}