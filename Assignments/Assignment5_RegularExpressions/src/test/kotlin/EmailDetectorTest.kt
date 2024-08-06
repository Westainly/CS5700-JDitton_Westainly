import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class EmailDetectorTest {

    @Test
    fun detect() {
        val detector = EmailDetector()
        assertTrue(detector.detect("a@b.c"))
        assertTrue(detector.detect("joseph.ditton@usu.edu"))
        assertTrue(detector.detect("{}*\$.&\$*(@*\$%&.*&*"))



        assertFalse(detector.detect("@b.c"))
        assertFalse(detector.detect("a@b@c.com"))
        assertFalse(detector.detect("a.b@b.b.c"))
        assertFalse(detector.detect("joseph ditton@usu.edu"))
        assertFalse(detector.detect(""))
    }
}