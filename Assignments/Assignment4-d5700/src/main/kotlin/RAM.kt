package org.example

@OptIn(ExperimentalUnsignedTypes::class)
class RAM {

    private val memory = UByteArray(4 * 1024)
    fun write(index: Int, newVal: UByte)
    {
        memory[index] = newVal
    }

    fun read(index: Int): UByte
    {
        if (index < this.memory.size) {
            return this.memory[index]
        }
        throw IndexOutOfBoundsException("$index is outside of bounds of memory size ${this.memory.size}")
    }
}