package org.example

class SkipEqual: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        // println("First value: ${computerFacade.getRegisterValue(firstByte.toInt() and 0xF)}")
        // println("Second value: ${computerFacade.getRegisterValue(secondByte.toInt() shr 4)}")
        if (computerFacade.getRegisterValue(firstByte.toInt() and 0xF) == computerFacade.getRegisterValue(secondByte.toInt() shr 4))
        {
            println("Skipping the instruction...")
            computerFacade.setP(computerFacade.getP() + 2)
        }
    }
}