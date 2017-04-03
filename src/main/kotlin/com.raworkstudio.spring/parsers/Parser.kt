package com.raworkstudio.spring.parsers

import com.raworkstudio.spring.configurations.BuildSystemEnum
import com.raworkstudio.spring.models.History
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

}