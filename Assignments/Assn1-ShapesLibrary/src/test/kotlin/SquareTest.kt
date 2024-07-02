
import kotlin.test.*

class SquareTest {
    @Test
    fun testSquare() {
        val topLeft = Point(1.0, 1.0)
        val sideLength = 3.0
        val square = Square(topLeft, sideLength)

        assertEquals(Pair(topLeft, Point(4.0, 4.0)), square.getPoints())
        assertEquals(9.0, square.getArea())

        square.move(1.0, 1.0)
        assertEquals(Pair(Point(2.0, 2.0), Point(5.0, 5.0)), square.getPoints())
    }
    
}