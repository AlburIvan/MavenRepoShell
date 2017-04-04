package com.raworkstudio.spring.parsers

import com.raworkstudio.spring.configurations.BuildSystemEnum
import com.raworkstudio.spring.models.History
import java.util.*

/**
 * Created by Ivan Alburquerque on 4/4/2017.
 */
class JSoupParserImpl : Parser {




    override fun queryArtifacts(query: String): HashMap<String, History> {

        var artifactsMap = HashMap<String, History>()


        var document = getWebPageDocument(query)

        var div_mainContent = document.getElementById("maincontent")

        var li_resultItemList = div_mainContent.getElementsByClass("im")

        li_resultItemList?.forEach { it ->

            val history = History()

            if ((it.childNodeSize() > 1)) {
                history.artifact = it.child(1).child(0).child(1).text()
                history.url =  it.child(0).attr("href")
                history.preference = 0

                artifactsMap.put(history.hashCode().toString(), history)
            }
        }

        return artifactsMap
    }

    override fun queryArtifactVersions(query: String): HashMap<String, String> {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getArtifact(version: String, buildSystem: BuildSystemEnum): String {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }




}