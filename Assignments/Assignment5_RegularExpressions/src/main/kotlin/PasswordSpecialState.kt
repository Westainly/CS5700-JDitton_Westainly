class PasswordSpecialState(detector: PasswordDetector) : PasswordState(detector) {
    override val isAccepting: Boolean
        get() = false

    override fun consumeInput(string: String) {
        if (string in "QWERTYUIOPLKJHGFDSAZXCVBNM") {
            detector.state = PasswordValidState(detector)
        }
    }
}