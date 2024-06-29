import kotlin.math.sqrt

class Line(private var point1: Point, private var point2: Point) {
    init {
        require(point1 != point2) { "A line cannot have 0 length" }
    }

    fun getPoints(): Pair<Point, Point> = Pair(point1, point2)

    fun getSlope(): Double {
        return (point2.yCoord - point1.yCoord) / (point2.xCoord - point1.xCoord)
    }

    fun getLength(): Double {
        return sqrt((point2.xCoord - point1.xCoord).pow(2) + (point2.yCoord - point1.yCoord).pow(2))
    }

    fun move(deltaX: Double, deltaY: Double) {
        point1.move(deltaX, deltaY)
        point2.move(deltaX, deltaY)
    }
}
