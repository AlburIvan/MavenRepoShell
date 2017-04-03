package com.raworkstudio.spring.configurations

import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.shell.plugin.support.DefaultPromptProvider
import org.springframework.stereotype.Component

/**
 * Created by Ivan Alburquerque on 3/31/2017.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
open class CustomPromptProvider : DefaultPromptProvider() {

    override fun getProviderName(): String {
        return "My prompt provider"
    }

    override fun getPrompt(): String {
        return "mvn-shell>"
    }
}