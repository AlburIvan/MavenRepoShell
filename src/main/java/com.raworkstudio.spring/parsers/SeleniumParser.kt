package com.raworkstudio.spring.parsers

import com.raworkstudio.spring.BuildSystemEnum
import org.openqa.selenium.By
import org.openqa.selenium.firefox.FirefoxDriver
import java.util.*

/**
 * Created by Ivan on 3/30/2017.
 */
class SeleniumParser : Parser {

//    private var driver: FirefoxDriver = null!!
//            get() = FirefoxDriver()


    init {
//        driver = FirefoxDriver()
//        driver.get("https://mvnrepository.com/")
    }


    override fun queryArtifacts(query: String): HashMap<String, String> {

        var artifactMap = HashMap<String, String>()

//        var searchBar = driver.findElement(By.id("query"))
//        var searchButton = driver.findElement(By.className("button"))


        return artifactMap
    }

    override fun queryArtifactVersions(query: String): HashMap<String, String> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun getArtifact(version: String, buildSystem: BuildSystemEnum): String {
        throw UnsupportedOperationException("not implemented")
    }
}