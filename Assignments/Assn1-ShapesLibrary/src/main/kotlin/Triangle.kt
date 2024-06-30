import kotlin.math.abs

class Triangle(private var point1: Point, private var point2: Point, private var point3: Point) {
    init {
        require(getArea() != 0.0) { "A triangle must not have an area of 0" }
    }

    fun getPoints(): Triple<Point, Point, Point> = Triple(point1, point2, point3)

    fun getArea(): Double {
        return abs((point1.xCoord * (point2.yCoord - point3.yCoord) + point2.xCoord * (point3.yCoord - point1.yCoord) + point3.xCoord * (point1.yCoord - point2.yCoord)) / 2.0)
    }

    fun move(deltaX: Double, deltaY: Double) {
        point1.move(deltaX, deltaY)
        point2.move(deltaX, deltaY)
        point3.move(deltaX, deltaY)
    }
}
