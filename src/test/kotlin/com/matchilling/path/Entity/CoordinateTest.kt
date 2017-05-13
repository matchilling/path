package com.matchilling.path.Entity

import org.junit.Assert
import org.junit.Test

internal class CoordinateTest {
    @Test
    fun testEquals() {
        val c1 = Coordinate(1, 0)
        val c2 = Coordinate(1, 0)
        Assert.assertTrue(c1 == c2)
        Assert.assertTrue(c1 === c1)
        Assert.assertTrue(c1 !== c2)

        val c3 = Coordinate(1, 1)
        val c4 = Coordinate(1, 0)
        Assert.assertFalse(c3 == c4)
        Assert.assertFalse(c3 === c4)

        val c5 = Coordinate(1, 0)
        val c6 = Coordinate(1, 1)
        Assert.assertFalse(c5 == c6)
        Assert.assertFalse(c5 === c6)

        val c7 = Coordinate(0, 1)
        val c8 = Coordinate(1, 1)
        Assert.assertFalse(c7 == c8)
        Assert.assertFalse(c7 === c8)

        val c9 = Coordinate(1, 1)
        val c10 = Coordinate(0, 1)
        Assert.assertFalse(c9 == c10)
        Assert.assertFalse(c9 === c10)
    }

    @Test
    fun testHashCode() {
        val loc01 = Coordinate(1, 0)
        val loc02 = Coordinate(0, 1)

        Assert.assertEquals(loc01.hashCode(), loc01.hashCode())
        Assert.assertNotEquals(loc01.hashCode(), loc02.hashCode())
    }

}