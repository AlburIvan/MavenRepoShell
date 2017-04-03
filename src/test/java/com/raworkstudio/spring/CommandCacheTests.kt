package com.raworkstudio.spring

import com.raworkstudio.spring.configurations.CommandCacheProvider
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
        MatcherAssert.assertThat("The cache file exists", commandCache.exists())
    }

    @Test
    fun `Expects at least 1 entry after adding another element`(): Unit {

        val commandCache = CommandCacheProvider()

        val oldEntryCount = commandCache.getFileAsObject().history.count()
        println("old count: $oldEntryCount")

        commandCache.put("butterknife")
        commandCache.save()

        val newEntryCount = commandCache.getFileAsObject().history.count()
        println("new count: $newEntryCount")

        MatcherAssert.assertThat("New entry was saved successfully", (newEntryCount > oldEntryCount) )
    }


    @Test
    fun `Expects at least 1 less entry after removing an existing element`(): Unit {

        val commandCache = CommandCacheProvider()

        val oldEntryCount = commandCache.getFileAsObject().history.count()
        println("old count: $oldEntryCount")

        commandCache.delete("butterknife")
        commandCache.save()

        val newEntryCount = commandCache.getFileAsObject().history.count()
        println("new count: $newEntryCount")

        MatcherAssert.assertThat("New entry was deleted successfully", (newEntryCount < oldEntryCount) )
    }

    @Test
    fun `Expects at the same number of entries after removing a NON existing element`(): Unit {

        val commandCache = CommandCacheProvider()

        val oldEntryCount = commandCache.getFileAsObject().history.count()
        println("old count: $oldEntryCount")

        commandCache.delete("./this.does not exit$")
        commandCache.save()

        val newEntryCount = commandCache.getFileAsObject().history.count()
        println("new count: $newEntryCount")

        MatcherAssert.assertThat("The entry was not deleted because it didn't exist", (newEntryCount == oldEntryCount) )
    }



}