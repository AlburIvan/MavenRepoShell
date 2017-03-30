package com.raworkstudio.spring;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultPromptProvider;
import org.springframework.stereotype.Component;

/**
 * Created by Ivan Alburquerque on 3/27/2017.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomPromptProvider extends DefaultPromptProvider {

    @Override
    public String getPrompt() {
        return "mvnsh-shell>";
    }


    @Override
    public String getProviderName() {
        return "My prompt provider";
    }

}
