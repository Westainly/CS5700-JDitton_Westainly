class PasswordValidState(detector: PasswordDetector) : PasswordState(detector) {
    override val isAccepting: Boolean
        get() = true

    override fun consumeInput(string: String) {
        if (string in "!@#\$%&*") {
            detector.state = PasswordAlmostValidState(detector)
        }


    }
}