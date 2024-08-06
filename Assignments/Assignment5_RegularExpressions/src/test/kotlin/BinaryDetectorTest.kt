import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BinaryDetectorTest {

    @Test
    fun detect() {
        val detector = BinaryDetector()
        assertTrue(detector.detect("1"))
        assertTrue(detector.detect("11"))
        assertTrue(detector.detect("101"))
        assertTrue(detector.detect("111111"))
        assertTrue(detector.detect("10011010001"))


        assertFalse(detector.detect("01"))
        assertFalse(detector.detect("10"))
        assertFalse(detector.detect("1000010"))
        assertFalse(detector.detect("100a01"))
        assertFalse(detector.detect(""))
    }
}