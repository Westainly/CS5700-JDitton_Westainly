class PasswordCapitalState(detector: PasswordDetector) : PasswordState(detector) {
    override val isAccepting: Boolean
        get() = false

    override fun consumeInput(string: String) {
        if (string in "!@#\$%&*") {
            detector.state = PasswordAlmostValidState(detector)
        }


    }
}