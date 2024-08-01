package org.example

class ConvertToBase10: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        computerFacade.convertBase10(firstByte.toInt() and 0xF)
    }
}