package board

internal data class Square(private var value: Any) {
    fun setValue(newValue: Any) {
        this.value = newValue
    }

    fun getValue(): Any {
        return this.value
    }
}
