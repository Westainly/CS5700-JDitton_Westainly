package org.example

class Add : InstructionTemplate(){
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {

        val firstValue =  computerFacade.getRegisterValue(firstByte.toInt() and 0xF)?.toInt()
        val secondValue =  computerFacade.getRegisterValue(secondByte.toInt() shr 4)?.toInt()

        if (firstValue != null && secondValue != null)
        {
            // println("First value:  ${firstValue} ")
            // println("Second value:  ${secondValue} ")
            computerFacade.modifyRegister(secondByte.toInt() and 0xF, (firstValue + secondValue).toUByte())
        }
    }
}