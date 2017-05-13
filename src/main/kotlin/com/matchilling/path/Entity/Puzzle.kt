package com.matchilling.path.Entity

import java.io.File

class Puzzle(val grid: Array<IntArray>) {

    /**
     * Copy of the original grid used for tracking the state of the visited locations
     */
    val notes: Array<IntArray> = Array(grid.size, { IntArray(grid.size) })

    init {
        for (i in 0..grid.size - 1)
            for (j in 0..grid[i].size - 1)
                this.notes[i][j] = grid[i][j]
    }

    /**
     * Determine whether or not a given [Coordinate] on the [Puzzle]'s grid has been visited or not.
     */
    fun hasBeenVisited(coordinate: Coordinate): Boolean = notes[coordinate.row][coordinate.column] == -1

    /**
     * Determine whether or not a given [Coordinate] is safe, that means exist, on the [Puzzle]'s grid.
     */
    fun isOnGrid(coordinate: Coordinate): Boolean {
        val row: Boolean = when (coordinate.row) {
            in 0..grid[0].size - 1 -> true
            else -> false
        }
        if (!row) return false

        val col: Boolean = when (coordinate.column) {
            in 0..grid[1].size - 1 -> true
            else -> false
        }
        if (!col) return false

        return true
    }

    /**
     * Mark a position on the [Puzzle]'s grid as viewed.
     */
    fun markAsVisited(coordinate: Coordinate): Unit {
        notes[coordinate.row][coordinate.column] = -1
    }

    /**
     * Returns the move points from a given [Coordinate] on the [Puzzle]'s grid.
     */
    fun movePointsAt(coordinate: Coordinate): Int = grid[coordinate.row][coordinate.column]

    /**
     * Returns a string representation of the [Puzzle].
     */
    override fun toString(): String {
        val response = StringBuilder()

        (0..(grid.size) - 1).forEach({ x ->
            (0..(grid[x].size) - 1).forEach({ y ->
                // Add a separator between each value but not if it is the last one in a row
                if (grid[x].size - 1 == y) response.append(grid[x][y].toString())
                else response.append(grid[x][y].toString() + ' ')
            })
            response.append("\n")
        })

        return response.toString()
    }

    companion object PuzzleFactory {
        /**
         * Create a [Puzzle] from a puzzle definition file.
         */
        fun create(file: File, delimiter: Char = ' '): Puzzle {
            val size = file.bufferedReader().readLine().split(delimiter).size
            val grid = Array(size, { IntArray(size) })

            var index = 0
            file.forEachLine {
                grid.set(index, it.split(delimiter).map(String::toInt).toIntArray())
                index += 1
            }

            return Puzzle(grid)
        }
    }
}