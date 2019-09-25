package board

internal data class Square(private var value: String) {
    fun setValue(newValue: String) {
        this.value = newValue
    }

    fun getValue(): String {
        return this.value
    }
}
