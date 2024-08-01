package org.example

class SetT: InstructionTemplate() {
    @OptIn(ExperimentalStdlibApi::class)
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
      //  println("First byte: ${firstByte.toHexString()}")
      //  println("Second byte: ${secondByte.toHexString()}")
      //  println("Setting t to: ${((firstByte.toInt() and 0xF) or (secondByte.toInt() shr 4)).toUByte()}")
        computerFacade.setT((((firstByte.toInt() and 0xF).toString(16) + (secondByte.toInt() shr 4).toString(16)).toInt(16)))
    }
}