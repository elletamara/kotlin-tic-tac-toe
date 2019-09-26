package board

internal class Square(private var value: String) {
    fun setValue(newValue: String) {
        this.value = newValue
    }

    fun getValue(): String = this.value

    fun copy(): Square = Square(getValue())
}
