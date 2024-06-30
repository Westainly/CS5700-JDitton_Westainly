class Circle(center: Point, radius: Double) : Ellipse(center, radius, radius) {
    init {
        require(radius > 0) { "A circle cannot have an area of 0" }
    }
}
