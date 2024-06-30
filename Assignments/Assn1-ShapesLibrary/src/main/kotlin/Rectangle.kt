class Rectangle(private var topLeftPoint: Point, private var bottomRightPoint: Point) {
    init {
        require(topLeftPoint.xCoord != bottomRightPoint.xCoord && topLeftPoint.yCoord != bottomRightPoint.yCoord) { "A rectangle cannot have 0 width or height" }
    }

    fun getPoints(): Pair<Point, Point> = Pair(topLeftPoint, bottomRightPoint)

    fun getArea(): Double {
        return (bottomRightPoint.xCoord - topLeftPoint.xCoord) * (bottomRightPoint.yCoord - topLeftPoint.yCoord)
    }

    fun move(deltaX: Double, deltaY: Double) {
        topLeftPoint.move(deltaX, deltaY)
        bottomRightPoint.move(deltaX, deltaY)
    }
}
