import org.example.Computer
import org.example.ConvertByteToAscii
import org.example.ConvertToBase10
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

    }
    @Test
    fun TestRead()
    {

    }
    @Test
    fun TestWrite()
    {

    }
    @Test
    fun TestJump()
    {

    }
    @Test
    fun TestReadKeyboard()
    {

    }
    @Test
    fun TestSwitchMemory()
    {

    }
    @Test
    fun TestSkipEqual()
    {

    }
    @Test
    fun TestSkipNotEqual()
    {

    }
    @Test
    fun TestSetA()
    {

    }
    @Test
    fun TestSetT()
    {

    }
    @Test
    fun TestReadT()
    {

    }
    @Test
    fun TestConvertToBase10()
    {

    }
    @Test
    fun TestConvertByteToAscii()
    {

    }
    @Test
    fun TestDraw()
    {

    }







}