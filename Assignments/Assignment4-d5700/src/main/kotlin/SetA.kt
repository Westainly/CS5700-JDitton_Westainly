package org.example

class SetA: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        computerFacade.setA((((firstByte.toInt() and 0xF).toString(16)
                + (secondByte.toInt() shr 4).toString(16)
                + (secondByte.toInt() and 0xF).toString(16)).toInt(16)))
    }
}