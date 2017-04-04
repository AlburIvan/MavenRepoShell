package com.raworkstudio.spring.models

import com.raworkstudio.spring.configurations.BuildSystemEnum

/**
 * Created by Ivan on 4/1/2017.
 */
public data class History(
        var artifact: String = "",
        var url: String = "",
        var preference: Int = 0
)


fun History.getArtifactFQN(build: BuildSystemEnum) {

    ///artifact/com.jakewharton/butterknife-annotations
}

fun History.getPackageName(): String {
    return (this.url.replace("/artifact/", "").replace("/", "."))
}

fun History.isPreferedOver(history: History): Boolean {
    return (this.preference > history.preference)
}