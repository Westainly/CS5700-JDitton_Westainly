import kotlin.math.abs

class Square(private var topLeft: Point, private var sideLength: Double) {
    init {
        require(sideLength > 0) { "A square cannot have 0 width or height" }
    }

    fun getPoints(): Pair<Point, Point> {
        return Pair(topLeft, Point(topLeft.xCoord + sideLength, topLeft.yCoord - sideLength))
    }

    fun getArea(): Double {
        return abs(sideLength * sideLength)
    }

    fun move(deltaX: Double, deltaY: Double) {
        topLeft.move(deltaX, deltaY)
    }    
}
