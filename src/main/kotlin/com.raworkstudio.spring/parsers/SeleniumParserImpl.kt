package com.raworkstudio.spring.parsers

import com.raworkstudio.spring.configurations.BuildSystemEnum
import com.raworkstudio.spring.models.History
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import java.util.*

/**
 * Created by Ivan on 3/30/2017.
 */
class SeleniumParserImpl : Parser {

    private var driver: ChromeDriver? = null
//            get() = FirefoxDriver()


    init {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ivan Alburquerque\\Downloads\\Others\\chromedriver_win32\\chromedriver.exe")
//        var capabilities = DesiredCapabilities.chrome()
//        capabilities.setCapability("    ", "--no-startup-window")
        driver = ChromeDriver()
    }


    override fun queryArtifacts(query: String): HashMap<String, History> {

        var artifactMap = HashMap<String, History>()

        driver?.get("https://mvnrepository.com/")

        var searchBar = driver?.findElement(By.id("query"))
        var searchButton = driver?.findElement(By.className("button"))

        searchBar?.sendKeys(query)
        searchButton?.click()


        // get total result founds

//        var _driver = WebDriverWait


//        var _wait = WebDriverWait(driver, 300000)
//
//        _wait.until { d ->
//            d.findElement(By.ById("Id_Your_UIElement"))
//        }

        var div_mainContent = driver?.findElementById("maincontent")

        var resultItemList = div_mainContent?.findElements(By.className("im"))

        resultItemList?.forEach { it ->

            var history = History()

            history.artifact = it.findElement(By.cssSelector("#maincontent > div:nth-child(2) > div.im-header > h2 > a:nth-child(2)")).text
            history.url = it.findElement(By.cssSelector("#maincontent > div:nth-child(2) > div.im-header > h2 > a:nth-child(2)")).getAttribute("href")
            history.preference = 0

            artifactMap.put(history.hashCode().toString(), history)
        }

        return artifactMap
    }

    override fun queryArtifactVersions(query: String): HashMap<String, String> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun getArtifact(version: String, buildSystem: BuildSystemEnum): String {
        throw UnsupportedOperationException("not implemented")
    }
}