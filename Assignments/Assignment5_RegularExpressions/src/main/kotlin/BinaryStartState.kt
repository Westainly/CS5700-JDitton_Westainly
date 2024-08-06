class BinaryStartState(detector: BinaryDetector) : BinaryState(detector) {
    override val isAccepting: Boolean
        get() = false

    override fun consumeInput(string: String) {
        if (string in "1") {
            detector.state = BinaryOneState(detector)
        } else {
            detector.state = InvalidState(detector)
        }
    }
}