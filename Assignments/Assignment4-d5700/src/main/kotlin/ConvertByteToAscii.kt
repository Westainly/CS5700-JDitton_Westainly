package org.example

class ConvertByteToAscii: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        computerFacade.convertByteToAscii(firstByte.toInt() and 0xF, secondByte.toInt() shr 4)
    }
}