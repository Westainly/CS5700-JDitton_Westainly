import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PasswordDetectorTest {

    @Test
    fun detect() {
        val detector = PasswordDetector()
        assertTrue(detector.detect("aaaaH!aa"))
        assertTrue(detector.detect("1234567*9J"))
        assertTrue(detector.detect("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH"))



        assertFalse(detector.detect("a"))
        assertFalse(detector.detect("aaaaaaa!"))
        assertFalse(detector.detect("aaaHaaaaa"))
        assertFalse(detector.detect("Abbbbbbb!"))
        assertFalse(detector.detect(""))
    }
}