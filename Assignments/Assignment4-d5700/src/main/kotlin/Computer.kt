package org.example

import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit


class Computer {
    private val executor = Executors.newSingleThreadScheduledExecutor()
    private var cpuFuture : ScheduledFuture<*>? = null

    private var cpuTCounter: ScheduledFuture<*>? = null

    private var rom = ROM()
    private val cpu = CPU()
    private var ram = RAM()
    private var screen = Screen()

    val instructions: Map<Int, InstructionTemplate> = mapOf(
        0 to Store(),
        1 to Add(),
        2 to Sub(),
        3 to Read(),
        4 to Write(),
        5 to Jump(),
        6 to ReadKeyboard(),
        7 to SwitchMemory(),
        8 to SkipEqual(),
        9 to SkipNotEqual(),
        10 to SetA(),
        11 to SetT(),
        12 to ReadT(),
        13 to ConvertToBase10(),
        14 to ConvertByteToAscii(),
        15 to Draw(),
    )

    fun pause()
    {
        cpuFuture?.cancel(true)
    }

    @OptIn(ExperimentalUnsignedTypes::class, ExperimentalStdlibApi::class)
    fun loadInROM()
    {
        println("Type in the path to the rom file:")
        val inputString: String = readln()
        val file = File(inputString).readBytes().map {it.toUByte()}.toUByteArray()
        rom.load(file)
    }

    fun stop()
    {
        cpuFuture?.cancel(true)
        try {
            cpuFuture?.get()
        } catch (_: Exception) {
            executor.shutdown()
        }

    }

    fun TCounter()
    {
        val counter = Runnable {
            try {
                if (getT() > 0)
                {
                    setT(getT() - 1)
                }
            }
            catch (e: Exception)
            {
                println("There was an exception when decrementing T! : $e")
            }
        }
        cpuTCounter = executor.scheduleAtFixedRate(counter,
            0,
            (1000L / 62.5).toLong(),
            TimeUnit.MILLISECONDS )
    }

    fun startCPU()
    {
        val cpu = Runnable {
            try {
                val byte1 = rom.read(cpu.p)
                val byte2 = rom.read(cpu.p + 1)
                if (byte1.toInt() == 0 && byte2.toInt() == 0)
                {
                    stop()
                }

                instructions[byte1.toInt() shr 4]?.executeInstruction(byte1, byte2, this)
            }
            catch (e: Exception)
            {
                println("There was an exception! : $e")
            }
        }
        cpuFuture = executor.scheduleAtFixedRate(cpu,
            0,
            1000L / 500L,
            TimeUnit.MILLISECONDS )
        TCounter()
    }

    fun getRegisterValue(register: Int): UByte?
    {
        return cpu.registers[register]
    }

    fun modifyRegister(register: Int, newVal: UByte)
    {
        cpu.changeRegisterValue(register, newVal)
    }

    fun setP(newVal: Int)
    {
       cpu.setP(newVal)
    }

    fun drawToScreen(rX: Int, row: Int, column: Int)
    {
        val byte: UByte = getRegisterValue(rX) ?: throw IllegalArgumentException("Attempting to draw null item to screen!")
        ram.write(row * 8 + column, byte)

        screen.drawToScreen(byte, row, column)
    }

    fun getP(): Int
    {
        return cpu.p
    }

    fun setA(a: Int)
    {
        cpu.setA(a)
    }

    fun setT(t: Int)
    {
        cpu.setT(t.toUInt())
    }

    fun getT(): Int{
        return cpu.t.toInt()
    }

    fun convertByteToAscii(registerFrom: Int, registerTo: Int)
    {
        var data = getRegisterValue(registerFrom)?.toInt()

        if (data != null)
        {
            if (data > 15)
            {
                throw IllegalArgumentException("Value in register was greater than the limit for converting to ASCII!!!")
            }

            if (data < 10)
            {
                data += 48
            }
            else
            {
                data += 55
            }
            cpu.changeRegisterValue(registerTo, data.toUByte())
        }
    }

    fun write(register: Int)
    {
        val registerVal = getRegisterValue(register)

        if (registerVal != null) {
            if (!cpu.m) {
                ram.write(cpu.a, registerVal)
            } else {
                rom.write(cpu.a, registerVal)
            }
        }
    }

    fun read(register: Int)
    {
            if (!cpu.m) {
                val data =  ram.read(cpu.a)
                modifyRegister(register, data)
            }
            else {
                val data = rom.read(cpu.a)
                modifyRegister(register, data)
            }
    }

    fun convertBase10(register: Int)
    {
        val data = getRegisterValue(register)?.toInt()

        val hundreds = (data?.div(100))?.toUByte()
        val tens = ((data?.div(10)?.rem(10)))?.toUByte()
        val ones = (data?.rem(10))?.toUByte()

        if (!cpu.m)
        {
            if (hundreds != null) {
                ram.write(cpu.a, hundreds)
            }
            if (tens != null) {
                ram.write(cpu.a + 1, tens)
            }
            if (ones != null) {
                ram.write(cpu.a + 2, ones)
            }
        }
        else {
            if (hundreds != null) {
                rom.write(cpu.a, hundreds)
            }
            if (tens != null) {
                rom.write(cpu.a + 1, tens)
            }
            if (ones != null) {
                rom.write(cpu.a + 2, ones)
            }
        }
    }

    fun switchMemory()
    {
        cpu.setM()
    }




}