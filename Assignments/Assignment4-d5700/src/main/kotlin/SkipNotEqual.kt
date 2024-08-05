package org.example

class SkipNotEqual: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        if (computerFacade.getRegisterValue(firstByte.toInt() and 0xF)
            != computerFacade.getRegisterValue(secondByte.toInt() shr 4))
        {
            computerFacade.setP(computerFacade.getP() + 2)
        }
    }
}