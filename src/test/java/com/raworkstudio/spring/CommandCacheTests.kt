package com.raworkstudio.spring

import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test

/**
 * Created by Ivan on 4/1/2017.
 */
class CommandCacheTests : AbstractShellIntegrationTest() {


    @Before
    fun setUp() {
        // implement setup
    }

    @Test
    fun `Check if file exists`(): Unit {

        val commandCache = CommandCacheProvider()

        MatcherAssert.assertThat("The cache file exists", commandCache.exists() == true)
    }



}