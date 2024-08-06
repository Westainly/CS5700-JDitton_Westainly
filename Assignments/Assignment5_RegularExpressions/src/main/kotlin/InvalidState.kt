class InvalidState(detector: Detector) : State(detector) {

    override val isAccepting: Boolean
        get() = false

    override fun consumeInput(string: String) {
        //noop
    }
}