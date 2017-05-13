package com.matchilling.path

import com.matchilling.path.Entity.Coordinate
import com.matchilling.path.Entity.Puzzle
import org.junit.Assert
import org.junit.Test

internal class PuzzleTest {
    @Test
    fun testFindPathStartEndIdentically() {
        val puzzle = Puzzle(arrayOf(
                intArrayOf(1, 1),
                intArrayOf(1, 0)
        ))
        val puzzleSolver = PuzzleSolver()

        Assert.assertTrue(puzzleSolver.solve(puzzle, Coordinate(0, 0), Coordinate(0, 0)))
    }

    @Test
    fun testFindPath2x2grid() {
        val puzzle = Puzzle(arrayOf(
                intArrayOf(1, 1),
                intArrayOf(1, 0)
        ))
        val puzzleSolver = PuzzleSolver()

        Assert.assertTrue(puzzleSolver.solve(puzzle, Coordinate(0, 0), Coordinate(1, 1)))
    }

    @Test
    fun testFindPath3x3grid() {
        val puzzle = Puzzle(arrayOf(
                intArrayOf(2, 1, 2),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 1, 1)
        ))
        val puzzleSolver = PuzzleSolver()

        Assert.assertTrue(puzzleSolver.solve(puzzle, Coordinate(0, 0), Coordinate(0, 1)))
    }

    @Test
    fun testFindPath5x5grid() {
        val puzzle = Puzzle(arrayOf(
                intArrayOf(4, 0, 2, 0, 4),
                intArrayOf(0, 1, 0, 0, 0),
                intArrayOf(0, 0, 1, 0, 0),
                intArrayOf(0, 2, 1, 0, 0),
                intArrayOf(0, 1, 1, 1, 1)
        ))
        val puzzleSolver = PuzzleSolver()

        Assert.assertTrue(puzzleSolver.solve(puzzle, Coordinate(0, 0), Coordinate(1, 2)))
    }

    @Test
    fun testFindPath10x10grid() {
        val puzzle = Puzzle(arrayOf(
                intArrayOf(7, 4, 4, 6, 6, 3, 2, 2, 6, 8),
                intArrayOf(3, 3, 6, 5, 4, 3, 7, 2, 8, 3),
                intArrayOf(4, 1, 6, 6, 2, 4, 4, 4, 7, 4),
                intArrayOf(4, 5, 3, 4, 3, 5, 4, 4, 8, 5),
                intArrayOf(5, 1, 4, 6, 6, 5, 0, 7, 1, 4),
                intArrayOf(2, 6, 9, 4, 9, 7, 7, 9, 1, 4),
                intArrayOf(3, 5, 4, 0, 6, 4, 5, 5, 5, 6),
                intArrayOf(6, 6, 2, 3, 4, 7, 1, 2, 3, 3),
                intArrayOf(3, 5, 4, 3, 6, 5, 4, 5, 2, 6),
                intArrayOf(3, 9, 3, 5, 1, 1, 5, 4, 6, 0)
        ))
        val puzzleSolver = PuzzleSolver()
        val response = puzzleSolver.solve(puzzle, Coordinate(0, 0), Coordinate(9, 9))
        val solution = "(0,0), (0,7), (2,7), (6,7), (1,7), (1,5), (1,2), (7,2), (7,4), (7,8), (4,8), (5,8), (5,9), (9,9)"

        Assert.assertTrue(response)
        Assert.assertEquals(formatSolution(puzzleSolver.getSolution()), solution)
    }
}