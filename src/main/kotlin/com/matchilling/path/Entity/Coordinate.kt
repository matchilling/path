package com.matchilling.path.Entity

data class Coordinate(val row: Int, val column: Int) {
    /**
     * Indicates whether a given object is "equal to" this one.
     *
     * If the given object is an instance of [Coordinate] then equality is determined by
     * comparision of [Coordinate.column] and [Coordinate.row] values.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass !== javaClass) return false

        val coordinate: Coordinate = other as Coordinate
        return this.hashCode() == coordinate.hashCode()
    }

    override fun hashCode(): Int = (31 * row) + column
}