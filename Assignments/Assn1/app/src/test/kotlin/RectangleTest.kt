import kotlin.test.*

internal class RectangleTest {

    @Test
    fun testRectangle() {
        val topLeft = Point(1.0, 4.0)
        val bottomRight = Point(4.0, 1.0)
        val rectangle = Rectangle(topLeft, bottomRight)

        assertEquals(Pair(topLeft, bottomRight), rectangle.getPoints())
        assertEquals(9.0, rectangle.getArea())

        rectangle.move(1.0, 1.0)
        assertEquals(Pair(Point(2.0, 5.0), Point(5.0, 2.0)), rectangle.getPoints())
    }

    @Test
    fun testRectangleWithZeroHeight() {
        val topLeft = Point(1.0, 1.0)
        val bottomRight = Point(4.0, 1.0)
        
        assertFailsWith<IllegalArgumentException> {
            Rectangle(topLeft, bottomRight)
        }
    }

    @Test
    fun testRectangleWithZeroWidth() {
        val topLeft = Point(1.0, 4.0)
        val bottomRight = Point(1.0, 1.0)
        
        assertFailsWith<IllegalArgumentException> {
            Rectangle(topLeft, bottomRight)
        }
    }
}