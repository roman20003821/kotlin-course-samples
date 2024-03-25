package edu.ukma.lecture2

data class User(
    val name: String,
    val age: Int
) {
    var valid: Boolean = true
}

fun main() {
    val john = User("John", 25)
    // Мутабельність змінних приводить до помилок виконання програми, тому часто краще використовувати копіювання
    john.copy(age = 26)

    val john2 = User("John", 25)
    println(john == john2) // True

    john2.valid = false
    println(john == john2) // True, до автозгенерованих методів беруться до уваги лише властивості з головного конструктора
}

