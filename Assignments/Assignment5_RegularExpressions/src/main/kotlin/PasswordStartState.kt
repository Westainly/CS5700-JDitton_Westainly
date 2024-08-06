class PasswordStartState(detector: PasswordDetector) : PasswordState(detector) {
    override val isAccepting: Boolean
        get() = false

    override fun consumeInput(string: String) {
        if (string in "!@#\$%&*") {
            detector.state = PasswordSpecialState(detector)
        } else if (string in "QWERTYUIOPLKJHGFDSAZXCVBNM") {
            detector.state = PasswordCapitalState(detector)
        }


    }
}