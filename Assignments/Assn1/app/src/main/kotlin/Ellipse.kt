import kotlin.math.PI

open class Ellipse(private var center: Point, private var radiusX: Double, private var radiusY: Double) {
    init {
        require(radiusX > 0 && radiusY > 0) { "An ellipse cannot have an area of 0" }
    }

    fun getAttributes(): Triple<Point, Double, Double> = Triple(center, radiusX, radiusY)

    fun getArea(): Double = PI * radiusX * radiusY

    fun move(deltaX: Double, deltaY: Double) { 
        center.move(deltaX, deltaY)
    }
}
