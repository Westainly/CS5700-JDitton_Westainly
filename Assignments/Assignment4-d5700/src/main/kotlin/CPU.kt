package org.example

class CPU {

    var p: Int = 0x0
        private set
    var t: UInt = 0u
        private set

    var a: Int = 0x0
        private set

    var m: Boolean = false
        private set

    var registers: MutableList<UByte?> = MutableList(8) {0u}

    fun changeRegisterValue(register: Int, newVal: UByte)
    {
        //println("Before modification: ${registers[register]}")
        registers[register] = newVal
        //println("After modification: ${registers[register]}")
    }

    fun setP(newVal: Int)
    {
        this.p = newVal
    }
    fun setT(newVal: UInt)
    {
        this.t = newVal
    }
    fun setA(newVal: Int)
    {
        this.a = newVal
    }
    fun setM()
    {
        this.m = !this.m
    }
}