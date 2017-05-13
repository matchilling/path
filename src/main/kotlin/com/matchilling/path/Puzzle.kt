package com.matchilling.path

import com.matchilling.path.Entity.Coordinate
import com.matchilling.path.Entity.Puzzle
import java.io.File
import java.util.*
import javax.swing.JFileChooser
import javax.swing.JFrame

fun chooseFile(frame: JFrame): File? {
    val chooser = JFileChooser()

    chooser.showOpenDialog(frame)
    frame.dispose()

    return chooser.selectedFile
}

fun formatSolution(solution: ArrayList<Coordinate>): String {
    if (solution.isEmpty()) return ""

    val response = StringBuffer()

    for (i in solution.indices) {
        response.append("(${solution[i].row},${solution[i].column})")
        if (i !== solution.lastIndex) response.append(", ")
    }

    return response.toString()
}

fun main(args: Array<String>): Unit {
    val file = chooseFile(JFrame()) ?: return Unit
    val puzzle = Puzzle.create(file)
    val solver = PuzzleSolver()

    when (solver.solve(puzzle, Coordinate(0, 0), Coordinate(9, 9))) {
        true -> {
            println(formatSolution(solver.getSolution()))
        }
        else -> println("OMG, an unsolvable puzzle ¯\\_(ツ)_/¯")
    }
}