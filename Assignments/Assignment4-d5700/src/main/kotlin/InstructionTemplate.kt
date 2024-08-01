package org.example

abstract class InstructionTemplate {
    fun executeInstruction(firstByte: UByte, secondByte: UByte, computerFacade: Computer)
    {
        performOperation(firstByte, secondByte, computerFacade)
        incrementCounter(computerFacade)

    }

    abstract fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer)
    open fun incrementCounter(computerFacade: Computer)
    {
        computerFacade.setP(computerFacade.getP() + 2)
    }
}