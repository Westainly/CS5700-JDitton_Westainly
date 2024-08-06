class BinaryOneState(detector: BinaryDetector) : BinaryState(detector) {
    override val isAccepting: Boolean
        get() = true

    override fun consumeInput(string: String) {
        if (string in "0") {
            detector.state = BinaryZeroState(detector)
        } else if (string in "1") {
            //noop
        } else{
            detector.state = InvalidState(detector)
        }
    }
}