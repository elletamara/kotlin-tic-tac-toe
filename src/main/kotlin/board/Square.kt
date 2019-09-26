package board

internal class Square(private var value: String) {
    fun setValue(newValue: String) {
        this.value = newValue
    }

    fun getValue(): String {
        return this.value
    }

    fun copy(): Square {
        return Square(getValue())
    }
}
