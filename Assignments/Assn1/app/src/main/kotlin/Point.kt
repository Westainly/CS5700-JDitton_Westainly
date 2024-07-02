data class Point(var xCoord: Double, var yCoord: Double) {
    fun clone(): Point {
        return Point(xCoord, yCoord)
    }

    fun move(deltaX: Double, deltaY: Double) {
        xCoord += deltaX
        yCoord += deltaY
    }
}
