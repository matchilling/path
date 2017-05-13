package com.matchilling.path.Entity

import org.junit.Assert
import org.junit.Test
import java.io.File

internal class PuzzleFactoryTest {
    @Test
    fun testCreateFromFile() {
        val file = File("src/test/resources/example_10x10.txt")
        Assert.assertTrue(Puzzle.create(file) is Puzzle)
    }
}