package com.raworkstudio.spring

import org.springframework.shell.Bootstrap

import java.io.IOException

/**
 * Driver class to run the helloworld example.

 * @author Mark Pollack
 */
object Main {

    /**
     * Main class that delegates to Spring Shell's Bootstrap class in order to simplify debugging inside an IDE
     * @param args
     * *
     * @throws IOException
     */
    @Throws(IOException::class)
    @JvmStatic fun main(args: Array<String>) {
        Bootstrap.main(args)
    }

}