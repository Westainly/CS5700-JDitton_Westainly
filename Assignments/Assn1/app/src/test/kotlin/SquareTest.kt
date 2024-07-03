import kotlin.test.*

internal class SquareTest {

    @Test
    fun testSquareCreation() {
        val topLeft = Point(1.0, 1.0)
        val sideLength = 3.0
        val square = Square(topLeft, sideLength)

        assertEquals(Pair(topLeft, Point(4.0, -2.0)), square.getPoints())
        assertEquals(9.0, square.getArea())
    }

    @Test
    fun testSquareMoving() {
        val topLeft = Point(1.0, 1.0)
        val sideLength = 3.0
        val square = Square(topLeft, sideLength)

        square.move(1.0, 1.0)
        assertEquals(Pair(Point(2.0, 2.0), Point(5.0, -1.0)), square.getPoints())
    }
    
    @Test
    fun testSquareWithZeroSideLength() {
        val topLeft = Point(1.0, 1.0)
        
        assertFailsWith<IllegalArgumentException> {
            Square(topLeft, 0.0)
        }
    }
}