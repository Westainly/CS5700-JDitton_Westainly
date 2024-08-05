import org.example.Computer
import org.example.ConvertByteToAscii
import org.example.ConvertToBase10
import java.lang.IllegalArgumentException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestInstructions {



    @Test
    fun TestStore()
    {
        val computer = Computer()

        computer.instructions[0]?.executeInstruction(1u,2u, computer)
        assertFailsWith<IndexOutOfBoundsException> { computer.instructions[0]?.executeInstruction(8u,100u, computer)}
        assertEquals(2u ,computer.getRegisterValue(1))


    }
    @Test
    fun TestAdd()
    {
        val computer = Computer()

        computer.instructions[0]?.executeInstruction(1u,2u, computer)
        computer.instructions[0]?.executeInstruction(0u,2u, computer)
        //assertEquals(2u ,computer.getRegisterValue(1))
        computer.instructions[1]?.executeInstruction(16u,16u, computer)
        //  assertFailsWith<IndexOutOfBoundsException> { computer.instructions[1]?.executeInstruction(8u,100u, computer)}
        assertEquals(4u ,computer.getRegisterValue(0))
    }

    @Test
    fun TestSub()
    {
        val computer = Computer()

        computer.instructions[0]?.executeInstruction(1u,2u, computer)
        computer.instructions[0]?.executeInstruction(0u,16u, computer)
        //assertEquals(2u ,computer.getRegisterValue(1))
        computer.instructions[2]?.executeInstruction(16u,16u, computer)
        //  assertFailsWith<IndexOutOfBoundsException> { computer.instructions[1]?.executeInstruction(8u,100u, computer)}
        assertEquals(14u ,computer.getRegisterValue(0))
    }
    @OptIn(ExperimentalUnsignedTypes::class)
    @Test
    fun TestReadAndWrite()
    {
        val computer = Computer()
        computer.instructions[0]?.executeInstruction(1u,2u, computer)
        computer.instructions[0]?.executeInstruction(0u,5u, computer)
        // RAM
        // Writing
        computer.instructions[4]?.executeInstruction(1u,0u, computer)

        // Testing through read operation
        computer.instructions[3]?.executeInstruction(2u,0u, computer)
        assertEquals(2u, computer.getRegisterValue(2))
        // ROM
        // Writing
        computer.switchMemory()
        computer.instructions[4]?.executeInstruction(0u,0u, computer)

        // Testing through read operation
        computer.instructions[3]?.executeInstruction(3u,0u, computer)
        assertEquals(5u, computer.getRegisterValue(3))


    }
    @Test
    fun TestJump()
    {

        val computer = Computer()
        // Setting the program counter to be '212', but converts to decimal for byte representation
        computer.instructions[5]?.executeInstruction(18u,18u, computer)
        assertEquals("212".toInt(16) ,computer.getP())
        assertFailsWith<IllegalArgumentException> { computer.instructions[5]?.executeInstruction(18u,17u, computer) }

    }
    @Test
    fun TestReadKeyboard()
    {
        // NOTE: Can't test this without mocking readLine() in the method. Not really sure how to do that :/
    }
    @Test
    fun TestSwitchMemory()
    {
        val computer = Computer()
        assertEquals(false, computer.getM())
        computer.instructions[7]?.executeInstruction(0u,0u, computer)
        assertEquals(true, computer.getM())
    }
    @Test
    fun TestSkipEqual()
    {
        val computer = Computer()
        // Not equal, so don't skip
        computer.instructions[0]?.executeInstruction(1u,2u, computer)
        computer.instructions[0]?.executeInstruction(0u,16u, computer)
        computer.instructions[8]?.executeInstruction(0u, 16u, computer)
        assertEquals(6, computer.getP())
        // Equal, so do skip
        computer.instructions[0]?.executeInstruction(1u,16u, computer)
        computer.instructions[8]?.executeInstruction(0u, 16u, computer)
        assertEquals(12, computer.getP())
    }
    @Test
    fun TestSkipNotEqual()
    {
        val computer = Computer()
        // Not equal, so skip
        computer.instructions[0]?.executeInstruction(1u,2u, computer)
        computer.instructions[0]?.executeInstruction(0u,16u, computer)
        computer.instructions[9]?.executeInstruction(0u, 16u, computer)
        assertEquals(8, computer.getP())
        // Equal, so do skip
        computer.instructions[0]?.executeInstruction(1u,16u, computer)
        computer.instructions[9]?.executeInstruction(0u, 16u, computer)
        assertEquals(12, computer.getP())
    }
    @Test
    fun TestSetA()
    {
        val computer = Computer()
        // Setting the Address to be '212', but converts to decimal for byte representation
        computer.instructions[10]?.executeInstruction(42u,52u, computer)
        assertEquals("A34".toInt(16) ,computer.getA())
    }
    @Test
    fun TestSetT()
    {
        val computer = Computer()
        // Setting the Address to be '212', but converts to decimal for byte representation
        computer.instructions[11]?.executeInstruction(42u,52u, computer)
        assertEquals("A3".toInt(16) ,computer.getT())
    }
    @Test
    fun TestReadT()
    {
        val computer = Computer()
        computer.instructions[11]?.executeInstruction(42u,52u, computer)
        computer.instructions[12]?.executeInstruction(0u, 0u, computer)
        assertEquals("A3".toInt(16), computer.getRegisterValue(0)?.toInt())
    }
    @Test
    fun TestConvertToBase10()
    {
        val computer = Computer()
        computer.instructions[0]?.executeInstruction(0u,112u, computer)
        computer.instructions[13]?.executeInstruction(0u, 0u, computer)
        computer.instructions[3]?.executeInstruction(1u, 0u, computer)
        computer.setA(computer.getA() + 1)
        computer.instructions[3]?.executeInstruction(2u, 0u, computer)
        computer.setA(computer.getA() + 1)
        computer.instructions[3]?.executeInstruction(3u, 0u, computer)
        computer.setA(computer.getA() - 2)

        assertEquals(1u, computer.getRegisterValue(1))
        assertEquals(1u, computer.getRegisterValue(2))
        assertEquals(2u, computer.getRegisterValue(3))

        // Switch to separate memory
        computer.switchMemory()
        computer.instructions[0]?.executeInstruction(0u,112u, computer)
        computer.instructions[13]?.executeInstruction(0u, 0u, computer)
        computer.instructions[3]?.executeInstruction(1u, 0u, computer)
        computer.setA(computer.getA() + 1)
        computer.instructions[3]?.executeInstruction(2u, 0u, computer)
        computer.setA(computer.getA() + 1)
        computer.instructions[3]?.executeInstruction(3u, 0u, computer)
        computer.setA(computer.getA() - 2)

        assertEquals(1u, computer.getRegisterValue(1))
        assertEquals(1u, computer.getRegisterValue(2))
        assertEquals(2u, computer.getRegisterValue(3))

    }
    @Test
    fun TestConvertByteToAscii()
    {
        val computer = Computer()
        computer.instructions[0]?.executeInstruction(0u,2u, computer)
        //assertEquals(2u ,computer.getRegisterValue(1))
        computer.instructions[14]?.executeInstruction(16u,16u, computer)
        //  assertFailsWith<IndexOutOfBoundsException> { computer.instructions[1]?.executeInstruction(8u,100u, computer)}
        assertEquals(50u ,computer.getRegisterValue(1))

        computer.instructions[0]?.executeInstruction(0u,14u, computer)

        computer.instructions[14]?.executeInstruction(16u,16u, computer)

        assertEquals(69u ,computer.getRegisterValue(1))

        computer.instructions[0]?.executeInstruction(0u,17u, computer)

        assertFailsWith<IllegalArgumentException> {computer.instructions[14]?.executeInstruction(16u,16u, computer)}
    }
    @Test
    fun TestDraw()
    {
        val computer = Computer()
        computer.instructions[0]?.executeInstruction(0u, 2u, computer)
        computer.instructions[0]?.executeInstruction(1u, 6u, computer)
        computer.instructions[15]?.executeInstruction(0u, 0u, computer)
        computer.instructions[15]?.executeInstruction(1u, 1u, computer)
        computer.instructions[3]?.executeInstruction(2u, 0u, computer)
        computer.setA(computer.getA() + 1)
        computer.instructions[3]?.executeInstruction(3u, 0u, computer)
        computer.setA(computer.getA() - 1)
        assertEquals(2u, computer.getRegisterValue(2))
        assertEquals(6u, computer.getRegisterValue(3))
        assertEquals(2u, computer.getScreenValue(0,0))
        assertEquals(6u, computer.getScreenValue(0,1))
        assertFailsWith<IllegalArgumentException> {computer.getScreenValue(8,8)  }
        computer.instructions[0]?.executeInstruction(1u, 213u, computer)
        assertFailsWith<IllegalArgumentException> {computer.instructions[15]?.executeInstruction(1u, 1u, computer) }

        // Showing if we attempt to draw out of bounds
        assertFailsWith<IllegalArgumentException> {computer.instructions[15]?.executeInstruction(1u, 196u, computer) }
    }
}