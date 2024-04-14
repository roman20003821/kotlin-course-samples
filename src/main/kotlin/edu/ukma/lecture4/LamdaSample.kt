package edu.ukma.lecture4

fun main() {
    // Підняття елементів списку до квадрату
    listOf(1, 2, 3, 4).map { it * it }

    // Видалити імена, які починаються на A
    listOf("Anna", "John", "Alina", "Matthew", "Olexandr").filterNot { it.startsWith("a", ignoreCase = true) }

    // Сума квадратів усіх елементів списку
    listOf(1, 2, 3, 4).fold(0) { acc, i -> acc + i * i }

    // Ітерація по всіх елементах списку, якщо в лямбді потрібно мати індекс елементу, окрім його значення, то можна використовувати forEachIndexed
    listOf(1, 2, 3, 4).forEach { println(it) }
    // З усіх елементів списку створити один (наприклад суму). Якщо список пустий, то викидає помилку. Щоб обробляти такі випадки можна використовувати reduceOrNull
    listOf(1, 2, 3, 4).reduce { acc, i -> i }
    // Пошук першого елемента, який відповідає заданому предикату. Існує версія first, яка при не знаходженні елемента, викидає помилку
    listOf(1, 2, 3, 4).firstOrNull { it % 2 == 0 }
    // Групування елементів списку в мапу, key -> list<value>
    listOf(1, 2, 3, 4).groupBy { it % 2 == 0 }
    // Пошук найбільшого елемента списку за його властивістю
    listOf(1, 2, 3, 4).maxBy { it.hashCode() }
    // Пошук елемента з можливістю задати власний компаратор у лямбда виразі
    listOf(1, 2, 3, 4).binarySearch { 0 }
}

fun functionReferenceSample() {
    // Видалити імена, які починаються на A
    listOf("Anna", "John", "Alina", "Matthew", "Olexandr").filterNot(::namesFilter)
}

private fun namesFilter(name: String): Boolean {
    return name.startsWith("a", ignoreCase = true)
}
