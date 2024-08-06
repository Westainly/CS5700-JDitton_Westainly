class EmailValidState(detector: EmailDetector) : EmailState(detector) {
    override val isAccepting: Boolean
        get() = true

    override fun consumeInput(string: String) {
        if (string in "@. "){
            detector.state = InvalidState(detector)
        }
    }
}