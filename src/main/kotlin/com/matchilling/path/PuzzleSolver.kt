package com.matchilling.path

import com.matchilling.path.Entity.Coordinate
import com.matchilling.path.Entity.Puzzle
import java.util.*
import kotlin.collections.ArrayList

class PuzzleSolver {
    private var solved = false
    private val solution = Stack<Coordinate>()

    /**
     * Determine whether or not a move to a given [Coordinate] is valid on a [Puzzle] or not.
     */
    private fun isValid(puzzle: Puzzle, coordinate: Coordinate, end: Coordinate): Boolean {
        if (coordinate == end) return true
        return puzzle.movePointsAt(coordinate) != -1
    }

    fun getSolution(): ArrayList<Coordinate> = ArrayList(solution)

    /**
     * Determine whether or not a given [Puzzle]'s is solvable
     */
    fun solve(puzzle: Puzzle, start: Coordinate, end: Coordinate): Boolean {
        val loc = start
        val movePoints = puzzle.movePointsAt(start)

        if (solution.empty() && !solved) solution.push(start)
        if (solved) return true
        if (loc == end) {
            puzzle.markAsVisited(loc)
            solved = true
            return true
        }

        val top = Coordinate(loc.row - movePoints, loc.column)
        if (puzzle.isOnGrid(top) && !puzzle.hasBeenVisited(top) && isValid(puzzle, top, end)) {
            puzzle.markAsVisited(top)
            solution.push(top)
            return solve(puzzle, top, end)
        }

        val right = Coordinate(loc.row, loc.column + movePoints)
        if (puzzle.isOnGrid(right) && !puzzle.hasBeenVisited(right) && isValid(puzzle, right, end)) {
            puzzle.markAsVisited(right)
            solution.push(right)
            return solve(puzzle, right, end)
        }

        val bottom = Coordinate(loc.row + movePoints, loc.column)
        if (puzzle.isOnGrid(bottom) && !puzzle.hasBeenVisited(bottom) && isValid(puzzle, bottom, end)) {
            puzzle.markAsVisited(bottom)
            solution.push(bottom)
            return solve(puzzle, bottom, end)
        }

        val left = Coordinate(loc.row, loc.column - movePoints)
        if (puzzle.isOnGrid(left) && !puzzle.hasBeenVisited(left) && isValid(puzzle, left, end)) {
            puzzle.markAsVisited(left)
            solution.push(left)
            return solve(puzzle, left, end)
        }

        solution.pop()
        return solve(puzzle, solution.peek(), end)
    }

}