package com.raworkstudio.spring.configurations

/**
 * Created by Ivan on 3/30/2017.
 */
enum class BuildSystemEnum(var system: String = "gradle" ) {

    MAVEN("maven"),
    GRADLE("gradle"),
    SBT("sbt"),
    IVY("ivy"),
    GRAPE("grape"),
    LEININGEN("leiningen"),
    BUILDR("buildr")



}