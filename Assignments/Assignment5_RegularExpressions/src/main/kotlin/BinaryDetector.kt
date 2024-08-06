class BinaryDetector: Detector() {
    override var state: State = BinaryStartState(this)


    override fun detect(input: String): Boolean{
        val characters = input
            .trim()
            .split("")
            .drop(1)
            .dropLast(1)
            .toMutableList()

        for (character in characters){
            state.consumeInput(character)
        }
        val isAccepting = state.isAccepting
        state = BinaryStartState(this)
        return isAccepting
    }
}